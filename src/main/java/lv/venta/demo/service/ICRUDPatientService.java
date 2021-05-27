package lv.venta.demo.service;

import java.util.ArrayList;

import lv.venta.demo.model.Patient;

public interface ICRUDPatientService {
	
	
	public ArrayList<Patient> selectAllPatients();
	
	public ArrayList<Patient> selectAllPatientsByNameAndSurname(String name, String surname);
	
	public boolean insertPatient(Patient patient);
	
	public boolean updatePatientById(int id, Patient newPatient);
	
	public boolean deletePatientById(int id);

	public Patient selecyById(int id);

}
