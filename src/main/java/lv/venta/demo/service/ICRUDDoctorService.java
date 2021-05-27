package lv.venta.demo.service;

import java.util.ArrayList;

import lv.venta.demo.model.Doctor;

public interface ICRUDDoctorService {


	//select all doctors
	public ArrayList<Doctor> selectAllDoctors();
	
	//select all doctors by there profession
	public ArrayList<Doctor> selectAllDoctorsByType(String type);

	public boolean insertDoctor(Doctor doctor);
}
