package s1t1n3;

public class Butaca {

	private int nombreFila;
	private int nombreSeient;
	private String personaReserva;

	public Butaca(int nombreFila, int nombreSeient, String personaReserva) {
		this.nombreFila = nombreFila;
		this.nombreSeient = nombreSeient;
		this.personaReserva = personaReserva;
	}

	public int getNombreFila() {
		return this.nombreFila;
	}
	public int getNombreSeient() {
		return this.nombreSeient;
	}
	public String getPersonaReserva() {
		return this.personaReserva;
	}

	public void setNombreFila(int nombreFila) {
		this.nombreFila = nombreFila;
	}
	public void setNombreSeient(int nombreSeient) {
		this.nombreSeient = nombreSeient;
	}
	public void setPersonaReserva(String personaReserva) {
		this.personaReserva = personaReserva;
	}

	public String toString(Butaca butaca) {
		return "Fila: " + butaca.getNombreFila() + ", Seient: " + butaca.getNombreSeient() + ", Persona: " 
				+ butaca.getPersonaReserva();
	}
	
	public boolean equals(Butaca butaca1, Butaca butaca2) {
		boolean iguals = false;

		if(butaca1.getNombreFila() == butaca2.getNombreFila() && butaca1.getNombreSeient() == butaca2.getNombreSeient()) {
			iguals = true;
		}
		return iguals;
	}



}
