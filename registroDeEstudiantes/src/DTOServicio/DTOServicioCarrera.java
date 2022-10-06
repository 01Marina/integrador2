package DTOServicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import DTOEntidades.DTOReporteCarrera;
import conexion.DAOConexionJPAHibernate;
import entidades.Matricula;


public class DTOServicioCarrera implements Serializable{
	
//	final String SELECT_REPORTE = "SELECT new DTOCarrera("
//			+ "m.carrera.nombre, EXTRACT(YEAR FROM m.fechaIngreso), "
//			+ "COUNT(m.graduado=true), COUNT(m.graduado=false)) "
//			+ "FROM Matricula m "
//			+ "GROUP BY EXTRACT(YEAR FROM m.fechaIngreso)"
//			+ "ORDER BY m.carrera.nombre DESC";
//	
//	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -372769571953990139L;

	final String SELECT_CARRERAS_ANIO = "SELECT m FROM Matricula m GROUP BY m.fechaIngreso, m.carrera.nombre  ORDER BY m.carrera.nombre DESC, m.fechaIngreso DESC";
	
	final String SELECT_CARRERAS_ANIO_INSCRIPTOS_NO_GRADUADOS = "SELECT COUNT(m) FROM Matricula m WHERE m.fechaEgreso IS NULL AND m.carrera.nombre = :nombreCarrera AND m.fechaIngreso = :anio ";
	
	final String SELECT_CARRERAS_ANIO_INSCRIPTOS_GRADUADOS = "SELECT COUNT(m.fechaEgreso) FROM Matricula m WHERE m.carrera.nombre = :nombreCarrera AND m.fechaIngreso = :anio AND m.fechaEgreso IS NOT NULL GROUP BY m.carrera.nombre";
	
	private static final DAOConexionJPAHibernate conexion = DAOConexionJPAHibernate.crearConexion2();
	
	public DTOServicioCarrera() {}
	
	//3
//	public List<DTOReporteCarrera> generarReporteDeCarreras() {
//		
//		conexion.crearConexion();
//		EntityManager em = conexion.getEm();
//		List<DTOReporteCarrera> carreras = em.createQuery(SELECT_REPORTE, DTOReporteCarrera.class).getResultList();
//		conexion.cerrarConexion();
//		return carreras;
//	}
	
	//3 (otra forma)
	public List<DTOReporteCarrera> generarReporteDeCarreras2() {
		conexion.crearConexion();
		EntityManager em = conexion.getEm();

		@SuppressWarnings("unchecked")
		List<Matricula> carreras = em.createQuery(SELECT_CARRERAS_ANIO).getResultList();
		
		ArrayList<DTOReporteCarrera> respuesta = new ArrayList<>();
		for(Matricula m: carreras) {
			respuesta.add(new DTOReporteCarrera(m.getCarrera().getNombre(), m.getFechaIngreso()));
		}
		
		for(DTOReporteCarrera c: respuesta) {
			int inscriptos_no_graduados = em.createQuery(SELECT_CARRERAS_ANIO_INSCRIPTOS_NO_GRADUADOS)
					.setParameter("nombreCarrera", c.getNombreCarrera())
					.setParameter("anio", c.getAnio())
					.getFirstResult();
			System.out.println("imprimo"+inscriptos_no_graduados);
			c.setInscriptos_no_graduado(inscriptos_no_graduados);
			
//			int inscriptos_graduados = em.createQuery(SELECT_CARRERAS_ANIO_INSCRIPTOS_GRADUADOS)
//					.setParameter("nombreCarrera", c.getNombreCarrera())
//					.setParameter("anio", c.getAnio())
//					.getFirstResult();
//			c.setInscriptos_graduado(inscriptos_graduados);
		}
		conexion.cerrarConexion();
		return respuesta;
	}

}
