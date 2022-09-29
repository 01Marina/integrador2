package tablasConsultas;

import java.util.List;

import javax.persistence.EntityManager;

import conexion.DAOConexionJPAHibernate;
import entidades.Estudiante;

public class TablaEstudiante {
	
	final String SELECTALL = "SELECT e FROM Estudiante e";

	
	private static final DAOConexionJPAHibernate conexion = DAOConexionJPAHibernate.crearConexion2();
	
	
	public void insertar(Estudiante e) {
		conexion.crearConexion();
		EntityManager em = conexion.getEm();
		
		
		em.persist(e);
		
//		em.createQuery(INSERT)
//			.setParameter(1, p.getId())
//			.setParameter(2, p.getNombre())
//			.setParameter(3, p.getEdad())
//			.executeUpdate();
		
		conexion.cerrarConexion();
	}
	
	public List<Estudiante> getAll() {
		conexion.crearConexion();
		EntityManager em = conexion.getEm(); 
		@SuppressWarnings("unchecked")
		List<Estudiante> personas = em.createQuery(SELECTALL).getResultList();
		conexion.cerrarConexion();
		return personas;
	}

}
