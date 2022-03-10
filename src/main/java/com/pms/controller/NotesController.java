package com.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.constant.StatusMessages;
import com.pms.dto.MessageResponseDto;
import com.pms.dto.NoteDto;
import com.pms.model.UserNotes;
import com.pms.service.NotesServiceInterface;

@RestController
@RequestMapping("/note")
@CrossOrigin(value = "http://localhost:4200")
public class NotesController {

	@Autowired
	NotesServiceInterface notesService;

	/**
	 * This API is written to add new note
	 * 
	 * @author AbhijeetR
	 * @param noteDto
	 * @return ResponseEntity<MessageResponseDto>
	 */
	@PostMapping("/addNote")
	public ResponseEntity<MessageResponseDto> addNotes(@RequestBody @NonNull NoteDto noteDto) {

		boolean isSaved = this.notesService.addNote(noteDto);
		if (isSaved)
			return new ResponseEntity<>(new MessageResponseDto(StatusMessages.NOTE_SEND_SUCCESSFULLY.getMessage()),
					HttpStatus.OK);
		else
			return new ResponseEntity<>(new MessageResponseDto(StatusMessages.SERVER_ERROR.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * This API is written to get sent note map with senderId
	 * 
	 * @author AbhijeetR
	 * @param senderId
	 * @return List<UserNotes>
	 */
	@GetMapping(path = "/getSentNotes")
	public ResponseEntity<List<UserNotes>> getSentNotes(@RequestParam Long senderId) {


		try
		{
			List<UserNotes> userNotes = notesService.getSentNotes(senderId);
			return new ResponseEntity<>(userNotes, HttpStatus.OK);
		}
		catch(Exception e) {
			e.getMessage();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	/**
	 * This API is written to get received note
	 * 
	 * @author AbhijeetR
	 * @param senderId
	 * @return List<UserNotes>
	 */
	@GetMapping(path = "/getRecieveNotes")
	public ResponseEntity<List<UserNotes>> getRecieveNotes(@RequestParam Long recieverId){
		
		try
		{
			List<UserNotes> userNotes = notesService.getRecieveNotes(recieverId);
			return new ResponseEntity<>(userNotes, HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	/**
	 * This API is written for reply to note
	 * 
	 * @author AbhijeetR
	 * @param noteId
	 * @return ResponseEntity<MessageResponseDto>
	 */
	
	@PostMapping("/reply")
	public ResponseEntity<MessageResponseDto> reply(@RequestBody NoteDto note){
		
		try {
			String message = this.notesService.reply(note.getNoteId(),note.getReply());
		
			return new ResponseEntity<>(new MessageResponseDto(message),
						HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(new MessageResponseDto(StatusMessages.SERVER_ERROR.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/deleteNoteById")
	public ResponseEntity<MessageResponseDto> deleteNoteById(@RequestParam Integer id) {

		try {
			String message = this.notesService.deleteNoteById(id);
		
			return new ResponseEntity<>(new MessageResponseDto(message), HttpStatus.OK);
		} catch (Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity<>(new MessageResponseDto(StatusMessages.SERVER_ERROR.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
