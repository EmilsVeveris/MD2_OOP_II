package lv.venta.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.Appointment;

public interface IAppointmentRepo extends CrudRepository<Appointment, Integer> {

	ArrayList<Appointment> findByPatientPid(int id);

	ArrayList<Appointment> findByDoctorDid(int id);

}
