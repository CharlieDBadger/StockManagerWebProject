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
@Table(name = "TB_STORE")
public class Store {

	@Id
	@SequenceGenerator(name = "STOREGEN", sequenceName = "STORE_GEN", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STOREGEN")
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;

	@Column(columnDefinition = "VARCHAR(20)", name = "STORE_NAME")
	private String name;

	@Column(columnDefinition = "VARCHAR(15)", name = "MOBILE")
	private String mobile;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "STORE_ADDRESS", referencedColumnName = "id", nullable = false)
	private Address storeAddres;


	// CONSTRUCTORS

	/**
	 * Only for Hibernate use
	 */
	public Store() {
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
	public Store(String name, String mobile, Address storeAddres) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.storeAddres = storeAddres;
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
	public Store(long id, String name, String mobile, Address storeAddres) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.storeAddres = storeAddres;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", mobile=" + mobile + ", storeAddres=" + storeAddres + "]";
	}

	// SETTERS and GETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getStoreAddres() {
		return storeAddres;
	}

	public void setStoreAddres(Address storeAddres) {
		this.storeAddres = storeAddres;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
