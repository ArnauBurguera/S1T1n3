package s1t1n3;

import java.util.Scanner;

public class Cine {

	Scanner sc = new Scanner(System.in);

	private int nombreFilesCinema;
	private int nombreSeientsPerFila;
	private GestioButaques gestorButaques;

	public Cine() {
		this.gestorButaques = new GestioButaques();
		demanarDadesInicials();
	}
	public int getNombreFilesCinema() {
		return this.nombreFilesCinema;
	}
	public int getNombreSeientsPerFila() {
		return this.nombreSeientsPerFila;
	}
	public GestioButaques getGestorButaques() {
		return this.gestorButaques;
	}

	public void setNombreFilesCinema(int nombreFilesCinema) {
		this.nombreFilesCinema = nombreFilesCinema;
	}
	public void setNombreSeientsPerFila(int nombreSeientsPerFila) {
		this.nombreSeientsPerFila = nombreSeientsPerFila;
	}
	public void setGestorButaques(GestioButaques gestorButaques) {
		this.gestorButaques = gestorButaques;
	}
	
	public void demanarDadesInicials() {
		
		System.out.print("Introdueix el nombre de files que tindrà el cinema: ");
		this.nombreFilesCinema = sc.nextInt();
		System.out.print("Introdueix el nombre de seients: ");
		this.nombreSeientsPerFila = sc.nextInt();
	}

	public void iniciar() {
		int opcio = -1;
		
		do {
			opcio = menu();
			switch(opcio) {
			case 0:
				System.out.print("A reveure!");
				break;
			case 1:
				mostrarButaques();
				break;
			case 2:
				mostrarButaquesPersona();
				break;
			case 3:
				reservarButaca();
				break;
			case 4:
				anularReserva();
				break;
			case 5:
				anularReservaPersona();
				break;
			}
		}while(opcio != 0);
		
	}

	public int menu() {
		int opcio = -1;


		System.out.print("CINEMA:\n"
				+ "1.Mostrar totes les butaques reservades\n"
				+ "2.Mostrar les butaques reservades per una persona\n"
				+ "3.Reservar una butaca\n"
				+ "4.Anul·lar la reserva d'una butaca\n"
				+ "5.Anul·lar totes les reserves d'una persona\n"
				+ "0.Sortir\n\n"
				+ "Navegar: ");

		opcio = sc.nextInt();

		while(opcio < 0 || opcio > 5) {
			System.out.print("El nombre introduït no és correcte.\nTorna-ho a intentar: ");
			opcio = sc.nextInt();
		}
		return opcio;
	}

	public void mostrarButaques() {
		for(Butaca butaca : gestorButaques.getButaques()) {
			System.out.println("- F: " + butaca.getNombreFila() + " : S:" + butaca.getNombreSeient());
		}
	}

	public void mostrarButaquesPersona() {
		String nom = "";

		System.out.println("Introdueix el nom i cognom separats per un espai de l'usuari de qui en vols veure "
				+ "les buatques reservades: ");
		sc.nextLine();
		nom = sc.nextLine();
		System.out.println("Les butaques reservades per " + nom + " son:\n");

		for(int i = 0; i < gestorButaques.getButaques().size(); i++) {
			if(gestorButaques.getButaques().get(i).getPersonaReserva().equalsIgnoreCase(nom)) {
				System.out.println("- F: " + gestorButaques.getButaques().get(i).getNombreFila() 
						+ " : S:" + gestorButaques.getButaques().get(i).getNombreSeient());
			}
		}
	}
	
	public void reservarButaca() {
		Butaca butacaNova = null;
		
		try {
			butacaNova = new Butaca(introduirFila(),introduirSeient(),introduirPersona());
			gestorButaques.afegirButaca(butacaNova);	
		}catch(ExcepcioFilaIncorrecta | ExcepcioSeientIncorrecte | ExcepcioNomPersonaIncorrecte | ExcepcioButacaOcupada e) {
			System.out.print(e.getMessage());
		}
	}
	
	public void anularReserva() {
		
		try {
			gestorButaques.eliminarButaca(introduirFila(),introduirSeient());
		}catch(ExcepcioFilaIncorrecta | ExcepcioSeientIncorrecte | ExcepcioButacaLliure e) {
			System.out.print(e.getMessage());
		}	
	}
	
	
	public void anularReservaPersona() {
		String nom = "";
		
		try {
			nom = introduirPersona();
			
			for(int i = 0; i < gestorButaques.getButaques().size(); i++) {
				if(gestorButaques.getButaques().get(i).getPersonaReserva().equalsIgnoreCase(nom)) {
					gestorButaques.getButaques().remove(i);
				}
			}
			
		}catch(ExcepcioNomPersonaIncorrecte e) {
			System.out.print(e.getMessage());
		}	
	}
	
	public String introduirPersona() throws ExcepcioNomPersonaIncorrecte{
		String nom = "";
		
		System.out.print("Introdueix un nom i un cognom separats per un espai: ");
		sc.nextLine();
		nom = sc.nextLine();
		
		if(nom.contains("1") || nom.contains("2") || nom.contains("3") || nom.contains("4") || nom.contains("5")
		 || nom.contains("6") || nom.contains("7") || nom.contains("8") || nom.contains("9") || nom.contains("0")) {
			throw new ExcepcioNomPersonaIncorrecte("Error de format. El nom no pot contenir números.\n");
		}else{
			return nom;
		}
	}
	
	public int introduirFila() throws ExcepcioFilaIncorrecta{
		int fila = 0;
		
		System.out.print("Introdueix el nombre de la fila: ");
		fila = sc.nextInt();
		
		if(fila > 0 && fila <= this.getNombreFilesCinema()) {
			return fila;
		}else{
			throw new ExcepcioFilaIncorrecta("La fila introduïda és invàlida.\n");
		}
	}
	
	public int introduirSeient() throws ExcepcioSeientIncorrecte{
		int seient = 0;
		
		System.out.print("Introdueix el nombre del seient: ");
		seient = sc.nextInt();
		
		if(seient > 0 && seient <= this.getNombreSeientsPerFila()) {
			return seient;
		}else{
			throw new ExcepcioSeientIncorrecte("El seient introduït no és vàlid.\n");
		}
	}
	
	
}







