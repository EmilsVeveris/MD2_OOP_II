package lv.venta.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity(name = "AppointmentTable")
@Getter @Setter @NoArgsConstructor
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Appid")
	@Setter(value = AccessLevel.NONE)
	private long appid;
	
	@Column(name="Description")
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 300)
	@Pattern(regexp = "([A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*)")
	private String description;
	
	@Column(name="Place")
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 30)
	@Pattern(regexp = "([A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*)")
	private String place;
	
	private Date apointment_time;
	
	//many-to-1
	@ManyToOne
	@JoinColumn(name = "Pid")
	private Patient patient;
	
	@ManyToOne()
	@JoinColumn(name = "Did")
	private Doctor doctor;
	
	

	public Appointment(
			@NotNull @NotEmpty @Size(min = 3, max = 300) @Pattern(regexp = "([A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*)") String description,
			Date apointment_time, Patient patient, Doctor doctor, String place) {
		super();
		this.description = description;
		this.apointment_time = apointment_time;
		this.patient = patient;
		this.doctor = doctor;
		this.place = place;
	}

	@Override
	public String toString() {
		return "Appointment [description=" + description + ", apointment_time=" + apointment_time + ", patient="
				+ patient.getName() + patient.getSurname() + ", doctor=" + doctor.getName() + doctor.getSurname() + "]";
	}
	
	
	

}
