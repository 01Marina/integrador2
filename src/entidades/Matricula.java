package entidades;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Matricula {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMatricula;
	@Column
	private String carrera;
	@Column
	private Date fechaIngreso;
	@Column
	private Boolean graduado;
	@OneToOne(cascade=CascadeType.ALL)
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
				+"]";
	}
	
	
}
