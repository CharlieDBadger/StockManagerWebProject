package entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USER")
public class User {

	@Id
	@SequenceGenerator(name = "ADDRESSGEN", sequenceName = "USER_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESSGEN")
	@Column(name = "ID", nullable = false, updatable = true)
	private long id;

	@Column(columnDefinition = "VARCHAR(30)", name = "USER_NAME")
	private String name;

	@Column(columnDefinition = "VARCHAR(30)", name = "USER_LASTNAME")
	private String lastName;

	@Column(columnDefinition = "VARCHAR(10)", unique = true, name = "USER_DNI")
	private String dni;

	@Column(columnDefinition = "VARCHAR(30)", name = "USER_PASSWORD")
	private String password;

	@Column(columnDefinition = "VARCHAR(20)", name = "USER_ROLE")
	private String role;

	@Column(columnDefinition = "VARCHAR(20)", name = "USER_MAIL")
	private String mail;

	@Column(columnDefinition = "VARCHAR(15)", name = "USER_PHONE")
	private String phone;

	@Column(columnDefinition = "VARCHAR(6)", name = "USER_GENDER")
	private String gender;

	@Column(name = "USER_BIRTH")
	private Date birth;

	// CONSTRUCTORS

	/**
	 * Only for Hibernate use
	 */
	public User() {
		super();
	}

	/**
	 * Only for Inserts, the Object cant be use before has been insert in table
	 * 
	 * @param name
	 * @param province
	 * @param city
	 * @param costalCode
	 */
	public User(String name, String lastName, String dni, String password, String role, String mail, String phone,
			String gender, Date birth) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.password = password;
		this.role = role;
		this.mail = mail;
		this.phone = phone;
		this.gender = gender;
		this.birth = birth;
	}

	/**
	 * Only for Result from Hibernate Query
	 * 
	 * @param id
	 * @param name
	 * @param province
	 * @param city
	 * @param costalCode
	 */
	public User(long id, String name, String lastName, String dni, String password, String role, String mail,
			String phone, String gender, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.password = password;
		this.role = role;
		this.mail = mail;
		this.phone = phone;
		this.gender = gender;
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", dni=" + dni + ", password="
				+ password + ", role=" + role + ", mail=" + mail + ", phone=" + phone + ", gender=" + gender
				+ ", birth=" + birth + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	
}
