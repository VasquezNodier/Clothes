package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comboproducto database table.
 * 
 */
@Entity
@NamedQuery(name="Comboproducto.findAll", query="SELECT c FROM Comboproducto c")
public class Comboproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ComboproductoPK id;

	@Column(name="cant_combprod")
	private int cantCombprod;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_prod")
	private Producto producto;

	//bi-directional many-to-one association to Combo
	@ManyToOne
	@JoinColumn(name="id_combo")
	private Combo combo;

	public Comboproducto() {
	}

	public ComboproductoPK getId() {
		return this.id;
	}

	public void setId(ComboproductoPK id) {
		this.id = id;
	}

	public int getCantCombprod() {
		return this.cantCombprod;
	}

	public void setCantCombprod(int cantCombprod) {
		this.cantCombprod = cantCombprod;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Combo getCombo() {
		return this.combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}

}