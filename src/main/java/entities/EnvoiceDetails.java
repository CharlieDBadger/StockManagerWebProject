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
@Table(name = "TB_ENVOICE_DETAILS")
public class EnvoiceDetails {

	@Id
	@SequenceGenerator(name = "ENVOICEDETGEN", sequenceName = "ENVOICEGEN_GEN", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENVOICEDETGEN")
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;

	@OneToOne(targetEntity = Envoice.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "ENVOICE", nullable = false)
	private Envoice envoice;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH },targetEntity = StockMov.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "ENVOICE_ITEMS", nullable = false)
	private List<StockMov> StockMov = new ArrayList<StockMov>();

	@JoinColumn(name = "FIANCE", nullable = false)
	private double fiance;

	private double porcentualFiance = 0.20;

	// CONSTRUCTORS
	/**
	 * Only for Hibernate use
	 */
	public EnvoiceDetails() {
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
	public EnvoiceDetails(Envoice envoice, List<entities.StockMov> stockMov) {
		super();
		this.envoice = envoice;
		StockMov = stockMov;
		this.fiance = fianceCalculator(stockMov);
	}

	/**
	 * Only for Inserts, the Object cant be use before has been insert in table with
	 * Manual Fiance
	 * 
	 * Only for Result from Hibernate Query and
	 * 
	 * @param id
	 * @param name
	 * @param province
	 * @param city
	 * @param costalCode
	 */
	public EnvoiceDetails(Envoice envoice, List<entities.StockMov> stockMov, double fiance) {
		super();
		this.envoice = envoice;
		StockMov = stockMov;
		this.fiance = fiance;
	}

	/**
	 * 
	 * Only for Result from Hibernate Query
	 * 
	 * @param id
	 * @param name
	 * @param province
	 * @param city
	 * @param costalCode
	 */
	public EnvoiceDetails(long id, Envoice envoice, List<entities.StockMov> stockMov, double fiance,
			double porcentualFiance) {
		super();
		this.id = id;
		this.envoice = envoice;
		StockMov = stockMov;
		this.fiance = fiance;
		this.porcentualFiance = porcentualFiance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Envoice getEnvoice() {
		return envoice;
	}

	public void setEnvoice(Envoice envoice) {
		this.envoice = envoice;
	}

	public List<StockMov> getStockMov() {
		return StockMov;
	}

	public void setStockMov(List<StockMov> stockMov) {
		StockMov = stockMov;
	}

	public double getFiance() {
		return fiance;
	}

	public void setFiance(double fiance) {
		this.fiance = fiance;
	}

	/**
	 * This method calculates the value of the fiance.
	 * 
	 * @param movs
	 * @return
	 */
	public double fianceCalculator(List<StockMov> movs) {
		double totalPrice = 0;
		for (entities.StockMov stockMovItem : movs) {
			double priceTotal = stockMovItem.getPrice() * stockMovItem.getUnits();
			totalPrice = totalPrice + priceTotal;
		}
		return totalPrice * this.porcentualFiance;
	}
}
