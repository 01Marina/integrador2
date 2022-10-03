package tablasConsultas;

import java.util.List;

import javax.persistence.EntityManager;

import conexion.DAOConexionJPAHibernate;
import entidades.Estudiante;

public class TablaEstudiante {
	
	final String SELECTALL_SORTEDBYNAME = "SELECT e FROM Estudiante e ORDER BY nombre ASC";
	final String GET_ESTUDIANTE = "SELECT e FROM Estudiante e WHERE e.libretaUniversitaria = :numLibreta";
	final String SELECTALL_GENRE = "SELECT e FROM Estudiante e WHERE e.genero = :gnr";

	
	private static final DAOConexionJPAHibernate conexion = DAOConexionJPAHibernate.crearConexion2();
	
	
	
	//2a
	
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
	
	
	
	//2c
	
	public List<Estudiante> getAllSorted() {
		conexion.crearConexion();
		EntityManager em = conexion.getEm(); 
		List<Estudiante> estudiantes = em.createQuery(SELECTALL_SORTEDBYNAME).getResultList();
		conexion.cerrarConexion();
		return estudiantes;
	}
	
	//2d
	
	public Estudiante getEstudiante(int numLibreta) {
		conexion.crearConexion();
		EntityManager em = conexion.getEm(); 
		
		Estudiante e = em.createQuery(GET_ESTUDIANTE, Estudiante.class)
						.setParameter("numLibreta", numLibreta)
						.setMaxResults(1)//max de resultados q traera (si no le pongo 1 el metodo de abajo no sabe cual de todas las filas retornadas elegir)
						.getSingleResult();//q la query devuelva 1 resultado
		
		conexion.cerrarConexion();
		return e;
	}
	
	//2c
	
	public List<Estudiante> getAllGenre(String gnr) {
		conexion.crearConexion();
		EntityManager em = conexion.getEm(); 
		List<Estudiante> estudiantes = em.createQuery(SELECTALL_GENRE)
										.setParameter("gnr", gnr)
										.getResultList();
		conexion.cerrarConexion();
		return estudiantes;
	}
	

}
