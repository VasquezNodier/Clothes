package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the descuento database table.
 * 
 */
@Entity
@NamedQuery(name="Descuento.findAll", query="SELECT d FROM Descuento d")
public class Descuento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="porcen_desc")
	private int porcenDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_desc")
	private Date fechaFinDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ini_desc")
	private Date fechaIniDesc;

	//bi-directional many-to-one association to Productoalmacen
	@OneToMany(mappedBy="descuentoBean")
	private List<Productoalmacen> productoalmacens;

	public Descuento() {
	}

	public int getPorcenDesc() {
		return this.porcenDesc;
	}

	public void setPorcenDesc(int porcenDesc) {
		this.porcenDesc = porcenDesc;
	}

	public Date getFechaFinDesc() {
		return this.fechaFinDesc;
	}

	public void setFechaFinDesc(Date fechaFinDesc) {
		this.fechaFinDesc = fechaFinDesc;
	}

	public Date getFechaIniDesc() {
		return this.fechaIniDesc;
	}

	public void setFechaIniDesc(Date fechaIniDesc) {
		this.fechaIniDesc = fechaIniDesc;
	}

	public List<Productoalmacen> getProductoalmacens() {
		return this.productoalmacens;
	}

	public void setProductoalmacens(List<Productoalmacen> productoalmacens) {
		this.productoalmacens = productoalmacens;
	}

	public Productoalmacen addProductoalmacen(Productoalmacen productoalmacen) {
		getProductoalmacens().add(productoalmacen);
		productoalmacen.setDescuentoBean(this);

		return productoalmacen;
	}

	public Productoalmacen removeProductoalmacen(Productoalmacen productoalmacen) {
		getProductoalmacens().remove(productoalmacen);
		productoalmacen.setDescuentoBean(null);

		return productoalmacen;
	}

}