package tablasConsultas;

import java.util.List;

import javax.persistence.EntityManager;

import conexion.DAOConexionJPAHibernate;
import entidades.Carrera;

public class TablaCarrera {
	
	final String SELECTCARRERAS_ORDEN_CANT_ALUMNOS = "SELECT c FROM Carrera c JOIN c.matriculas group by c.nombre ORDER BY count(c.nombre)";
	
	
	private static final DAOConexionJPAHibernate conexion = DAOConexionJPAHibernate.crearConexion2();
	
	public TablaCarrera() {}
	
	public void insertar(Carrera c) {
		conexion.crearConexion();
		EntityManager em = conexion.getEm();
		
		
		em.persist(c);
		
//		em.createQuery(INSERT)
//			.setParameter(1, p.getId())
//			.setParameter(2, p.getNombre())
//			.setParameter(3, p.getEdad())
//			.executeUpdate();
		
		conexion.cerrarConexion();
	}
	
	
	//2f
	
	public List<Carrera> getCarrerasOrdenCantAlumnos() {
		conexion.crearConexion();
		EntityManager em = conexion.getEm();
		@SuppressWarnings("unchecked")
		List<Carrera> carreras = em.createQuery(SELECTCARRERAS_ORDEN_CANT_ALUMNOS).getResultList();
		
		conexion.cerrarConexion();
		return carreras;
		
	}
}
