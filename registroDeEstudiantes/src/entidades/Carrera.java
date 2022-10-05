package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carrera {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCarrera;
	@Column
	private String nombre;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "estudiante")
	private List<Matricula> matriculas;
	
	public Carrera() {
		super();
	}
	public Carrera(String nombre) {
		super();
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return idCarrera;
	}
	@Override
	public String toString() {
		return "Carrera [idCarrera=" + idCarrera + ", nombre=" + nombre + "]";
	}
	
	
	
}
