package lv.venta.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.demo.model.Appointment;
import lv.venta.demo.model.Patient;
import lv.venta.demo.model.User;
import lv.venta.demo.repo.IAppointmentRepo;
import lv.venta.demo.repo.IDoctorRepo;
import lv.venta.demo.repo.IPatientRepo;
import lv.venta.demo.repo.IUserRepo;

@SpringBootApplication
public class Md2HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Md2HospitalApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner addTestData(IAppointmentRepo appointmetRepo, IDoctorRepo doctorRepo,
			IPatientRepo patientRepo, IUserRepo userRepo)
	{
		
		return(args) -> {
			
			User u1 = new User("Emīls", "Vēveris", 21, "101199-12517", "12345678");
			User u2 = new User("Rihards", "Audze", 21, "130299-13476", "12345678");
			User u3 = new User("Andrejs", "Dzelme", 26, "280894-12517", "12345678");
			User u4 = new User("Kaķis", "Suns", 67, "010167-11111", "12345678");
			User u5 = new User("Jānis", "Zivs", 47, "123456-12345", "12345678");
			User u6 = new User("Jana", "Bērziņa", 50, "654321-54321", "12345678");
			
			userRepo.save(u1);
			userRepo.save(u2);
			userRepo.save(u3);
			userRepo.save(u4);
			userRepo.save(u5);
			userRepo.save(u6);
			
			
			Patient p1 = new Patient(u1);
			Patient p2 = new Patient(u2);
			Patient p3 = new Patient(u3);
			
			patientRepo.save(p1);
			patientRepo.save(p2);
			patientRepo.save(p3);
			
			Appointment a1 = new Appointment("Sāp kāja", null, p1, null, "S");

			};
	}

}
