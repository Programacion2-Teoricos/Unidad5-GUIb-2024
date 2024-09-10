package logica;

public class Fecha {

	private int dia;
	private int mes;
	private int anio;
	
	
	public Fecha(int dia, int mes, int anio) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	
	//agregue
	public Fecha() {
		
	}
	
	@Override
	public String toString() {
		return  dia + "/" + mes + "/"+anio;
	}
	
	
	
	
}
