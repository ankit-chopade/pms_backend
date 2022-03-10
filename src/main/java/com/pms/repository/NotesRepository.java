package com.pms.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.entity.Note;
import com.pms.model.UserNotes;
@Repository
public interface NotesRepository extends JpaRepository<Note, Integer>{

	@Query(value= "select n.note_id as noteId,n.message,n.reciever_id as recieverId,n.date,  n.urgency, "
			+ "u.first_name as firstName, u.last_name as lastName, u.title, r.role  from public.note n  "
			+ "join public.user_entity u on (u.user_id = n.reciever_id) "
			+ "join role r on r.role_id = u.role_id where sender_id = :senderId",nativeQuery = true)
	public List<UserNotes> getSentNotes(@Param("senderId") Long senderId);
	
	@Query(value= "select n.note_id as noteId,n.message,n.sender_id as senderId,n.date,  n.urgency, "
			+ "u.first_name as firstName, u.last_name as lastName, u.title, r.role  from public.note n  "
			+ "join public.user_entity u on (u.user_id = n.sender_id) "
			+ "join role r on r.role_id = u.role_id where reciever_id = :recieverId",nativeQuery = true)
	public List<UserNotes> getRecieveNotes(@Param("recieverId") Long recieverId);
	
	public List<Note> findAllByRecieverId(Long recieverId, Sort sort);

	public List<Note> findAllBySenderId(Long senderId, Sort sort);
	
	
	
	
	/*@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "update note n set reply = :reply where n.note_id = :noteId",nativeQuery = true)
	public void reply(@Param("noteId") Long noteId,@Param("reply") String reply);*/
	
}
