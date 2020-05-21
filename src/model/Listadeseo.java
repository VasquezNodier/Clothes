package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the listadeseo database table.
 * 
 */
@Entity
@NamedQuery(name="Listadeseo.findAll", query="SELECT l FROM Listadeseo l")
public class Listadeseo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_list")
	private int idList;

	@Column(name="cant_list")
	private int cantList;

	@Column(name="precio_total")
	private int precioTotal;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_prod")
	private Producto producto;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_clie")
	private Cliente cliente;

	public Listadeseo() {
	}

	public int getIdList() {
		return this.idList;
	}

	public void setIdList(int idList) {
		this.idList = idList;
	}

	public int getCantList() {
		return this.cantList;
	}

	public void setCantList(int cantList) {
		this.cantList = cantList;
	}

	public int getPrecioTotal() {
		return this.precioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}