package bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import model.Login;

@ManagedBean
@RequestScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory factory;
	private Login login;
	private String output_msg;
	private boolean logeado = false;
	
	
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getOutput_msg() {
		return output_msg;
	}
	
	public void login(Login login) {
		if (login.getUsername().equals(this.login.getUsername()) && login.getPassword().equals(this.login.getPassword())) {
			System.out.println("El usuario es Correcto");
		}else if (login.getUsername().equals("") && login.getPassword().equals("")) {
				System.out.println("Ingrese el usuario y la contraseña");
		}else {
			System.out.println("El usuario es Incorecto");
		}
	}

	public boolean estaLogeado() {
		return logeado;
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void inicializar() {
		factory = Persistence.createEntityManagerFactory("Clothes1");
		EntityManager em = factory.createEntityManager();
	}

	// public String iniciarSesion() {
	// factory = Persistence.createEntityManagerFactory("Clothes1");
	// EntityManager em = factory.createEntityManager();
	// EntityTransaction tx = em.getTransaction();
	//
	// String consulta = "SELECT e FROM Login e WHERE e.username = ?1 and e.password
	// = ?2";
	// javax.persistence.Query query = em.createQuery(consulta);
	// query.setParameter(1, this.login.getUsername());
	// query.setParameter(2, this.login.getPassword());
	// @SuppressWarnings("unchecked")
	// List<Login> login = query.getResultList();
	// Usuario usuario = null;
	// if(!login.isEmpty()) {
	// usuario = new Usuario();
	// }
	// try {
	// if(usuario != null) {
	// return "index?faces-redirect=true";
	// }else {
	// FacesContext.getCurrentInstance().addMessage(null, new
	// FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso" , "Credenciales incorrectas"
	// ));
	// }
	// }catch(Exception e) {
	// throw e;
	// }
	// return "login";
	//
	// }
	
	public void iniciarSesion(ActionEvent actionEvent) {
	    RequestContext context = RequestContext.getCurrentInstance();
	    FacesMessage msg = null;
	    if (login.getUsername() != null  && login.getPassword() != null) {
	      logeado = true;
	      msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", login.getUsername());
	    } else {
	      logeado = false;
	      msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
	                             "Credenciales no válidas");
	    }

	    FacesContext.getCurrentInstance().addMessage(null, msg);
	    context.addCallbackParam("estaLogeado", logeado);
	    if (logeado)
	      context.addCallbackParam("view", "index.xhtml");
	  }

	

	public void logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		logeado = false;
	}



}
