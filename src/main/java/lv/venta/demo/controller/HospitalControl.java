package lv.venta.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lv.venta.demo.model.Appointment;
import lv.venta.demo.model.Doctor;
import lv.venta.demo.model.Patient;
import lv.venta.demo.service.ICRUDAppointmentService;
import lv.venta.demo.service.ICRUDDoctorService;
import lv.venta.demo.service.ICRUDPatientService;
import lv.venta.demo.service.ICRUDUserService;

@Controller
public class HospitalControl {

	@Autowired
	ICRUDAppointmentService appointmentService;
	
	@Autowired
	ICRUDDoctorService doctorService;
	
	@Autowired
	ICRUDPatientService patientService;
	
	@Autowired
	ICRUDUserService userService;
	
	
	@GetMapping("/test") // localhost:8080/test
	public String getFunc()
	{
		System.out.println("Check!!!");
		System.out.println("Check!!!");
		System.out.println("Why is life real");
		return "test"; // will show test.html page
	}
	
	 @GetMapping(value="/patient/showAllDoctors")
	 public String getAllDoctors(Model model)
	 {
		 model.addAttribute("stud", doctorService.selectAllDoctors());
		 return "doctors";
	 }
	 
	 @GetMapping(value="/patient/showAllDoctorsByType")
	 public String getAllDoctorsByType(Model model)
	 {
		 model.addAttribute("stud", doctorService.selectAllDoctors());
		 return "selectDoctorsType";
	 }
	 @PostMapping(value="/patient/showAllDoctorsByType")
	 public String postAllDoctorsByType(Model model, String type)
	 {
		 model.addAttribute("stud", doctorService.selectAllDoctorsByType(type));
		 return "doctors";
	 }
	 
	 @GetMapping(value="/doctors/showAllPatients")
	 public String getAllPatients(Model model)
	 {
		 model.addAttribute("stud", patientService.selectAllPatients());
		 return "patients";
	 }
	 
	 @GetMapping(value="/doctors/showAllPatientsByNameAndSurname/{name}/{surname}")
	 public String getPatientByNameAndSurname(Model model, @PathVariable(name = "name") String name, @PathVariable(name = "surname") String surname)
	 {
		 model.addAttribute("stud", patientService.selectAllPatientsByNameAndSurname(name, surname));
		 return "patients";
	 }
	 
	 @GetMapping(value="/patient/register")
	 public String getRegister(Model model)
	 {
		 model.addAttribute("stud", patientService.selectAllPatients());
		 return "register_Patient";
	 }
	 @PostMapping(value="/patient/register")
	 public String postRegister(Model model, Patient patiente)
	 {
		 model.addAttribute("stud", patientService.insertPatient(patiente));
		 return "patients";
	 }
	 
	 @GetMapping(value="/admin/updatePatientById/{id}")
	 public String getUpdatePatientById(Model model, @PathVariable(name = "id") int id)
	 {

			try {
				model.addAttribute("student", patientService.selecyById(id));
				return"edit-patient";// will show edit student.html
			} catch (Exception e) {
				return "error-id";
			}
	 }
	 
	 @PostMapping(value="/admin/updatePatientById/{id}") 
	 public String postUpdatePatientById(Patient patient,@PathVariable(name = "id") int id) 
	 {
		
		if (patientService.updatePatientById(id, patient))
		{
			return "patients";//will go to localhost:8080/student_array
		} else {
			return "error-id";
		}	
	 }
	 
	 
	 @GetMapping(value="/admin/deletePatientById/{id}")
	 public String getDeletePatientById(Model model, @PathVariable(name = "id") int id)
	 {
		 model.addAttribute("stud", patientService.deletePatientById(id));
		 return "patients";
	 }


	 
	 @GetMapping(value="/doctor/register")
	 public String getRegisterDoctor()
	 {
		 return "register_Doctor";
	 }
	 @PostMapping(value="/doctor/register")
	 public String postRegisterDoctor(Model model, Doctor doctor)
	 {
		 model.addAttribute("stud", doctorService.insertDoctor(doctor));
		 return "doctors";
	 }
	 
	 @GetMapping(value="/user/autorise")
	 public String getAutorise()
	 {
		 return "authorise";
	 }
	 @PostMapping(value="/user/autorise")
	 public String postAuthorise(Model model, String iden, String pasword)
	 {
		 if(userService.autheriseUser(iden, pasword))
// seit vajadzetu parbaudi, vai lietotajs ir arts vai patcients, un novada uz attiecigo vietni.
			 return "patient";
		 else
			 return "authorise";
	 }
	 
	 @GetMapping(value="/patient/insertNewAppointment")	
	 public String getNewAppointment()
	 {
		 return "newAppointment";
	 }
	 @PostMapping(value="/patient/insertNewAppointment")
	 public String postNewAppointment(Appointment appointment)
	 {
		 appointmentService.insertNewAppoinment(appointment);
		 return "appointment";
	 }
	 
	 @GetMapping(value = "/patient/showAllAppointmentsByPatient/{id}")
	 public String getAllAppointmetnsByPatient(Model model, @PathVariable(name = "id") int id)
	 {
		 model.addAttribute("stud", appointmentService.selectAllAppointmentsByPatientById(id));
		 
		 return "appointment";
	 }
	 @GetMapping(value = "/doctor/showAllAppointmentsByDoctor/{id}")
	 public String getAllAppointmetnsByDoctor(Model model, @PathVariable(name = "id") int id)
	 {
		 model.addAttribute("stud", appointmentService.selectAllAppointmentsByDoctorById(id));
		 
		 return "appointment";
	 }
	 @GetMapping(value = "/doctor/showAllAppointmentsByDoctorToday/{doctor}")
	 public String getAllAppointmetnsByDoctorTodey(Model model, @PathVariable(name = "doctor") Doctor doctor)
	 {
		 model.addAttribute("stud", appointmentService.selectAllAppointmentsByDoctorToday(doctor));
		 return "appointment";
	 }
	 
}
