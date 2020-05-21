package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.primefaces.event.RowEditEvent;

import model.Cargo;
import model.Producto;

@ManagedBean
public class CargoBean {

	private static EntityManagerFactory factory;
	private Cargo cargo;
	private List<Cargo> cargos;

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public String guardarCargo() {
		factory = Persistence.createEntityManagerFactory("Clothes1");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.persist(this.cargo);
		em.getTransaction().commit();
		em.close();
		inicializar();

		return "new-page";
	}

	public void editarCargo(Cargo cargo) {
		factory = Persistence.createEntityManagerFactory("Clothes1");
		EntityManager em = factory.createEntityManager();

		this.cargo = em.find(Cargo.class, cargo.getNombreCargo());
		cargo.setNombreCargo(cargo.getNombreCargo());
		cargo.setSalarioEmple(cargo.getSalarioEmple());
		;

		em.getTransaction().begin();
		em.merge(this.cargo);
		em.getTransaction().commit();
		em.close();
		inicializar();
	}
	
	public void modificarCargo(RowEditEvent event) {
		factory = Persistence.createEntityManagerFactory("Clothes1");
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Cargo cargo = (Cargo) event.getObject();
		
		tx.begin();
		em.find(Cargo.class, cargo.getNombreCargo());
		tx.commit();
//		EntityTransaction tx2 = em.getTransaction();
//		tx2.begin();
//		em.merge(producto);
//		tx2.commit();
	}

	public String eliminarCargo(Cargo cargo) {

		factory = Persistence.createEntityManagerFactory("Clothes1");
		EntityManager em = factory.createEntityManager();

		this.cargo = em.find(Cargo.class, cargo.getNombreCargo());
		em.getTransaction().begin();
		em.remove(this.cargo);
		em.getTransaction().commit();
		em.close();
		inicializar();

		return "nueva-pagina";
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void inicializar() {
		factory = Persistence.createEntityManagerFactory("Clothes1");
		EntityManager em = factory.createEntityManager();
		cargos = em.createNamedQuery("Cargo.findAll").getResultList();
	}
}
