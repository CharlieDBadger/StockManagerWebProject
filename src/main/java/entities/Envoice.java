package entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ENVOICE")
public class Envoice {

	@Id
	@SequenceGenerator(name = "ENVOICEGEN", sequenceName = "ENVOICE_GEN", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENVOICEGEN")
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;

	@SequenceGenerator(name = "ENVOICE_CODEGEN", sequenceName = "ENVOICE_COD_GEN", initialValue = 20240001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENVOICE_CODEGEN")
	@Column(name = "ENVOICE_CODE", nullable = false, updatable = false)
	private long envoiceCode;

	@Column(name = "INPUT_DATE", nullable = true)
	private Date dateInput;

	@ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_CUSTOMER", nullable = false, updatable = false)
	private Customer customer;

	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_USER", nullable = false, updatable = false)
	private User user;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.REFRESH }, targetEntity = EnvoiceDetails.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "ENVOICE_DETAILS", nullable = false)
	private EnvoiceDetails envoiceDetails;

	@Column(columnDefinition = "VARCHAR (100)", name = "OBSERVATION")
	private String observation;

	// CONSTRUCTORS
	/**
	 * Only for Hibernate use
	 */
	public Envoice() {
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
	public Envoice(Date dateInput, Customer customer, User user, EnvoiceDetails envoiceDetails, String observation) {
		super();
		this.dateInput = dateInput;
		this.customer = customer;
		this.user = user;
		this.envoiceDetails = envoiceDetails;
		this.observation = observation;
	}

	/**
	 * Only for Result from Hibernate Query, the EnvoiceCode is generated in SQL
	 * 
	 * @param id
	 * @param name
	 * @param province
	 * @param city
	 * @param costalCode
	 */
	public Envoice(long id, long envoiceCode, Date dateInput, Customer customer, User user,
			EnvoiceDetails envoiceDetails, String observation) {
		super();
		this.id = id;
		this.envoiceCode = envoiceCode;
		this.dateInput = dateInput;
		this.customer = customer;
		this.user = user;
		this.envoiceDetails = envoiceDetails;
		this.observation = observation;
	}

	@Override
	public String toString() {
		return "Envoice [id=" + id + ", dateInput=" + dateInput + ", customer=" + customer + ", user=" + user
				+ ", envoiceDetails=" + envoiceDetails + ", observation=" + observation + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateInput() {
		return dateInput;
	}

	public void setDateInput(Date dateInput) {
		this.dateInput = dateInput;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EnvoiceDetails getEnvoiceDetails() {
		return envoiceDetails;
	}

	public void setEnvoiceDetails(EnvoiceDetails envoiceDetails) {
		this.envoiceDetails = envoiceDetails;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

}
