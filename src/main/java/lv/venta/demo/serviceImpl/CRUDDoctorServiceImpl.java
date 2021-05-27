package lv.venta.demo.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.demo.model.Doctor;
import lv.venta.demo.repo.IDoctorRepo;
import lv.venta.demo.service.ICRUDDoctorService;

public class CRUDDoctorServiceImpl implements ICRUDDoctorService {

	@Autowired
	IDoctorRepo doctorRepo;
	@Override
	public ArrayList<Doctor> selectAllDoctors() {

		return (ArrayList<Doctor>) doctorRepo.findAll();

	}

	@Override
	public ArrayList<Doctor> selectAllDoctorsByType(String type) {
		return (ArrayList<Doctor>) doctorRepo.findAllDoctorsByProfesion(type);
	}

	@Override
	public boolean insertDoctor(Doctor doctor) {
		doctorRepo.save(doctor);
		return true;
	}

	
}
