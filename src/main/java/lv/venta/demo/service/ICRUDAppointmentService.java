package lv.venta.demo.service;

import java.util.ArrayList;

import lv.venta.demo.model.Appointment;
import lv.venta.demo.model.Doctor;

public interface ICRUDAppointmentService {

	
	public boolean insertNewAppoinment(Appointment appointment);
	
	public ArrayList<Appointment> selectAllAppointmentsByPatientById(int id);
	
	public ArrayList<Appointment> selectAllAppointmentsByDoctorById(int id);
	
	public ArrayList<Appointment> selectAllAppointmentsByDoctorToday(Doctor doctor);
}
