package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the combo database table.
 * 
 */
@Entity
@NamedQuery(name="Combo.findAll", query="SELECT c FROM Combo c")
public class Combo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_combo")
	private int idCombo;

	@Column(name="descripcion_comb")
	private String descripcionComb;

	@Column(name="nombre_comb")
	private String nombreComb;

	@Column(name="precio_total_combo")
	private int precioTotalCombo;

	//bi-directional many-to-one association to Comboproducto
	@OneToMany(mappedBy="combo")
	private List<Comboproducto> comboproductos;

	public Combo() {
	}

	public int getIdCombo() {
		return this.idCombo;
	}

	public void setIdCombo(int idCombo) {
		this.idCombo = idCombo;
	}

	public String getDescripcionComb() {
		return this.descripcionComb;
	}

	public void setDescripcionComb(String descripcionComb) {
		this.descripcionComb = descripcionComb;
	}

	public String getNombreComb() {
		return this.nombreComb;
	}

	public void setNombreComb(String nombreComb) {
		this.nombreComb = nombreComb;
	}

	public int getPrecioTotalCombo() {
		return this.precioTotalCombo;
	}

	public void setPrecioTotalCombo(int precioTotalCombo) {
		this.precioTotalCombo = precioTotalCombo;
	}

	public List<Comboproducto> getComboproductos() {
		return this.comboproductos;
	}

	public void setComboproductos(List<Comboproducto> comboproductos) {
		this.comboproductos = comboproductos;
	}

	public Comboproducto addComboproducto(Comboproducto comboproducto) {
		getComboproductos().add(comboproducto);
		comboproducto.setCombo(this);

		return comboproducto;
	}

	public Comboproducto removeComboproducto(Comboproducto comboproducto) {
		getComboproductos().remove(comboproducto);
		comboproducto.setCombo(null);

		return comboproducto;
	}

}