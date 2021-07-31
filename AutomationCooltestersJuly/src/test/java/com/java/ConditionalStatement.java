package com.java;

public class ConditionalStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//IFstatements();
		//SwitchCase();
	}

	public static void IFstatements() {
		int limiteVel, velVehiculo;
		limiteVel = 80;
		velVehiculo = 90;

		/////////// IF anidado //////////////

		boolean carretera = false;

		if (carretera) {
			System.out.println("Carretera");
			limiteVel = 110;

			if (velVehiculo > limiteVel) {
				System.out.println("toma tu multa");
			} else if (velVehiculo == limiteVel) {
				System.out.println("vas al limite");
			} else {
				System.out.println("vas bien campeon :P ");
			}
		} else if (velVehiculo > limiteVel) {
			System.out.println("toma tu multa");
		} else if (velVehiculo == limiteVel) {
			System.out.println("vas al limite");
		} else {
			System.out.println("vas bien campeon :P ");
		}
	}

	public static void SwitchCase() {

		int temperatura = 16;

		switch (temperatura) {

		case 5:
			System.out.println("Clima muy frio");
			break;

		case 10:
		case 15:
			System.out.println("Clima frio");
			break;

		case 18:
		case 20:
			System.out.println("Clima templado");
			break;

		case 30:
			System.out.println("Clima calido");
			break;

		default:
			System.out.println("Clima no reconocido por el sistema");
			break;
		}
	}

	
}
