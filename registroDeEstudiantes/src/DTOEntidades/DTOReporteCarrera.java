package DTOEntidades;

public class DTOReporteCarrera {
	
	private String nombreCarrera;
	private int anio;
	private int inscriptos_no_graduado;
	private int inscriptos_graduado;
	
	
	public DTOReporteCarrera() {
		super();
	}
	
	

	public DTOReporteCarrera(String nombreCarrera, int anio) {
		super();
		this.nombreCarrera = nombreCarrera;
		this.anio = anio;
	}



	public String getNombreCarrera() {
		return nombreCarrera;
	}


	public int getAnio() {
		return anio;
	}


	public int getInscriptos_no_graduado() {
		return inscriptos_no_graduado;
	}


	public int getInscriptos_graduado() {
		return inscriptos_graduado;
	}



	public void setInscriptos_no_graduado(int inscriptos_no_graduado) {
		this.inscriptos_no_graduado = inscriptos_no_graduado;
	}



	public void setInscriptos_graduado(int inscriptos_graduado) {
		this.inscriptos_graduado = inscriptos_graduado;
	}



	@Override
	public String toString() {
		return "DTOCarrera [nombreCarrera=" + nombreCarrera + ", anio=" + anio + ", inscriptos_no_graduado="
				+ inscriptos_no_graduado + ", inscriptos_graduado=" + inscriptos_graduado + "]";
	}
	
	
}
