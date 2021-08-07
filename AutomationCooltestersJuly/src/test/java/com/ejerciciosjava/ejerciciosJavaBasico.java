package com.ejerciciosjava;

public class ejerciciosJavaBasico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		System.out.println(isCatPlaying(true, 10));
		System.out.println(isCatPlaying(false, 36));
		System.out.println(isCatPlaying(false, 35)); 
		imprimirVerificadorNumeros(1, 1, 1); 
		imprimirVerificadorNumeros(1, 1, 2); 
		imprimirVerificadorNumeros(-1, -1, -1); 
		imprimirVerificadorNumeros(1, 2, 3);
		System.out.println(hasEqualSum(1, 1, 1));
		System.out.println(hasEqualSum(1, 1, 2));
		
		

	}// corchete final main

	static boolean isCatPlaying(boolean verano, int tempreatura) {

		if (!verano && (tempreatura >= 25 && tempreatura <= 35)) {
			return true;
		} else if (tempreatura >= 25 && tempreatura <= 45) {
			return true;
		} 
			return false;
	}// corchete final isCatPlaying

	static void imprimirVerificadorNumeros(int x, int y, int z) {
		if (x < 0 || y < 0 || z < 0) {
			System.out.println("valor no valido");
		} else if (x == y && x == z && y == z) {
			System.out.println("Todos los numeros son iguales");
		} else if (x != y && x != z && y != z) {
			System.out.println("Todos los numeros son diferentes");
		} else {
			System.out.println("Ni todos son iguales ni diferentes");
		}
	} // Corchete final metodo imprimirVerificadorNumeros

	static boolean hasEqualSum(int x, int y, int z) {
		if ((x + y) == z) {
			return true;
		} else {
			return false;
		}
	}//corchete final metodo hasEqualSum
	
	

} // Corchete final clase
