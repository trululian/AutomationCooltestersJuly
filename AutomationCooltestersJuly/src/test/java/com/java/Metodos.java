package com.java;

public class Metodos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		wrappedMethod(20, 4, 5);
	}

	public static void suma(int x, int y) {
		int sumtotal = x + y;
		System.out.println("la suma es " + sumtotal);
	}

	public static void contador(int x) {

		for (int i = 0; i <= x; i++) {
			System.out.println("El numero del contador FOR es : " + i);
		}
	}

	public static void wrappedMethod(int a, int b, int c) {
		contador(a);
		suma(b, c);
	}

}
