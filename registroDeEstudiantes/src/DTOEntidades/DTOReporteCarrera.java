package DTOEntidades;

public class DTOReporteCarrera {
	
	private String nombreCarrera;
	private int anio;
	private Long inscriptos_no_graduado;
	private Long inscriptos_graduado;
	
	
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


	public Long getInscriptos_no_graduado() {
		return inscriptos_no_graduado;
	}


	public Long getInscriptos_graduado() {
		return inscriptos_graduado;
	}



	public void setInscriptos_no_graduado(Long inscriptos_no_graduado) {
		this.inscriptos_no_graduado = inscriptos_no_graduado;
	}



	public void setInscriptos_graduado(Long long1) {
		this.inscriptos_graduado = long1;
	}



	@Override
	public String toString() {
		return "DTOReporteCarrera [nombreCarrera=" + nombreCarrera + ", anio=" + anio + ", inscriptos_no_graduado="
				+ inscriptos_no_graduado + ", inscriptos_graduado=" + inscriptos_graduado + "]";
	}
	
	
}
