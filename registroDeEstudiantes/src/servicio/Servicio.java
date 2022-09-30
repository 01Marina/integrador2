package servicio;

import java.sql.Date;

import org.apache.derby.tools.sysinfo;

import entidades.Estudiante;
import entidades.Matricula;
import tablasConsultas.TablaEstudiante;

public class Servicio {

	public static void main(String[] args) {
		
		Estudiante est1 = new Estudiante("Gerardo",25,"m",561651651,"sagasg",125);
		Date fechaI = new Date(0);
		Matricula m1 = new Matricula("sgasg",fechaI,true,est1 );
		est1.addMatricula(m1);
		
		TablaEstudiante tabla1 = new TablaEstudiante();
		tabla1.insertar(est1);
		
		
		//System.out.println(est1);
		
		System.out.println(tabla1.getAll());
		
		
	}

}
