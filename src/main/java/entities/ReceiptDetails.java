package entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_RECEIPT_DETAILS")
public class ReceiptDetails {
	@Id
	@SequenceGenerator(name = "RECEIPTDETGEN", sequenceName = "RECEIPTDETGEN_GEN", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECEIPTDETGEN")
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;

	@OneToOne(targetEntity = Receipt.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "RECEIPT", nullable = false)
	private Receipt receipt;

	@OneToMany(cascade = { CascadeType.PERSIST,
			CascadeType.REMOVE }, targetEntity = StockMov.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "RECEIPT_ITEMS", nullable = false)
	private List<StockMov> StockMov = new ArrayList<StockMov>();

	// CONSTRUCTORS
	/**
	 * Only for Hibernate use
	 */
	public ReceiptDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Only for Inserts, the Object cant be use before has been insert in table with
	 * Calculates Fiance
	 * 
	 * @param name
	 * @param province
	 * @param city
	 * @param costalCode
	 */
	public ReceiptDetails(Receipt receipt, List<entities.StockMov> stockMov) {
		super();
		this.receipt = receipt;
		StockMov = stockMov;
	}

	/**
	 * Only for Inserts, the Object cant be use before has been insert in table
	 * 
	 * Only for Result from Hibernate Query and
	 * 
	 * @param id
	 * @param name
	 * @param province
	 * @param city
	 * @param costalCode
	 */
	public ReceiptDetails(long id, Receipt receipt, List<entities.StockMov> stockMov) {
		super();
		this.id = id;
		this.receipt = receipt;
		StockMov = stockMov;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public List<StockMov> getStockMov() {
		return StockMov;
	}

	public void setStockMov(List<StockMov> stockMov) {
		StockMov = stockMov;
	}

}
