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
@Table(name = "TB_SUPPLIER")
public class Supplier {

	@Id
	@SequenceGenerator(name = "SUPPLIERGEN", sequenceName = "SUPPLIER_GEN", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUPPLIERGEN")
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;

	@Column(columnDefinition = "VARCHAR(40)", name = "SUPPLIER_NAME")
	private String name;

	@Column(columnDefinition = "VARCHAR(8)", name = "SUPPLIER_CIF")
	private String cif;

	@Column(columnDefinition = "VARCHAR(15)", name = "MOBILE")
	private String mobile;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPPLIER_ADDRESS", nullable = true)
	private Address address;

	@Column(columnDefinition = "VARCHAR(100)", name = "DESCRIPTION")
	private String description;

	// CONSTRUCTORS

	/**
	 * Only for Hibernate use
	 */
	public Supplier() {
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
	public Supplier(String name, String cif, String mobile, Address address) {
		super();
		this.name = name;
		this.cif = cif;
		this.mobile = mobile;
		this.address = address;
	}

	/**
	 * Only for Inserts, the Object cant be use before has been insert in table
	 * 
	 * @param name
	 * @param province
	 * @param city
	 * @param costalCode
	 */
	public Supplier(String name, String cif, String mobile, Address address, String description) {
		super();
		this.name = name;
		this.cif = cif;
		this.mobile = mobile;
		this.address = address;
		this.description = description;
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
	public Supplier(long id, String name, String cif, String mobile, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.cif = cif;
		this.mobile = mobile;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", cif=" + cif + ", mobile=" + mobile + ", address=" + address
				+ "]";
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

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
