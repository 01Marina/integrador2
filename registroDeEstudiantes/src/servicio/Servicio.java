package servicio;


import DTOEntidades.DTOReporteCarrera;
import DTOServicio.DTOServicioCarrera;
import entidades.Carrera;
import entidades.Estudiante;
import entidades.Matricula;
import tablasConsultas.TablaCarrera;
import tablasConsultas.TablaEstudiante;
import tablasConsultas.TablaMatricula;

public class Servicio {

	public static void main(String[] args) {
		
		Estudiante est1 = new Estudiante("franco",22,"m",42573720,"tandil",123456);
		Estudiante est2 = new Estudiante("pepe",2,"m",2573720,"bsas",422456);
		Estudiante est3 = new Estudiante("mela",20,"f",42444720,"rauch",563456);
		Estudiante est4 = new Estudiante("Macarena",20,"f",6765765,"rauch",3454353);
		Estudiante est5 = new Estudiante("mela",20,"f",34535,"rauch",34534);
		Estudiante est6 = new Estudiante("Ester",20,"f",6757,"mar del plata",3453453);
		Estudiante est7 = new Estudiante("Camila",20,"f",90800797,"mar del plata",234234);
		Estudiante est8 = new Estudiante("Mrena",20,"f",1232444,"tandil",5754754);
		Estudiante est9 = new Estudiante("Dalma",20,"f",7675454,"rauch",7897897);
		Estudiante est10 = new Estudiante("Veronica",20,"f",33443678,"rauch",23523);
		
		Carrera c1 = new Carrera("matematicas");
		Carrera c2 = new Carrera("politica");
		Carrera c3 = new Carrera("fisica");
		Carrera c4 = new Carrera("web");
		Carrera c5 = new Carrera("ingles");
		
		
		//le doy carrera, estudiante y fecha
		Matricula m1 = new Matricula(c1, 2021,est1);//no egresado
		est1.addMatricula(m1);
		
		Matricula m2 = new Matricula(c4, 2020, 2021,est1);//egresado
		est1.addMatricula(m2);
		
		
		TablaEstudiante tablaEst = new TablaEstudiante();
		TablaMatricula tablaMat = new TablaMatricula();
		TablaCarrera tablaCarr = new TablaCarrera();
		
//		System.out.println(tablaEst.getEstudiante(125));
//		System.out.println(tablaEst.getAllGenre("m"));
//		TablaMatricula tablaM = new TablaMatricula();
		
//		//carga de carreras
//		tablaCarr.insertar(c1);
//		tablaCarr.insertar(c2);
//		tablaCarr.insertar(c3);
//		tablaCarr.insertar(c4);
//		tablaCarr.insertar(c5);
//		//carga de estudiantes
//		tablaEst.insertar(est1);
//		tablaEst.insertar(est2);
//		tablaEst.insertar(est3);
//		tablaEst.insertar(est4);
//		tablaEst.insertar(est5);
//		tablaEst.insertar(est6);
//		tablaEst.insertar(est7);
//		tablaEst.insertar(est8);
//		tablaEst.insertar(est9);
//		tablaEst.insertar(est10);
//		//carga de matriculas
//		tablaMat.matricularEstudiante(est2, c2);
//		tablaMat.matricularEstudiante(est3, c2);
//		tablaMat.matricularEstudiante(est4, c2);
//		tablaMat.matricularEstudiante(est5, c2);
//		
//		tablaMat.matricularEstudiante(est6, c3);
//		tablaMat.matricularEstudiante(est7, c3);
//		
//		tablaMat.matricularEstudiante(est8, c4);
//		tablaMat.matricularEstudiante(est9, c4);
//		tablaMat.matricularEstudiante(est10, c4);
//		
//		tablaMat.matricularEstudiante(est1, c5);
//		tablaMat.matricularEstudiante(est2, c5);
//		tablaMat.matricularEstudiante(est3, c5);
//		tablaMat.matricularEstudiante(est4, c5);
		
		//2c
//		for(Estudiante e: tablaEst.getAllSorted()){
//			System.out.println(e);
//		}

		//2d
//		System.out.println(tablaEst.getEstudiante(3453453));
		
		//2e
//		for(Estudiante e: tablaEst.getAllGenre("m")){
//			System.out.println(e);
//		}
		
		//2f
//		for(Carrera c: tablaCarr.getCarrerasOrdenCantAlumnos()){
//			System.out.println(c);
//		}
		
		//2g
//		for(Estudiante e: tablaEst.getCarrerasOrdenCantAlumnos(c5, "rauch")){
//			System.out.println(e);
//		}
		
		//3
		DTOServicioCarrera DTOC = new DTOServicioCarrera();
		
		for(DTOReporteCarrera d: DTOC.generarReporteDeCarreras2()) {
			System.out.println(d);
		}
	}

}
