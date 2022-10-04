package entidades;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Matricula {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMatricula;
	@Column
	private Timestamp fechaIngreso;
	@Column
	private Boolean graduado;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="idEstudiante")
	private Estudiante estudiante;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="idCarrera")
	private Carrera carrera;
	
	public Matricula() {
		super();
	}

	public Matricula(Carrera carrera, Timestamp fechaIngreso, Boolean graduado, Estudiante estudiante) {
		super();
		this.carrera = carrera;
		this.fechaIngreso = fechaIngreso;
		this.graduado = graduado;
		this.estudiante = estudiante;
	}

	@Override
	public String toString() {
		return "Matricula [carrera=" + carrera + ", fechaIngreso=" + fechaIngreso + ", graduado=" + graduado
				+"]";
	}

	public Timestamp getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Boolean getGraduado() {
		return graduado;
	}

	public void setGraduado(Boolean graduado) {
		this.graduado = graduado;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public int getIdMatricula() {
		return idMatricula;
	}
	
	
	
	
}
