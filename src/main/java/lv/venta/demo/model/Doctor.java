package lv.venta.demo.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Entity(name = "DoctorTable")
@Getter @Setter @NoArgsConstructor
public class Doctor extends User{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Did")
	@Setter(value = AccessLevel.NONE)
	private long did;
	
	@Column(name="Profesion")
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 30)
	@Pattern(regexp = "([A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*)")
	private String profesion;
	
	//1-to-many
	@OneToMany(mappedBy = "doctor")
	private Collection<Appointment> appointments;

	@Override
	public String toString() {
		return super.toString() + "Doctor [did=" + did + ", profesion=" + profesion + ", appointments=" + appointments + "]";
	}
	
	
}
