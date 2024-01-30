package entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CUSTOMER")
public class Customer {

	@Id
	@SequenceGenerator(name = "CUSTOMERGEN", sequenceName = "CUSTOMER_GEN", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMERGEN")
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;

	@Column(columnDefinition = "VARCHAR(40)", name = "CUSTOMER_NAME")
	private String name;

	@Column(columnDefinition = "VARCHAR(8)", name = "CUSTOMER_DNI")
	private String dni;

	@Column(columnDefinition = "VARCHAR(15)", name = "MOBILE")
	private String mobile;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ADDRESS", nullable = true)
	private Address address;

	@Column(columnDefinition = "VARCHAR (100)", name = "OBSERVATION")
	private String observation;

	// CONSTRUCTORS

	/**
	 * Only for Hibernate use
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Only for Inserts, the Object cant be use before has been insert in table
	 * 
	 * @param name
	 * @param province
	 * @param city
	 * @param costalCode
	 */
	public Customer(String name, String dni, String mobile, Address address, String observation) {
		super();
		this.name = name;
		this.dni = dni;
		this.mobile = mobile;
		this.address = address;
		this.observation = observation;
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
	public Customer(long id, String name, String dni, String mobile, Address address, String observation) {
		super();
		this.id = id;
		this.name = name;
		this.dni = dni;
		this.mobile = mobile;
		this.address = address;
		this.observation = observation;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", dni=" + dni + ", mobile=" + mobile + ", address=" + address
				+ ", observation=" + observation + "]";
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}
}
