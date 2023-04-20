package s1t1n3;

import java.util.ArrayList;

public class GestioButaques {

	private ArrayList<Butaca> butaques;

	public GestioButaques() {
		this.butaques = new ArrayList<Butaca>();
	}

	public ArrayList<Butaca> getButaques() {
		return this.butaques;
	}

	public void setButaques(ArrayList<Butaca> butaques) {
		this.butaques = butaques;
	}

	public void afegirButaca(Butaca butaca) throws ExcepcioButacaOcupada {
		int fila = butaca.getNombreFila();
		int seient = butaca.getNombreSeient();

		if(cercarButaca(fila,seient) == -1) {
			butaques.add(butaca);
		}else {
			throw new ExcepcioButacaOcupada("La butaca amb fila: " + butaca.getNombreFila()
			+ " i seient: " + butaca.getNombreSeient() + " ja està ocupada.\n");
		}
	}

	public void eliminarButaca(int fila, int seient) throws ExcepcioButacaLliure {
		int posicio = cercarButaca(fila,seient);
		
		if(posicio != -1) {
			butaques.remove(posicio);
		}else {
			throw new ExcepcioButacaLliure("No s'ha trobat cap butaca a la fila: " + fila
			+ " i seient: " + seient + ".");
		}
	}

	public int  cercarButaca(int nombreFila, int nombreSeient) {
		int i = 0, posicio = -1;

		while(i < butaques.size()) {
			if(butaques.get(i).getNombreFila() == nombreFila && butaques.get(i).getNombreSeient() == nombreSeient) {
				posicio = i;
				i = butaques.size();
			}
			i++;
		}
		return posicio;

	}

}
