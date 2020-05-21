package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the productoalmacen database table.
 * 
 */
@Entity
@NamedQuery(name="Productoalmacen.findAll", query="SELECT p FROM Productoalmacen p")
public class Productoalmacen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_prodAlma;

	private int cant_prodAlma;

	//bi-directional many-to-one association to Almacen
	@ManyToOne
	@JoinColumn(name="id_alma")
	private Almacen almacen;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_prod")
	private Producto producto;

	//bi-directional many-to-one association to Descuento
	@ManyToOne
	@JoinColumn(name="descuento")
	private Descuento descuentoBean;

	public Productoalmacen() {
	}

	public int getId_prodAlma() {
		return this.id_prodAlma;
	}

	public void setId_prodAlma(int id_prodAlma) {
		this.id_prodAlma = id_prodAlma;
	}

	public int getCant_prodAlma() {
		return this.cant_prodAlma;
	}

	public void setCant_prodAlma(int cant_prodAlma) {
		this.cant_prodAlma = cant_prodAlma;
	}

	public Almacen getAlmacen() {
		return this.almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Descuento getDescuentoBean() {
		return this.descuentoBean;
	}

	public void setDescuentoBean(Descuento descuentoBean) {
		this.descuentoBean = descuentoBean;
	}

}