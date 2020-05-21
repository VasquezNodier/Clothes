package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_emple")
	private int idEmple;

	//bi-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="id_emple")
	private Usuario usuario;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="cargo_emple")
	private Cargo cargo;

	public Empleado() {
	}

	public int getIdEmple() {
		return this.idEmple;
	}

	public void setIdEmple(int idEmple) {
		this.idEmple = idEmple;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}