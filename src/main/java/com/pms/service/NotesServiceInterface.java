package com.pms.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.pms.dto.NoteDto;
import com.pms.model.UserNotes;

public interface NotesServiceInterface {

	public boolean addNote(NoteDto noteDto);
	public List<UserNotes> getSentNotes(Long senderId) throws Exception;
	public List<UserNotes> getRecieveNotes(Long recieverId)  throws Exception;
	public String reply(int i,String reply) throws Exception;
	public String deleteNoteById(Integer id);
	
}
