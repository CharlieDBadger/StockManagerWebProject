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
@Table(name = "TB_RECEIPT")
public class Receipt {

	@Id
	@SequenceGenerator(name = "RECEIPTGEN", sequenceName = "RECEIPT_GEN", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECEIPTGEN")
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;

	@SequenceGenerator(name = "RECEIPT_CODEGEN", sequenceName = "RECEIPT_COD_GEN", initialValue = 2024000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECEIPT_CODEGEN")
	@Column(name = "RECEIPT_CODE", nullable = false, updatable = false)
	private long receiptCode;

	@Column(name = "INPUT_DATE", nullable = true)
	private Date dateInput;

	@ManyToOne(targetEntity = Supplier.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_SUPPLIER", nullable = false, updatable = false)
	private Supplier supplier;

	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_USER", nullable = false, updatable = false)
	private User user;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE },targetEntity = ReceiptDetails.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "RECEIPT_DETAILS", nullable = false)
	private ReceiptDetails receiptDetails;

	@Column(columnDefinition = "VARCHAR (100)", name = "OBSERVATION")
	private String observation;

	// CONSTRUCTORS

	/**
	 * Only for Hibernate use
	 */
	public Receipt() {
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
	public Receipt(Date dateInput, Supplier supplier, User user, ReceiptDetails receiptDetails, String observation) {
		super();
		this.dateInput = dateInput;
		this.supplier = supplier;
		this.user = user;
		this.receiptDetails = receiptDetails;
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
	public Receipt(long id, long receiptCode, Date dateInput, Supplier supplier, User user,
			ReceiptDetails receiptDetails, String observation) {
		super();
		this.id = id;
		this.receiptCode = receiptCode;
		this.dateInput = dateInput;
		this.supplier = supplier;
		this.user = user;
		this.receiptDetails = receiptDetails;
		this.observation = observation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(long receiptCode) {
		this.receiptCode = receiptCode;
	}

	public Date getDateInput() {
		return dateInput;
	}

	public void setDateInput(Date dateInput) {
		this.dateInput = dateInput;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ReceiptDetails getReceiptDetails() {
		return receiptDetails;
	}

	public void setReceiptDetails(ReceiptDetails receiptDetails) {
		this.receiptDetails = receiptDetails;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

}
