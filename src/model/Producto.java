package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_prod")
	private int idProd;

	@Column(name="imagen_prod")
	private String imagenProd;

	@Column(name="nombre_prod")
	private String nombreProd;

	@Column(name="precio_unit_prod")
	private int precioUnitProd;

	//bi-directional many-to-one association to Califica
	@OneToMany(mappedBy="producto")
	private List<Califica> calificas;

	//bi-directional many-to-one association to Comboproducto
	@OneToMany(mappedBy="producto")
	private List<Comboproducto> comboproductos;

	//bi-directional many-to-one association to Listadeseo
	@OneToMany(mappedBy="producto")
	private List<Listadeseo> listadeseos;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categoria")
	private Categoria categoriaBean;

	//bi-directional many-to-one association to Productoalmacen
	@OneToMany(mappedBy="producto")
	private List<Productoalmacen> productoalmacens;

	public Producto() {
	}

	public int getIdProd() {
		return this.idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public String getImagenProd() {
		return this.imagenProd;
	}

	public void setImagenProd(String imagenProd) {
		this.imagenProd = imagenProd;
	}

	public String getNombreProd() {
		return this.nombreProd;
	}

	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	public int getPrecioUnitProd() {
		return this.precioUnitProd;
	}

	public void setPrecioUnitProd(int precioUnitProd) {
		this.precioUnitProd = precioUnitProd;
	}

	public List<Califica> getCalificas() {
		return this.calificas;
	}

	public void setCalificas(List<Califica> calificas) {
		this.calificas = calificas;
	}

	public Califica addCalifica(Califica califica) {
		getCalificas().add(califica);
		califica.setProducto(this);

		return califica;
	}

	public Califica removeCalifica(Califica califica) {
		getCalificas().remove(califica);
		califica.setProducto(null);

		return califica;
	}

	public List<Comboproducto> getComboproductos() {
		return this.comboproductos;
	}

	public void setComboproductos(List<Comboproducto> comboproductos) {
		this.comboproductos = comboproductos;
	}

	public Comboproducto addComboproducto(Comboproducto comboproducto) {
		getComboproductos().add(comboproducto);
		comboproducto.setProducto(this);

		return comboproducto;
	}

	public Comboproducto removeComboproducto(Comboproducto comboproducto) {
		getComboproductos().remove(comboproducto);
		comboproducto.setProducto(null);

		return comboproducto;
	}

	public List<Listadeseo> getListadeseos() {
		return this.listadeseos;
	}

	public void setListadeseos(List<Listadeseo> listadeseos) {
		this.listadeseos = listadeseos;
	}

	public Listadeseo addListadeseo(Listadeseo listadeseo) {
		getListadeseos().add(listadeseo);
		listadeseo.setProducto(this);

		return listadeseo;
	}

	public Listadeseo removeListadeseo(Listadeseo listadeseo) {
		getListadeseos().remove(listadeseo);
		listadeseo.setProducto(null);

		return listadeseo;
	}

	public Categoria getCategoriaBean() {
		return this.categoriaBean;
	}

	public void setCategoriaBean(Categoria categoriaBean) {
		this.categoriaBean = categoriaBean;
	}

	public List<Productoalmacen> getProductoalmacens() {
		return this.productoalmacens;
	}

	public void setProductoalmacens(List<Productoalmacen> productoalmacens) {
		this.productoalmacens = productoalmacens;
	}

	public Productoalmacen addProductoalmacen(Productoalmacen productoalmacen) {
		getProductoalmacens().add(productoalmacen);
		productoalmacen.setProducto(this);

		return productoalmacen;
	}

	public Productoalmacen removeProductoalmacen(Productoalmacen productoalmacen) {
		getProductoalmacens().remove(productoalmacen);
		productoalmacen.setProducto(null);

		return productoalmacen;
	}

}