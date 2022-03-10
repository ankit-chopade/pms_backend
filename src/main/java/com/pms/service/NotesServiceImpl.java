package com.pms.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pms.constant.StatusMessages;
import com.pms.dto.NoteDto;
import com.pms.dto.UserDto;
import com.pms.entity.Note;
import com.pms.model.UserNotes;
import com.pms.repository.NotesRepository;
@Service
public class NotesServiceImpl implements NotesServiceInterface{

	
	@Autowired
	NotesRepository notesRepository;
	
	@Autowired
	RestTemplate restTemplate;

	/**
	 * This service is used to save the notes
	 * 
	 * @author AbhijeetR
	 * @param noteDto
	 * @return boolean
	 * @throws AppException
	 */
	public boolean addNote(NoteDto noteDto) {
		Note note = new Note();

		note.setMessage(noteDto.getMessage());
		note.setSenderId(noteDto.getSenderId());
		note.setRecieverId(noteDto.getRecieverId());
		note.setUrgency(noteDto.isUrgency());
		note.setDate(LocalDateTime.now());
		try {
			Note noteObj = notesRepository.save(note);
			if (null != noteObj) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This service is used to get all the sent notes for sender using sender Id
	 * 
	 * @author AbhijeetR
	 * @param senderId
	 * @return List<UserNotes>
	 */
	public List<UserNotes> getSentNotes(Long senderId) throws Exception {
		//return notesRepository.getSentNotes(senderId);
		Sort sort = Sort.by("date").descending();
		List<Note> listNote =notesRepository.findAllBySenderId(senderId, sort);
		
		
		  if (null == listNote || listNote.isEmpty()) 
		  { 
			  return new ArrayList<>(); 
		  }
		 
		
		List<UserNotes> listUserNotes = new ArrayList<>();
		
		// Fetching details of the user, who has received the note to sender or logged in user
		String url = "http://localhost:8081/user/getUsersByMultipleIds?user={userId}";
		
		Map<String,String> urlMapping = new HashMap<>();
		
		urlMapping.put("userId",listNote.stream().map(notes -> notes.getRecieverId().toString()).distinct().collect(Collectors.joining(",")));
		//HttpHeaders headers = new HttpHeaders();
		
		//headers.add("Authorization", authToken);
	
		
		ResponseEntity<UserDto[]> userResponseEntity = restTemplate.getForEntity(url, UserDto[].class, urlMapping);
		
		
		//UserDto[] userDto = responseUserEntity.getBody();
		List<UserDto> userDto = Arrays.stream(userResponseEntity.getBody()).collect(Collectors.toList());
		
		//List<UserDto> listUserDto =Arrays.stream(userDto).collect(Collectors.toList());
		
		listNote.forEach(note ->{
			
			Optional<UserDto> u =userDto.stream().filter(user -> user.getUserId().compareTo(note.getRecieverId()) == 0).findFirst();
			
			if (u.isPresent()) {
				UserNotes userNotes = new UserNotes();
				userNotes.setDate(note.getDate());
				userNotes.setMessage(note.getMessage());
				userNotes.setNoteId(note.getNoteId());
				userNotes.setRecieverId(note.getRecieverId());
				userNotes.setSenderId(note.getSenderId());
				userNotes.setReply(note.getReply());
				userNotes.setUrgency(note.isUrgency());
				
				userNotes.setFirstName(u.get().getFirstName());
				userNotes.setLastName(u.get().getLastName());
				userNotes.setRole(u.get().getRole().getRole());
				
				listUserNotes.add(userNotes);
			}
			
			
		});
		
		return listUserNotes;
	}

	/**
	 * This service is used to get all received note
	 * 
	 * @author AbhijeetR
	 * @param recieverId
	 * @return List<UserNotes>
	 */
	@SuppressWarnings("unchecked")
	public List<UserNotes> getRecieveNotes(Long recieverId) throws Exception {
		List<UserNotes> userNotesList = new ArrayList<>();
		// Fetching notes received by logged in user (receiver id)
		Sort sort = Sort.by("date").descending();
		List<Note> notesList = notesRepository.findAllByRecieverId(recieverId, sort);
		
		if (null == notesList || notesList.isEmpty()) {
			return new ArrayList<>();
		}
		
		// Fetching details of the user, who has sent the note to receiver or logged in user
		String url = "http://localhost:8081/user/getUsersByMultipleIds?user={userId}";
		Map<String, String> uriVariableMap = new HashMap<>();
		uriVariableMap.put("userId", notesList.stream().map(note-> note.getSenderId().toString()).distinct().collect(Collectors.joining(",")));
		ResponseEntity<UserDto[]> userResponseEntity = restTemplate.getForEntity(url, UserDto[].class, uriVariableMap);
		
		//Converting array of UserDTO object to array list
		List<UserDto> userDto = Arrays.stream(userResponseEntity.getBody()).collect(Collectors.toList());
		
		// Populating the user note dto object from note entity and populating sender's name, designation from user dto object
		notesList.forEach((Note note) -> {
			// Filtering user list on user id and sender id from note 
			Optional<UserDto> u = userDto.stream().filter(user -> user.getUserId().compareTo(note.getSenderId()) == 0).findFirst();
			if (u.isPresent()) {
				UserNotes userNote = new UserNotes();
				userNote.setDate(note.getDate());
				
				
				userNote.setFirstName(u.get().getFirstName());
				userNote.setLastName(u.get().getLastName());
				userNote.setRole(u.get().getRole().getRole());
				
				userNote.setMessage(note.getMessage());
				userNote.setNoteId(note.getNoteId());
				userNote.setRecieverId(note.getRecieverId());
				userNote.setReply(note.getReply());
				userNote.setSenderId(note.getSenderId());
				userNote.setUrgency(note.isUrgency());
				userNotesList.add(userNote);
			}
			
		});
		return userNotesList;
		
	}

	/**
	 * This service is used to reply to the notes
	 * 
	 * @author AbhijeetR
	 * @param noteDto
	 */

	@Override
	public String reply(int noteId, String reply) {
		try {
			Optional<Note> optionalNote = notesRepository.findById(noteId);
			Note noteObj = null;
			
			if (optionalNote.isPresent()) {
				noteObj = optionalNote.get();
			} else {
				return StatusMessages.NOTE_NOT_FOUND.getMessage();
			}
			
			noteObj.setReply(reply);

			Note updatedNote = notesRepository.save(noteObj);
			if (null != updatedNote) {
				return StatusMessages.REPLY_SEND_SUCCESSFULLY.getMessage();
			} else {
				return StatusMessages.SERVER_ERROR.getMessage();
			}

		} catch (Exception e) {
			e.printStackTrace();
			return StatusMessages.SERVER_ERROR.getMessage();
		}
	}

	@Override
	public String deleteNoteById(Integer id) {
		try {
			notesRepository.deleteById(id);
			return StatusMessages.NOTE_DELETED_SUCCESSFULLY.getMessage();
		} catch (Exception e) {
			return StatusMessages.SERVER_ERROR.getMessage();
		}
		
	}

	
}
