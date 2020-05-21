package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_user")
	private int idUser;

	@Column(name="apellidos_user")
	private String apellidosUser;

	@Column(name="direccion_user")
	private String direccionUser;

	@Column(name="email_user")
	private String emailUser;

	@Column(name="nombres_user")
	private String nombresUser;

	@Column(name="num_telefono_user")
	private String numTelefonoUser;

	@Column(name="usuario_user")
	private String usuarioUser;

	//bi-directional one-to-one association to Cliente
	@OneToOne(mappedBy="usuario")
	private Cliente cliente;

	//bi-directional one-to-one association to Empleado
	@OneToOne(mappedBy="usuario")
	private Empleado empleado;

	public Usuario() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getApellidosUser() {
		return this.apellidosUser;
	}

	public void setApellidosUser(String apellidosUser) {
		this.apellidosUser = apellidosUser;
	}

	public String getDireccionUser() {
		return this.direccionUser;
	}

	public void setDireccionUser(String direccionUser) {
		this.direccionUser = direccionUser;
	}

	public String getEmailUser() {
		return this.emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getNombresUser() {
		return this.nombresUser;
	}

	public void setNombresUser(String nombresUser) {
		this.nombresUser = nombresUser;
	}

	public String getNumTelefonoUser() {
		return this.numTelefonoUser;
	}

	public void setNumTelefonoUser(String numTelefonoUser) {
		this.numTelefonoUser = numTelefonoUser;
	}

	public String getUsuarioUser() {
		return this.usuarioUser;
	}

	public void setUsuarioUser(String usuarioUser) {
		this.usuarioUser = usuarioUser;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}