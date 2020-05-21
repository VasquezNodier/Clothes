package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.primefaces.event.RowEditEvent;

import model.Almacen;

@ManagedBean
public class AlmacenBean {

	private static EntityManagerFactory factory;
	private Almacen almacen;
	private List<Almacen> almacenes;

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public List<Almacen> getAlmacenes() {
		return almacenes;
	}

	public void setAlmacenes(List<Almacen> almacenes) {
		this.almacenes = almacenes;
	}

	public AlmacenBean() {
		this.almacen = new Almacen();
	}	
	

	public String guardarAlmacen() {
		factory = Persistence.createEntityManagerFactory("Clothes1");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.persist(this.almacen);
		em.getTransaction().commit();
		em.close();
		inicializar();

		return "almacenCrear.xhtml?faces-redirect=true";
	}

	public void editarAlmacen(Almacen almacen) {
		try {
			factory = Persistence.createEntityManagerFactory("Clothes1");
			EntityManager em = factory.createEntityManager();
			//this.almacen = (Almacen) event.getObject();
			this.almacen = em.find(Almacen.class, almacen.getIdAlma());
			em.getTransaction().begin();
			em.merge(almacen);
			em.getTransaction().commit();
			em.close();
			inicializar();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

//	public void editarProducto(RowEditEvent event) {
//		try {
//			factory = Persistence.createEntityManagerFactory("taller_producto");
//			EntityManager em = factory.createEntityManager();
//			this.producto = (Producto) event.getObject();
//			em.getTransaction().begin();
//			em.merge(producto);
//			em.getTransaction().commit();
//			em.close();
//			inicializar();
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//	}

//	public void editarTipoProducto() {
//		try {
//			factory = Persistence.createEntityManagerFactory("Proyecto_Paradigmas");
//			EntityManager em = factory.createEntityManager();
//			em.getTransaction().begin();
//			// this.producto = em.find(Producto.class, id);
//			em.merge(this.tipoProducto);
//			em.getTransaction().commit();
//			em.close();
//			cargarLista();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//	}

//	public void modificarAlmacen(RowEditEvent event) {
//		factory = Persistence.createEntityManagerFactory("Clothes1");
//		EntityManager em = factory.createEntityManager();
//
//		try {
//			Almacen almacen = (Almacen) event.getObject();
//			em.getTransaction().begin();
//			em.find(Almacen.class, almacen.getIdAlma());
//			em.merge(almacen);
//			em.getTransaction().commit();
//			em.close();
//			inicializar();
//		} catch (Exception ex) {
//			em.getTransaction().rollback();
//		}
//
//	}

	public String eliminarAlmacen(Almacen almacen) {

		factory = Persistence.createEntityManagerFactory("Clothes1");
		EntityManager em = factory.createEntityManager();

		this.almacen = em.find(Almacen.class, almacen.getIdAlma());
		em.getTransaction().begin();
		em.remove(this.almacen);
		em.getTransaction().commit();
		em.close();
		inicializar();

		return "almacenLista.xhtml?faces-redirect=true";
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void inicializar() {
		factory = Persistence.createEntityManagerFactory("Clothes1");
		EntityManager em = factory.createEntityManager();
		almacenes = em.createNamedQuery("Almacen.findAll").getResultList();
	}

}
