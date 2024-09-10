package logica;

public class Fecha {

	private int dia;
	private int mes;
	private int anio;
	
	//constructor específico
	public Fecha(int dia, int mes, int anio) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	
	//constructor por defecto
	public Fecha() {
		
	}
	
	@Override
	public String toString() {
		return  dia + "/" + mes + "/"+anio;
	}

	private boolean esBisiesto ()	{
		
		return ((anio % 4 == 0) && (anio % 100 != 0) || (anio %400 == 0));		
	}

	public boolean fechaCorrecta ()	{

		boolean diaCorrecto, mesCorrecto, anyoCorrecto;

		anyoCorrecto = (anio > 0);
		mesCorrecto = (mes >= 1) && (mes <= 12);

		switch (mes)	{
			case 2:
				if (esBisiesto ())	{
					diaCorrecto = (dia >= 1 && dia <= 29);
				} else	{
					diaCorrecto = (dia >= 1 && dia <= 28);
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				diaCorrecto = (dia >= 1 && dia <= 30);
				break;
			default:
				diaCorrecto = (dia >= 1 && dia <= 31);
		}
		return diaCorrecto && mesCorrecto && anyoCorrecto;
	}
	
	
	
	
}
