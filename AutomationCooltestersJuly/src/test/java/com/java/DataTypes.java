package com.java;

public class DataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte abc = 127;
		short var = 30000;
		long var2 = 2147483647;
		int altura = (int) 2.54;
		System.out.println(altura);

		char letra = '\u00D4';
		System.out.println(letra);

		String frase = "hola " + letra + " " + abc + " " + var + " " + altura;

		System.out.println(frase);

		boolean isDog = true;

		int x, y, suma;
		x = 3;
		y = 4;
		suma = x + y;
		System.out.println("La suma es " + suma);

		// UNARIO
		int a = 3;
		a++;
		a += 4;
		System.out.println("El valor de a es" + a);

		// Relacionales

		int var1, vari2;
		var1 = 3;
		vari2 = 4;
		if (var1 <= vari2) {
			System.out.println("HERE");
		}

	}

}
