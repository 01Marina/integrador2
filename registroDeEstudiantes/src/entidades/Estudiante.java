package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEstuduante;
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
	
	public Estudiante() {
		super();
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
	}

	@Override
	public String toString() {
		return "Estudiante [idEstuduante=" + idEstuduante + ", nombre=" + nombre + ", edad=" + edad + ", genero="
				+ genero + ", dni=" + dni + ", ciudadDeResidencia=" + ciudadDeResidencia + ", libretaUniversitaria="
				+ libretaUniversitaria + "]";
	}
	
	
}