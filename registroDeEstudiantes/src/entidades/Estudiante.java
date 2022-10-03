package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEstudiante;
	@Column(nullable=false)
	private String nombre;
	@Column(name="anios")
	private int edad;
	@Column
	private String genero;
	@Column
	private int dni;
	@Column
	private String ciudadDeResidencia;
	@Column
	private int libretaUniversitaria;
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "estudiante", cascade=CascadeType.ALL)
	private List<Matricula> matriculas;
	
	public Estudiante() {
		super();
		this.matriculas = new ArrayList<Matricula>();
	}

	public Estudiante(String nombre, int edad, String genero, int dni, String ciudadDeResidencia,
			int libretaUniversitaria) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.genero = genero;
		this.dni = dni;
		this.ciudadDeResidencia = ciudadDeResidencia;
		this.libretaUniversitaria = libretaUniversitaria;
		this.matriculas = new ArrayList<Matricula>();
	}

	public void addMatricula(Matricula m) {
		this.matriculas.add(m);
	}

	@Override
	public String toString() {
		return "Estudiante [idEstuduante=" + idEstudiante + ", nombre=" + nombre + ", edad=" + edad + ", genero="
				+ genero + ", dni=" + dni + ", ciudadDeResidencia=" + ciudadDeResidencia + ", libretaUniversitaria="
				+ libretaUniversitaria + ", matriculas=" + devolverMatriculas() + "]";
	}
	
	public String devolverMatriculas() {
		String cadena = " ";
		for(Matricula m : matriculas) {
			cadena += m.toString();
		}
		return cadena;
	}
	
	
	
}