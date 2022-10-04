package tablasConsultas;


import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import conexion.DAOConexionJPAHibernate;
import entidades.Carrera;
import entidades.Estudiante;
import entidades.Matricula;



public class TablaMatricula {
	final String INSERT = "INSERT INTO matricula (idMatricula, fechaIngreso, graduado, idEstudiante, idCarrera) VALUES(?1,?2,?3,?4,?5)";
//	final String DELETE = "DELETE FROM persona WHERE id=?";
//	final String SELECTALL = "SELECT m FROM Persona p";
	
	final String SELECTCARRERAS_ORDEN_CANT_ALUMNOS = "SELECT m.carrera, count(*) AS cantidadAlumnos FROM Matricula m GROUP BY carrera ORDER BY count(*)";
//	SELECT m FROM Matricula group by carrera order by count(*)

	//	String sql = "SELECT p.anios FROM persona p";
//	final String SELECTID = "SELECT p FROM persona WHERE id=?";
	
	private static final DAOConexionJPAHibernate conexion = DAOConexionJPAHibernate.crearConexion2();
	
	public TablaMatricula() {}

//	2b
	public void matricularEstudiante(Estudiante e, Carrera c) {
		LocalDate fecha =  LocalDate.now();
		Matricula m = new Matricula(c, Timestamp.valueOf(fecha.toString()), false, e);
		conexion.crearConexion();
		EntityManager em = conexion.getEm();
		
		em.createQuery(INSERT)
			.setParameter(1, m.getIdMatricula())
			.setParameter(2, m.getFechaIngreso())
			.setParameter(3, m.getGraduado())
			.setParameter(4, m.getEstudiante())
			.setParameter(5, m.getCarrera())
			.executeUpdate();
		
		conexion.cerrarConexion();
		
	}
	

	

	
    
    
}
