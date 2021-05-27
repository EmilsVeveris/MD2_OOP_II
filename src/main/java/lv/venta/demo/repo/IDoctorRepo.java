package lv.venta.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Doctor;



public interface IDoctorRepo extends CrudRepository<Doctor, Integer> {

	ArrayList<Doctor> findAllDoctorsByProfesion(String type);

}
