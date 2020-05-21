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
import model.Categoria;

@ManagedBean
public class CategoriaBean {

	private static EntityManagerFactory factory;
	private Categoria categoria;
	private List<Categoria> categorias;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String guardarCategoria() {
		factory = Persistence.createEntityManagerFactory("Clothes1");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.persist(this.categoria);
		em.getTransaction().commit();
		em.close();
		inicializar();

		return "new-page";
	}

	public void editarCategoria(Categoria categoria) {
		factory = Persistence.createEntityManagerFactory("Clothes1");
		EntityManager em = factory.createEntityManager();

		this.categoria = em.find(Categoria.class, categoria.getNombreCateg());
		categoria.setNombreCateg(categoria.getNombreCateg());

		em.getTransaction().begin();
		em.merge(this.categoria);
		em.getTransaction().commit();
		em.close();
		inicializar();
	}	

	public String eliminarCategoria(Categoria categoria) {

		factory = Persistence.createEntityManagerFactory("Clothes1");
		EntityManager em = factory.createEntityManager();

		this.categoria = em.find(Categoria.class, categoria.getNombreCateg());
		em.getTransaction().begin();
		em.remove(this.categoria);
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
		categorias = em.createNamedQuery("Categoria.findAll").getResultList();
	}
}
