package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioBean {

	private static EntityManagerFactory factory;
	private Usuario usuario;
	private List<Usuario> usuarios;

	public UsuarioBean() {
		this.usuario = new Usuario();
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void inicializar() {
		factory = Persistence.createEntityManagerFactory("Clothes1");
		EntityManager em = factory.createEntityManager();
		usuarios = em.createNamedQuery("Usuario.findAll").getResultList();
	}

//	public String guardarUsuario() {
//		factory = Persistence.createEntityManagerFactory("Clothes");
//		EntityManager em = factory.createEntityManager();
//		
//		Cliente cliente = new Cliente();
//		cliente.setUsuario(this.usuario);
//		cliente.setPuntos(0);
//		
//		em.getTransaction().begin();
//		em.persist(this.usuario);
//		em.persist(cliente);
//		//em.persist(login);
//		em.getTransaction().commit();
//		em.close();
//
//		return "new-page";
//	}

//	public List<Usuario> mostrarUsuarios() {
//		factory = Persistence.createEntityManagerFactory("Clothes");
//		EntityManager em = factory.createEntityManager();
//		em.getTransaction().begin();
//		em.createNamedQuery("Usuario.findAll").getResultList();
//		em.persist(this.usuario);
//		em.getTransaction().commit();
//		em.close();
//		return usuarios;
//	}

//	public void eliminarUsuario() {
//		factory = Persistence.createEntityManagerFactory("Clothes");
//		EntityManager em = factory.createEntityManager();
//		em.getTransaction().begin();
//		usuario = em.find(Usuario.class, usuario.getIdUser());
//		em.remove(this.usuario);
//		em.getTransaction().commit();
//		em.close();
//		inicializar();
//
//	}

//	public void editarUsuario(RowEditEvent event) {
//		factory = Persistence.createEntityManagerFactory("Clothes");
//		EntityManager em = factory.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		Usuario usuario = (Usuario) event.getObject();
//
//		tx.begin();
//		em.find(Usuario.class, usuario.getIdUser());
//		tx.commit();
//		EntityTransaction tx2 = em.getTransaction();
//		tx2.begin();
//		em.merge(usuario);
//		tx2.commit();
//	}
	
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
