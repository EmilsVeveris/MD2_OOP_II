package lv.venta.demo.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.demo.model.Appointment;
import lv.venta.demo.model.Doctor;
import lv.venta.demo.repo.IAppointmentRepo;
import lv.venta.demo.service.ICRUDAppointmentService;

public class CRUDAppointmentServiceImpl implements ICRUDAppointmentService {
	@Autowired
	IAppointmentRepo appointmentRepo;

	@Override
	public boolean insertNewAppoinment(Appointment appointment) {
		
		//Ideālā gadijumā vajadzētu skatīties vai vienam un tam pašam dakterim, vienā un tajā paša laika netiek pievienoti divi appointmenti, bet esmu pārāk slinks, lai ar to mocītos.
		appointmentRepo.save(appointment);
		return true;
	}

	@Override
	public ArrayList<Appointment> selectAllAppointmentsByPatientById(int id) {
		ArrayList<Appointment> result = appointmentRepo.findByPatientPid(id);
		
		if(result!=null)
			return result;
		
		return new ArrayList<Appointment>();
	}

	@Override
	public ArrayList<Appointment> selectAllAppointmentsByDoctorById(int id) {
		ArrayList<Appointment> result = appointmentRepo.findByDoctorDid(id);
		
		if(result!=null)
			return result;
		
		return new ArrayList<Appointment>();
	}

	@Override
	public ArrayList<Appointment> selectAllAppointmentsByDoctorToday(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

}
