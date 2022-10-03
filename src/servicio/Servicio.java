package servicio;

import java.sql.Date;


import org.apache.derby.tools.sysinfo;

import conexion.DAOConexionJPAHibernate;
import entidades.Estudiante;
import entidades.Matricula;
import tablasConsultas.TablaEstudiante;
import tablasConsultas.TablaMatricula;

public class Servicio {

	public static void main(String[] args) {
		
//		Estudiante est1 = new Estudiante("papa",25,"m",561651651,"sagasg",125);
//		Date fechaI = new Date(0);
		
//		Matricula m1 = new Matricula("PEPAsgasg",fechaI,true,est1 );
//		est1.addMatricula(m1);
		
//		TablaEstudiante tablaEst = new TablaEstudiante();
		TablaMatricula tablaMat = new TablaMatricula();
		System.out.println(tablaMat.getCarrerasOrdenCantAlumnos());
		
//		System.out.println(tablaEst.getEstudiante(125));
//		System.out.println(tablaEst.getAllGenre("m"));
//		TablaMatricula tablaM = new TablaMatricula();
		
//		tablaEst.insertar(est1);
		
		
	}

}
