package com.pms.schedule.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pms.schedule.constants.PmsScheduleConstants;
import com.pms.schedule.converter.EditHistoryConverter;
import com.pms.schedule.converter.EditHistorySaveConverter;
import com.pms.schedule.converter.PatientAppointmentConverter;
import com.pms.schedule.dto.EditHistoryDto;
import com.pms.schedule.dto.EditHistorySaveDto;
import com.pms.schedule.dto.PatientAppointmentDto;
import com.pms.schedule.entity.EditHistoryEntity;
import com.pms.schedule.entity.PatientAppointmentEntity;
import com.pms.schedule.entity.UserEntity;
import com.pms.schedule.repository.EditHistoryRepository;
import com.pms.schedule.repository.PatientAppointmentRepository;
import com.pms.schedule.repository.UserRepository;
import com.pms.schedule.utils.CustomException;
import com.pms.schedule.utils.ErrorResponse;
import com.pms.schedule.utils.MailService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private UserRepository userrepo;

	@Autowired
	PatientAppointmentRepository patientAppointmentRepository;

	@Autowired
	EditHistoryRepository editHistoryRepository;

	@Autowired
	private MailService mailService;

	@Autowired
	PatientAppointmentConverter patientAppointmentConverter;
	
	@Autowired
	EditHistoryConverter editHistoryConverter;
	
	@Autowired
	EditHistorySaveConverter editHistorySaveConverter;

	@Override
	public List<UserEntity> getPhysician() {
		final Integer roleId = 3;
		List<UserEntity> list = userrepo.findByRoleId(roleId);
		return list;
	}

	@Override
	public PatientAppointmentDto savePatientAppointment(PatientAppointmentDto patientAppointment)
			throws CustomException {
		try {
			PatientAppointmentEntity entity = patientAppointmentConverter.toEntity(patientAppointment);
			entity.setActiveStatus(PmsScheduleConstants.ACTIVE_STATUS);
			entity.setCreatedDate(new Date());
			entity.setCreatedBy(1l);
			PatientAppointmentEntity savedEntity = patientAppointmentRepository.save(entity);
			sendMail(entity);
			return patientAppointmentConverter.toDto(savedEntity);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.RECORDNOTFOUND);
		}
	}

	@Override
	public List<PatientAppointmentDto> getPhysicianAppintments(Long Id) throws CustomException {
		List<PatientAppointmentEntity> appointemnts = patientAppointmentRepository.findByPhysicianId(Id);
		return patientAppointmentConverter.toDto(appointemnts);
	}

	@Override
	public PatientAppointmentDto editPatientAppointment(PatientAppointmentDto patientAppointment)
			throws CustomException {
		PatientAppointmentEntity appointment = patientAppointmentRepository.findByAppointmentId(patientAppointment.getAppointmentId());
		System.out.println(appointment);
		System.out.println(patientAppointment.getAppointmentId());
		appointment.setDescription(patientAppointment.getDescription());
		appointment.setEndTime(patientAppointment.getEndTime());
		appointment.setId(patientAppointment.getId());
		appointment.setIsAllDay(patientAppointment.getIsAllDay());
		appointment.setIsBlock(patientAppointment.getIsBlock());
		appointment.setIsReadonly(patientAppointment.getIsReadonly());
		appointment.setPatientId(patientAppointment.getPatientId());
		appointment.setPhysicianId(patientAppointment.getPhysicianId());
		appointment.setRecurrenceRule(patientAppointment.getRecurrenceRule());
		appointment.setStartTime(patientAppointment.getStartTime());
		appointment.setSubject(patientAppointment.getSubject());
		PatientAppointmentEntity editedEntity = patientAppointmentRepository.save(appointment);
		return patientAppointmentConverter.toDto(editedEntity);
	}

	@Transactional
	@Override
	public Long deletePhysicianAppointment(Long Id) throws CustomException {
		Long deltetedAppointment = patientAppointmentRepository.deleteByAppointmentId(Id);
		return deltetedAppointment;
	}

	@Override
	public EditHistorySaveDto saveEditHistory(EditHistorySaveDto editHistory) throws CustomException {
		try {
			
			EditHistoryEntity entity = editHistorySaveConverter.toEntity(editHistory);
			entity.setActiveStatus(PmsScheduleConstants.ACTIVE_STATUS);
			entity.setCreatedDate(new Date());
			entity.setCreatedBy(1l);
			EditHistoryEntity savedentity = editHistoryRepository.save(entity);
			
			return editHistorySaveConverter.toDto(savedentity);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.RECORDNOTFOUND);
		}
	}

	@Override
	public List<EditHistoryDto> getEditHistory(Long Id) throws CustomException {
		List<EditHistoryEntity> histories = editHistoryRepository.findByPatientId(Id);
		List<EditHistoryDto> editHistoryDtos = new ArrayList<>();

		histories.forEach(h -> {
			Optional<UserEntity> users_physician = userrepo.findByUserId(h.getPhysicianId());
//			if (!users_physician.isPresent())
//				throw new UsernameNotFoundException("No record Found");

			String physicianName = users_physician.get().getFirstName() + " " + users_physician.get().getLastName();

			Optional<UserEntity> users_editedBy = userrepo.findByUserId(h.getEditedBy());
//			if (!users_editedBy.isPresent())
//				throw new CustomException(HttpStatus.NOT_FOUND, "No record Found");
			String editedByName = users_editedBy.get().getFirstName() + " " + users_editedBy.get().getLastName();

			EditHistoryDto dto = new EditHistoryDto(h);
			
			dto.setPhysicianName(physicianName);
			dto.setEditedBy(editedByName);
			editHistoryDtos.add(dto);
		});

		return editHistoryDtos;
	}

	private void sendMail(PatientAppointmentEntity patientAppointment) throws CustomException {
		// sending mail to Patient
		Optional<UserEntity> users_patient = userrepo.findByUserId(patientAppointment.getPatientId());
		Optional<UserEntity> users_physician = userrepo.findByUserId(patientAppointment.getPhysicianId());

		if (!users_patient.isPresent())
			throw new CustomException(HttpStatus.NOT_FOUND, "No record Found");
		UserEntity patient = users_patient.get();

		if (!users_physician.isPresent())
			throw new CustomException(HttpStatus.NOT_FOUND, "No record Found");
		UserEntity physician = users_physician.get();

		String recipient = patient.getEmailId();
		String subject = "Appointment is successfully created";
		String message = "<HTML><head><body>" + "<div style=' border:black ; padding :10px ; border-style:outset ;'>"
				+ "<h2>You Appointment is successfully created</h2><hr>" + "<h3> Hello " + patient.getTitle() + " "
				+ patient.getFirstName() + " " + patient.getLastName() + "</h3> </br>"
				+ "<p> Please find below appointment details : </br>" + "<br>Subject :"
				+ patientAppointment.getSubject() + "<br>" + "<br>Physician Name :" + physician.getTitle() + " "
				+ physician.getFirstName() + " " + physician.getLastName() + "</br>" + "Start Time :"
				+ patientAppointment.getStartTime() + "<br>" + "End Time :" + patientAppointment.getEndTime() + "<br>"
				+ "Description :" + patientAppointment.getDescription() + "</div>" + "<HTML><head><body>";
		;
		mailService.sendMail(recipient, subject, message);

		// sending mail to Physician
		String recipient_physician = physician.getEmailId();
		String subject_physicain = "Appointment is successfully created";
		String message_physicain = "<HTML><head><body>"
				+ "<div style=' border:black ; padding :10px ; border-style:outset ;'>"
				+ "<h2>You Appointment is successfully created</h2><hr>" + "<h3> Hello " + physician.getTitle() + " "
				+ physician.getFirstName() + " " + physician.getLastName() + "</h3> </br>"
				+ "<p> Please find below appointment details : </br>" + "<br> Subject :"
				+ patientAppointment.getSubject() + "</br>" + "<br>Patient Name :" + patient.getTitle() + " "
				+ patient.getFirstName() + " " + patient.getLastName() + "<br>" + "Start Time :"
				+ patientAppointment.getStartTime() + "<br>" + "End Time :" + patientAppointment.getEndTime() + "<br>"
				+ "Description :" + patientAppointment.getDescription() + "</div>" + "<HTML><head><body>";
		;
		mailService.sendMail(recipient_physician, subject_physicain, message_physicain);
	}

	@Override
	public List<UserEntity> getPatient() {
		final Integer roleId = 5;
		return userrepo.findByRoleId(roleId);
	}

	@Override
	public List<PatientAppointmentDto> getPatientAppintments(Long Id) throws CustomException {
		List<PatientAppointmentEntity> appointemnts = patientAppointmentRepository.findByPatientId(Id);
		
		return patientAppointmentConverter.toDto(appointemnts);
	}

}
