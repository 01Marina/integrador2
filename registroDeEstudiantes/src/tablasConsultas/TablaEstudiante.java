package tablasConsultas;

import java.util.List;

import javax.persistence.EntityManager;

import conexion.DAOConexionJPAHibernate;
import entidades.Carrera;
import entidades.Estudiante;

public class TablaEstudiante {
	
	final String SELECTALL_SORTEDBYNAME = "SELECT e FROM Estudiante e ORDER BY nombre ASC";
	final String GET_ESTUDIANTE = "SELECT e FROM Estudiante e WHERE e.libretaUniversitaria = :numLibreta";
	final String SELECTALL_GENRE = "SELECT e FROM Estudiante e WHERE e.genero = :gnr";
	final String SELECT_ESTUDIANTES_CARRERA_CIUDAD = "SELECT e FROM Estudiante e JOIN Carrera_Estudiante ce WHERE ce.carrera = :carrera AND e.ciudad=:ciudad";

	
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
	//ordenamiento por nombre
	
	public List<Estudiante> getAllSorted() {
		conexion.crearConexion();
		EntityManager em = conexion.getEm(); 
		@SuppressWarnings("unchecked")
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
	
	//2e
	
	public List<Estudiante> getAllGenre(String gnr) {
		conexion.crearConexion();
		EntityManager em = conexion.getEm();
		@SuppressWarnings("unchecked")
		List<Estudiante> estudiantes = em.createQuery(SELECTALL_GENRE)
										.setParameter("gnr", gnr)
										.getResultList();
		conexion.cerrarConexion();
		return estudiantes;
	}
	
	
	//2g
	
	public List<Estudiante> getCarrerasOrdenCantAlumnos(Carrera carrera, String ciudad) {
		String nombreCarreraString = carrera.getNombre();
		conexion.crearConexion();
		EntityManager em = conexion.getEm();
		@SuppressWarnings("unchecked")
		List<Estudiante> estudiantes = em.createQuery(SELECT_ESTUDIANTES_CARRERA_CIUDAD)
										.setParameter("carrera", nombreCarreraString)
										.setParameter("ciudad", ciudad)
										.getResultList();
		
		conexion.cerrarConexion();
		return estudiantes;
		
	}
	

}
