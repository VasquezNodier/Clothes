package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the comboproducto database table.
 * 
 */
@Embeddable
public class ComboproductoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_combo", insertable=false, updatable=false)
	private int idCombo;

	@Column(name="id_prod", insertable=false, updatable=false)
	private int idProd;

	public ComboproductoPK() {
	}
	public int getIdCombo() {
		return this.idCombo;
	}
	public void setIdCombo(int idCombo) {
		this.idCombo = idCombo;
	}
	public int getIdProd() {
		return this.idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ComboproductoPK)) {
			return false;
		}
		ComboproductoPK castOther = (ComboproductoPK)other;
		return 
			(this.idCombo == castOther.idCombo)
			&& (this.idProd == castOther.idProd);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCombo;
		hash = hash * prime + this.idProd;
		
		return hash;
	}
}