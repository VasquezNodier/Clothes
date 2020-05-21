package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Empleado;
import model.Usuario;

@ManagedBean
@RequestScoped
public class EmpleadoBean {
	
	private static EntityManagerFactory factory;
	private Usuario usuario;
	private Empleado empleado ;
	private List<Empleado> empleados;
	

	public EmpleadoBean() {
		this.usuario = new Usuario();
		this.empleado= new Empleado();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void inicializar() {
		factory = Persistence.createEntityManagerFactory("Clothes1");
		EntityManager em = factory.createEntityManager();
		empleados = em.createNamedQuery("Usuario.findAll").getResultList();
	}
	
	
	
//	public String iniciarSesionUsuario() {
//		factory = Persistence.createEntityManagerFactory("Clothes");
//		EntityManager em = factory.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//
//		String consulta = "SELECT e FROM Usuario e WHERE e.usuarioUser = ?1 and e.password = ?2";
//		javax.persistence.Query query = em.createQuery(consulta);
//		query.setParameter(1, this.empleado.get);
//		query.setParameter(2, this.empleado.getPassword());
//		@SuppressWarnings("unchecked")
//		List<Usuario> login = query.getResultList();
//		Usuario usuario = null;
//		if(!login.isEmpty()) {
//		usuario = new Usuario();
//		usuario = login.get(0);
//		}	
//		try {	
//		if(usuario != null) {
//		return "index?faces-redirect=true";
//		}else {
//		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso" , "Credenciales incorrectas" ));
//		}
//		}catch(Exception e) {
//		throw e;
//		}
//		return "login";
//
//		}



	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	

}
