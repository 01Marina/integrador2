package tablasConsultas;

import java.util.List;

import javax.persistence.EntityManager;

import conexion.DAOConexionJPAHibernate;
import entidades.Carrera;

public class TablaCarrera {
	
	final String SELECTCARRERAS_ORDEN_CANT_ALUMNOS = "SELECT c FROM Carrera c JOIN Carrera_Estudiante ce group by carrera ORDER BY count(c)";
	
	
	private static final DAOConexionJPAHibernate conexion = DAOConexionJPAHibernate.crearConexion2();
	
	public TablaCarrera() {}
	
	
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
