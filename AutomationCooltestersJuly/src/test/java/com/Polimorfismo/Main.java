package com.Polimorfismo;

public class Main {
	
	public static Animal humano1 =  new Humano();
	public static Animal gato1 = new Gato();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		humano1.speak();
		gato1.speak();
		
		// Humano
		Animal animal = new Humano();
		animal.speak();

		// Gato
		animal = new Gato();
		animal.speak();

		//Humano
		animal = new Humano();
		animal.speak();
	}

}
