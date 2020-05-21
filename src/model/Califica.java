package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the califica database table.
 * 
 */
@Entity
@NamedQuery(name="Califica.findAll", query="SELECT c FROM Califica c")
public class Califica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_calif")
	private int idCalif;

	@Column(name="opinion_calif")
	private String opinionCalif;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_clie")
	private Cliente cliente;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_prod")
	private Producto producto;

	public Califica() {
	}

	public int getIdCalif() {
		return this.idCalif;
	}

	public void setIdCalif(int idCalif) {
		this.idCalif = idCalif;
	}

	public String getOpinionCalif() {
		return this.opinionCalif;
	}

	public void setOpinionCalif(String opinionCalif) {
		this.opinionCalif = opinionCalif;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}