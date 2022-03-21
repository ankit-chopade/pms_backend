package com.pms.schedule.constants;

public class PmsScheduleUrlConstants {
	
	private PmsScheduleUrlConstants() {
		super();
	}
	
	public static final String URL_ROOT = "/schedule";

	public static final String URL_SAVE_APPOINTMENT = "/savePatientAppointment";
	public static final String URL_GET_APPOINTMENT = "/getPhysicianAppointments";
	public static final String URL_EDIT_APPOINTMENT = "/editPatientAppointment";
	public static final String URL_DELETE_APPOINTMENT = "/deletePhysicianAppointment";
	public static final String URL_EDIT_HISTORY = "/edithistory";
	public static final String URL_GET_EDIT_HISTORY = "/edithistorypatient";
	public static final String URL_GET_PATIENT_APPOINTMENT = "/getPatientAppointments";
	public static final String URL_GET_PHYSICIANS = "/getPhysician";
	public static final String URL_GET_PATIENTS = "/getPatient";
	public static final String URL_PATIENT_APPOINTMENT= "/patient-appointment";
	public static final String URL_INBOX_NURSE= "/getAppointmentToPatientByDate";
	public static final String URL_INBOX_PATIENT= "/getAppointmentToPatientByDateAndPatientId";
	public static final String URL_INBOX_PHYSICIAN= "/getAppointmentToPatientByDateAndPhysicianId";
	public static final String URL_INBOX_DELETE_APPOINTMENT= "delete/appointment";


}
