package com.java;

public class BucleStatements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//WHILESTATEMENT();
		//DOWHILEstatement();
		FORSTATEMENT();
	}
	
	public static void WHILESTATEMENT() {
		int num = 1;
		
		while (num<=10) {
			System.out.println("El numero es "+num);
			num ++;
		}
	}
	
	public static void DOWHILEstatement() {
		// Cuantas veces debe sumarse el numbase para llegar a 100 ??
		
		int numbase = 5, sumtotal = 0, contador = 0;
		
		do {
			sumtotal += numbase;
			contador++;
		} while (sumtotal < 100);
		
		System.out.println(" el numero se sumo a si mismo "+contador+ " veces");
					
	}

	public static void FORSTATEMENT() {
		int numeroFOR = 10;
		
		for (int i = 1; i<= numeroFOR; i++) {
			
			System.out.println("El numero For es "+i);
			
			if (i == 5) {
				break;
			}
		}
	}
}
