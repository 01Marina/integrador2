package entidades;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private int fechaIngreso;
	
	@Column (nullable = true)
	private Integer fechaEgreso;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="idEstudiante")
	private Estudiante estudiante;
	
	@ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name="idCarrera")
	private Carrera carrera;
	
	public Matricula() {
		super();
	}

	public Matricula(Carrera carrera, int fechaIngreso, Estudiante estudiante) {
		super();
		this.carrera = carrera;
		this.fechaIngreso = fechaIngreso;
		this.estudiante = estudiante;
	}
	
	public Matricula(Carrera carrera, int fechaIngreso, int fechaEgreso, Estudiante estudiante) {
		super();
		this.carrera = carrera;
		this.fechaIngreso = fechaIngreso;
		this.fechaEgreso = fechaEgreso;
		this.estudiante = estudiante;
	}

	@Override
	public String toString() {
		return "Matricula [carrera=" + carrera + ", fechaIngreso=" + fechaIngreso +"]";
	}

	public int getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(int fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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

	public Integer getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(Integer fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}
	
	
	
	
}
