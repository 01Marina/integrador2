package entidades;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Matricula {
	@Column
	private String carrera;
	@Column
	private Date fechaIngreso;
	@Column
	private Boolean graduado;
	@OneToMany
	private Estudiante estudiante;
	
	public Matricula() {
		super();
	}

	public Matricula(String carrera, Date fechaIngreso, Boolean graduado, Estudiante estudiante) {
		super();
		this.carrera = carrera;
		this.fechaIngreso = fechaIngreso;
		this.graduado = graduado;
		this.estudiante = estudiante;
	}

	@Override
	public String toString() {
		return "Matricula [carrera=" + carrera + ", fechaIngreso=" + fechaIngreso + ", graduado=" + graduado
				+ ", estudiante=" + estudiante + "]";
	}
	
	
}
