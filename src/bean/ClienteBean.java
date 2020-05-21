package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cliente;
import model.Login;
import model.Usuario;

@ManagedBean
@RequestScoped
public class ClienteBean {
	
	private static EntityManagerFactory factory;
	private Login login;
	private Usuario usuario;
	private Cliente cliente ;
	
	public ClienteBean() {
		this.usuario = new Usuario();
		this.cliente= new Cliente();
		this.login = new Login();
	}
	
	public String registrarCliente() {		
		factory = Persistence.createEntityManagerFactory("Clothes1");
		EntityManager em = factory.createEntityManager();
		
		//this.usuario.setUsuarioUser(this.login.getUsername());
		this.login.setUsername(this.usuario.getUsuarioUser());

		Cliente cliente = new Cliente();
	//	cliente.getIdClie().setUsuario(this.usuario);
		
		cliente.setPuntos(0);
		
		
		em.getTransaction().begin();
		em.persist(this.usuario);
		em.persist(this.login);
//		em.flush();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();

		
		return "signup.xhtml";
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
