package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_STOCK_MOVEMENTS")
public class StockMov {
	@Id
	@SequenceGenerator(name = "STOCKGEN", sequenceName = "STOCK_GEN", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STOCKGEN")
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;

	@Column(columnDefinition = "DECIMAL (7,2)", name = "ITEM_PRICE", nullable = true, updatable = false)
	private double price;

	@Column(name = "UNITS", nullable = false)
	private int units;

	@ManyToOne(targetEntity = Item.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_ITEM", nullable = false, updatable = false)
	private Item item;

	@ManyToOne(targetEntity = Store.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_STORE", nullable = false, updatable = true)
	private Store store;

	@Column(columnDefinition = "VARCHAR (100)", name = "OBSERVATION")
	private String observation;

	// CONSTRUCTORS

	/**
	 * Only for Hibernate use
	 */
	public StockMov() {
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
	public StockMov(double price, int units, Item item, Store store, String observation) {
		super();
		this.price = price;
		this.units = units;
		this.item = item;
		this.store = store;
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
	public StockMov(long id, double price, int units, Item item, Store store, String observation) {
		super();
		this.id = id;
		this.price = price;
		this.units = units;
		this.item = item;
		this.store = store;
		this.observation = observation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

}
