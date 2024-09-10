package logica;

public class Alumno {
	private String apellido;
	private int grupo;
	private double cuotaBase;
		
	public Alumno(String apellido, int grupo, double cuotaBase) {
		this.apellido = apellido;
		this.grupo = grupo;
		this.cuotaBase = cuotaBase;
		
	}

	public Alumno() {
		
		
	}

	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public double getCuotaBase() {
		return cuotaBase;
	}

	public void setCuotaBase(double cuotaBase) {
		this.cuotaBase = cuotaBase;
	}

	@Override
	public String toString() {
		return "apellido= " + apellido + 
				", grupo= " + grupo + 
				", cuotaBase= " + cuotaBase;
	}
	
	public double cuotaNeta() {
		double monto=cuotaBase;
		
		if(grupo==1||grupo==2)
			monto=cuotaBase*0.60;
		if (grupo==3||grupo==4)
			monto=cuotaBase*0.80;
		return monto;
	}
	
	
}
