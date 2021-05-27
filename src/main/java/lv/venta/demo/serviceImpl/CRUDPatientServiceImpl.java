package lv.venta.demo.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.demo.model.Patient;

import lv.venta.demo.repo.IPatientRepo;
import lv.venta.demo.service.ICRUDPatientService;

public class CRUDPatientServiceImpl implements ICRUDPatientService{

	@Autowired
	IPatientRepo patientRepo;
	@Override
	public ArrayList<Patient> selectAllPatients() {
		
		return (ArrayList<Patient>) patientRepo.findAll();
	}

	@Override
	public ArrayList<Patient> selectAllPatientsByNameAndSurname(String name, String surname) {
		return (ArrayList<Patient>) patientRepo.findAllPatientsByNameAndSurname(name, surname);
	}

	@Override
	public boolean insertPatient(Patient patient) {
		patientRepo.save(patient);
		return true;
	}

	@Override
	public boolean updatePatientById(int id, Patient newPatient) {
		Patient pat = patientRepo.findById(id).get();
		if(pat != null)
		{
			pat.setName(newPatient.getName());
			pat.setSurname(newPatient.getSurname());
			patientRepo.save(pat);
			return true;
		}
		return false;
	}

	@Override
	public boolean deletePatientById(int id) {
		Patient pat = patientRepo.findById(id).get();
		
		if(pat != null)
		{
			patientRepo.delete(pat);
			return true;
		}
		return false;

	}

	@Override
	public Patient selecyById(int id) {
		Patient pat = patientRepo.findById(id).get();
		return pat;
	}



}
