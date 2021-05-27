package lv.venta.demo.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity(name = "UserTable")
@Getter @Setter @NoArgsConstructor
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Uid")
	@Setter(value = AccessLevel.NONE)
	private long uid;
	
	@Column(name="Name")
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 30)
	@Pattern(regexp = "([A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*)")
	private String name;
	
	@Column(name="Surname")
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 30)
	@Pattern(regexp = "([A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*)")
	private String surname;
	
	
	@Min(0) 
	@Max(140)
	private int age;
	
	@Column(name="PersonalCode")
	@NotNull
	@NotEmpty
	@Size(min = 12, max = 12)
	@Pattern(regexp = "([0-9\\]+)")
	private String personalCode;
	
	@Column(name="Pasword")
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 12)
	@Pattern(regexp = "([A-ZĀČĒĢĪĶĻŅŠŪŽa-zāčēģīķļņšūž0-9]*)")
	private String pasword;

	public User(
			@NotNull @NotEmpty @Size(min = 3, max = 30) @Pattern(regexp = "([A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*)") String name,
			@NotNull @NotEmpty @Size(min = 3, max = 30) @Pattern(regexp = "([A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*)") String surname,
			@Min(0) @Max(140) int age,
			@NotNull @NotEmpty @Size(min = 12, max = 12) @Pattern(regexp = "([0-9\\]+)") String personalCode,
			@NotNull @NotEmpty @Size(min = 3, max = 12) @Pattern(regexp = "([A-ZĀČĒĢĪĶĻŅŠŪŽa-zāčēģīķļņšūž0-9]*)") String pasword) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.personalCode = personalCode;
		this.pasword = pasword;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", age=" + age + ", personalCode=" + personalCode + "]";
	}
	
	
	
}
