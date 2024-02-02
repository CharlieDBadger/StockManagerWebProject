package entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ITEM")
public class Item {
	@Id
	@SequenceGenerator(name = "ITEMGEN", sequenceName = "ITEM_GEN", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEMGEN")
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;

	@Column(columnDefinition = "VARCHAR(6)", name = "ITEM_CODE", nullable = false, updatable = true, unique = true)
	private String code;

	@Column(columnDefinition = "VARCHAR(40)", name = "ITEM_NAME", nullable = false, updatable = true)
	private String name;

	@Column(name = "KIND_ITEM", nullable = false, updatable = false)
	private String kind;

	@OneToMany(targetEntity = StockMov.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_STOCK_MOVs", nullable = true, updatable = true)
	private List<StockMov> stockMovs = new ArrayList<StockMov>();

	// CONSTRUCTORS

	/**
	 * Only for Hibernate use
	 */
	public Item() {
		super();
	}

	/**
	 * Only for Inserts, the Object cant be use before has been insert in table
	 * 
	 * @param code
	 * @param name
	 * @param kind
	 */
	public Item(String code, String name, String kind) {
		super();
		this.code = code;
		this.name = name;
		this.kind = kind;
	}

	/**
	 * Only for Inserts, the Object cant be use before has been insert in table
	 * 
	 * @param name
	 * @param province
	 * @param city
	 * @param costalCode
	 */
	public Item(String code, String name, String kind, List<StockMov> stockMovs) {
		super();
		this.code = code;
		this.name = name;
		this.kind = kind;
		this.stockMovs = stockMovs;
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
	public Item(long id, String code, String name, String kind, List<StockMov> stockMovs) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.kind = kind;
		this.stockMovs = stockMovs;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", code=" + code + ", name=" + name + ", kind=" + kind + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public List<StockMov> getStockMovs() {
		return stockMovs;
	}

	public void setStockMovs(List<StockMov> stockMovs) {
		this.stockMovs = stockMovs;
	}

}
