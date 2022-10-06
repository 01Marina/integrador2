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
public class Carrera {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCarrera;
	@Column
	private String nombre;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "carrera", cascade=CascadeType.ALL)
	private List<Matricula> matriculas;
	
	public Carrera() {
		super();
		this.matriculas = new ArrayList<>();
	}
	public Carrera(String nombre) {
		super();
		this.nombre = nombre;
		this.matriculas = new ArrayList<>();
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
