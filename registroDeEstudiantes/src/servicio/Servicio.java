package servicio;

import java.sql.Timestamp;
import java.time.LocalDate;

import entidades.Carrera;
import entidades.Estudiante;
import entidades.Matricula;
import tablasConsultas.TablaEstudiante;
import tablasConsultas.TablaMatricula;

public class Servicio {

	public static void main(String[] args) {
		
		Estudiante est1 = new Estudiante("papa",25,"m",561651651,"sagasg",125);
		
		Carrera c1 = new Carrera("matemáticas");
		Carrera c2 = new Carrera("política");
		
		LocalDate fecha =  LocalDate.now();
		Matricula m1 = new Matricula(c1, Timestamp.valueOf(fecha.toString()),false,est1);
		est1.addMatricula(m1);
		
		TablaEstudiante tablaEst = new TablaEstudiante();
		TablaMatricula tablaMat = new TablaMatricula();
		
//		System.out.println(tablaEst.getEstudiante(125));
//		System.out.println(tablaEst.getAllGenre("m"));
//		TablaMatricula tablaM = new TablaMatricula();
		
//		tablaEst.insertar(est1);
		
		
		tablaMat.matricularEstudiante(est1, c2);
		
		
	}

}
