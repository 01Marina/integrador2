package tablasConsultas;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import conexion.DAOConexionJPAHibernate;
import entidades.Matricula;



public class TablaMatricula {
	final String INSERT = "INSERT INTO persona (id, nombre, edad) VALUES(?, ?, ?)";
	final String UPDATE = "UPDATE persona SET nombre=?, edad=? WHERE id=?";
	final String DELETE = "DELETE FROM persona WHERE id=?";
	final String SELECTALL = "SELECT p FROM Persona p";
//	String sql = "SELECT p.anios FROM persona p";
//	final String SELECTID = "SELECT p FROM persona WHERE id=?";
	
	private static final DAOConexionJPAHibernate conexion = DAOConexionJPAHibernate.crearConexion2();
	
	public TablaMatricula() {}


	public void insertar(Matricula m) {
		conexion.crearConexion();
		EntityManager em = conexion.getEm();
		
		
		em.persist(m);
		
//		em.createQuery(INSERT)
//			.setParameter(1, p.getId())
//			.setParameter(2, p.getNombre())
//			.setParameter(3, p.getEdad())
//			.executeUpdate();
		
		conexion.cerrarConexion();
		
	}
	
	
    
    
}
