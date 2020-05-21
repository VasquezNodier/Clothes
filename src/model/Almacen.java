package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the almacen database table.
 * 
 */
@Entity
@NamedQuery(name="Almacen.findAll", query="SELECT a FROM Almacen a")
public class Almacen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_alma")
	private int idAlma;

	@Column(name="direccion_alma")
	private String direccionAlma;

	@Column(name="nombre_alma")
	private String nombreAlma;

	@Column(name="telefono_alma")
	private String telefonoAlma;

	//bi-directional many-to-one association to Productoalmacen
	@OneToMany(mappedBy="almacen")
	private List<Productoalmacen> productoalmacens;

	public Almacen() {
	}

	public int getIdAlma() {
		return this.idAlma;
	}

	public void setIdAlma(int idAlma) {
		this.idAlma = idAlma;
	}

	public String getDireccionAlma() {
		return this.direccionAlma;
	}

	public void setDireccionAlma(String direccionAlma) {
		this.direccionAlma = direccionAlma;
	}

	public String getNombreAlma() {
		return this.nombreAlma;
	}

	public void setNombreAlma(String nombreAlma) {
		this.nombreAlma = nombreAlma;
	}

	public String getTelefonoAlma() {
		return this.telefonoAlma;
	}

	public void setTelefonoAlma(String telefonoAlma) {
		this.telefonoAlma = telefonoAlma;
	}

	public List<Productoalmacen> getProductoalmacens() {
		return this.productoalmacens;
	}

	public void setProductoalmacens(List<Productoalmacen> productoalmacens) {
		this.productoalmacens = productoalmacens;
	}

	public Productoalmacen addProductoalmacen(Productoalmacen productoalmacen) {
		getProductoalmacens().add(productoalmacen);
		productoalmacen.setAlmacen(this);

		return productoalmacen;
	}

	public Productoalmacen removeProductoalmacen(Productoalmacen productoalmacen) {
		getProductoalmacens().remove(productoalmacen);
		productoalmacen.setAlmacen(null);

		return productoalmacen;
	}

}