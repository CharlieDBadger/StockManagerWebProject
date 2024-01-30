package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ADDRESS")
public class Address {

	@Id
	@SequenceGenerator(name = "ADDRESSGEN", sequenceName = "ADDRESS_GEN", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESSGEN")
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;

	@Column(columnDefinition = "VARCHAR(52)", name = "ADDRESS_NAME")
	private String name;
	
	@Column(columnDefinition = "VARCHAR(20)", name = "PROVINCE")
	private String province;
	
	@Column(columnDefinition = "VARCHAR(40)", name = "CITY")
	private String city;
	
	@Column(columnDefinition = "VARCHAR(6)", name = "POSTAL_CODE")
	private String costalCode;

	// CONSTRUCTORS

	/**
	 * Only for Hibernate use
	 */
	public Address() {
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
	public Address( String name, String province, String city, String costalCode) {
		super();
		this.name = name;
		this.province = province;
		this.city = city;
		this.costalCode = costalCode;
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
	public Address(long id, int addressCode, String name, String province, String city, String costalCode) {
		super();
		this.id = id;
		this.name = name;
		this.province = province;
		this.city = city;
		this.costalCode = costalCode;
	}

	
	/**
	 * Object Propieties
	 */
	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", province=" + province
				+ ", city=" + city + ", costalCode=" + costalCode + "]";
	}

	
	// GETTERS AND SETTERS

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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCostalCode() {
		return costalCode;
	}

	public void setCostalCode(String costalCode) {
		this.costalCode = costalCode;
	}
}
