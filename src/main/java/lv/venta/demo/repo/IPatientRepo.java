package lv.venta.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Patient;

public interface IPatientRepo extends CrudRepository<Patient, Integer> {

	ArrayList<Patient> findAllPatientsByNameAndSurname(String name, String surname);

}
