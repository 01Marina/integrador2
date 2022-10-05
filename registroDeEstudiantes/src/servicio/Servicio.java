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
		
		Estudiante est1 = new Estudiante("franco",22,"m",42573720,"tandil",123456);
		Estudiante est2 = new Estudiante("pepe",2,"m",2573720,"bsas",422456);
		Estudiante est3 = new Estudiante("mela",20,"f",42444720,"rauh",563456);
		
		Carrera c1 = new Carrera("matematicas");
		Carrera c2 = new Carrera("politica");
		Carrera c3 = new Carrera("fisica");
		Carrera c4 = new Carrera("web");
		Carrera c5 = new Carrera("ingles");
		
		//le doy carrera, estudiante y fecha
		Matricula m1 = new Matricula(c1, Timestamp.valueOf(LocalDate.now().toString()),false,est1);
		est1.addMatricula(m1);
		
		Matricula m2 = new Matricula(c4, Timestamp.valueOf(LocalDate.now().toString()),false,est3);
		est3.addMatricula(m2);
		
		Matricula m3 = new Matricula(c3, Timestamp.valueOf(LocalDate.now().toString()),false,est1);
		est1.addMatricula(m3);
		
		TablaEstudiante tablaEst = new TablaEstudiante();
		TablaMatricula tablaMat = new TablaMatricula();
		TablaMatricula tablaCarr = new tablaCarr();
		
//		System.out.println(tablaEst.getEstudiante(125));
//		System.out.println(tablaEst.getAllGenre("m"));
//		TablaMatricula tablaM = new TablaMatricula();
		
		tablaEst.insertar(est1);
		tablaEst.insertar(est2);
		tablaEst.insertar(est);
		tablaEst.insertar(c1);
		tablaEst.insertar(c2);
		tablaEst.insertar(c13);
		tablaEst.insertar(c4);
		tablaEst.insertar(c5);
		
		
		
		tablaMat.matricularEstudiante(est1, c2);
		
		
	}

}
