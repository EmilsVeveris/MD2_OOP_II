package lv.venta.demo.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity(name = "PatientTable")
@Getter @Setter @NoArgsConstructor
public class Patient extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Pid")
	@Setter(value = AccessLevel.NONE)
	private long pid;


	
	//1-to-many
	@OneToMany(mappedBy = "patient")
	private Collection<Appointment> appointments;



	public Patient(User user) {
		super(user.getName(), user.getSurname(), user.getAge(), user.getPersonalCode(), user.getPasword());
	}



	@Override
	public String toString() {
		return super.toString() + "Patient [pid=" + pid + ", appointments=" + appointments + "]";
	}
	
	
	
	
	
}
