package DTOServicio;

import java.util.List;

import javax.persistence.EntityManager;

import DTOEntidades.DTOReporteCarrera;
import conexion.DAOConexionJPAHibernate;


public class DTOServicioCarrera {
	
//	final String SELECT_REPORTE = "SELECT new DTOCarrera("
//			+ "m.carrera.nombre, EXTRACT(YEAR FROM m.fechaIngreso), "
//			+ "COUNT(m.graduado=true), COUNT(m.graduado=false)) "
//			+ "FROM Matricula m "
//			+ "GROUP BY EXTRACT(YEAR FROM m.fechaIngreso)"
//			+ "ORDER BY m.carrera.nombre DESC";
//	
//	
	
	final String SELECT_CARRERAS_ANIO = "SELECT new DTOCarrera(m.carrera.nombre, EXTRACT(YEAR FROM m.fechaIngreso) AS anio) "
			+ "FROM Matricula m "
			+ "GROUP BY EXTRACT(YEAR FROM m.fechaIngreso)"
			+ "ORDER BY m.carrera.nombre DESC, EXTRACT(YEAR FROM m.fechaIngreso) DESC";
	
	final String SELECT_CARRERAS_ANIO_INSCRIPTOS_NO_GRADUADOS = "SELECT COUNT(m.graduado)"
			+ "FROM Matricula m WHERE m.nombre = :nombreCarrera AND EXTRACT(YEAR FROM m.fechaIngreso) = :anio AND m.graduado = false"
			+ "GROUP BY m.carrera.nombre";
	
	final String SELECT_CARRERAS_ANIO_INSCRIPTOS_GRADUADOS = "SELECT COUNT(m.graduado)"
			+ "FROM Matricula m WHERE m.nombre = :nombreCarrera AND EXTRACT(YEAR FROM m.fechaIngreso) = :anio AND m.graduado = true"
			+ "GROUP BY m.carrera.nombre";
	
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

		List<DTOReporteCarrera> carreras = em.createQuery(SELECT_CARRERAS_ANIO, DTOReporteCarrera.class).getResultList();
	
		for(DTOReporteCarrera c:carreras) {
			int inscriptos_no_graduados = em.createQuery(SELECT_CARRERAS_ANIO_INSCRIPTOS_NO_GRADUADOS)
					.setParameter("nombreCarrera", c.getNombreCarrera())
					.setParameter("anio", c.getAnio())
					.getFirstResult();
			c.setInscriptos_no_graduado(inscriptos_no_graduados);
			
			int inscriptos_graduados = em.createQuery(SELECT_CARRERAS_ANIO_INSCRIPTOS_GRADUADOS)
					.setParameter("nombreCarrera", c.getNombreCarrera())
					.setParameter("anio", c.getAnio())
					.getFirstResult();
			c.setInscriptos_graduado(inscriptos_graduados);
		}
		conexion.cerrarConexion();
		return carreras;
	}

}
