package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_clie")
	private int idClie;

	private int puntos;

	//bi-directional many-to-one association to Califica
	@OneToMany(mappedBy="cliente")
	private List<Califica> calificas;

	//bi-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="id_clie")
	private Usuario usuario;

	//bi-directional many-to-one association to Listadeseo
	@OneToMany(mappedBy="cliente")
	private List<Listadeseo> listadeseos;

	public Cliente() {
	}

	public int getIdClie() {
		return this.idClie;
	}

	public void setIdClie(int idClie) {
		this.idClie = idClie;
	}

	public int getPuntos() {
		return this.puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public List<Califica> getCalificas() {
		return this.calificas;
	}

	public void setCalificas(List<Califica> calificas) {
		this.calificas = calificas;
	}

	public Califica addCalifica(Califica califica) {
		getCalificas().add(califica);
		califica.setCliente(this);

		return califica;
	}

	public Califica removeCalifica(Califica califica) {
		getCalificas().remove(califica);
		califica.setCliente(null);

		return califica;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Listadeseo> getListadeseos() {
		return this.listadeseos;
	}

	public void setListadeseos(List<Listadeseo> listadeseos) {
		this.listadeseos = listadeseos;
	}

	public Listadeseo addListadeseo(Listadeseo listadeseo) {
		getListadeseos().add(listadeseo);
		listadeseo.setCliente(this);

		return listadeseo;
	}

	public Listadeseo removeListadeseo(Listadeseo listadeseo) {
		getListadeseos().remove(listadeseo);
		listadeseo.setCliente(null);

		return listadeseo;
	}

}