package com.ejerciciosjava;

public class ejercicioJavaIntermedio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		arregloBidireccional();
	}
	
	public static void arregloBidireccional() {
		String[][] nombreCompleto = new String[4][2];
		nombreCompleto[0][0] = "Ricardo";
		nombreCompleto[0][1] = "Avalos";
		nombreCompleto[1][0] = "Oscar";
		nombreCompleto[1][1] = "Trujillo";
		nombreCompleto[2][0] = "Sonia";
		nombreCompleto[2][1] = "Rojas";
		nombreCompleto[3][0] = "Alejandro";
		nombreCompleto[3][1] = "Soria";

		// System.out.println("El nombre es "+ nombreCompleto[0][0] +
		// nombreCompleto[0][1]);

		for (int i = 0; i < nombreCompleto.length; i++) {
			for (int j = 0; j < nombreCompleto[i].length; j++) {
				System.out.println("El nombre es " + nombreCompleto[i][j] + " "+ nombreCompleto[i][j+=1]);
			}
		}

	}

}
