package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the subcategoria database table.
 * 
 */
@Entity
@NamedQuery(name="Subcategoria.findAll", query="SELECT s FROM Subcategoria s")
public class Subcategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nombre_subcat")
	private String nombreSubcat;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="nombre_categ")
	private Categoria categoria;

	public Subcategoria() {
	}

	public String getNombreSubcat() {
		return this.nombreSubcat;
	}

	public void setNombreSubcat(String nombreSubcat) {
		this.nombreSubcat = nombreSubcat;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}