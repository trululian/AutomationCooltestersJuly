package com.Polimorfismo;

public class Main {

	static Animal humano1 = new Humano();
	static Animal gato1 = new Gato();
	static Animal Gallo1 = new Gallo();
	static Animal Perro1 = new Perro();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		humano1.speak();
		gato1.speak();
		Gallo1.speak();
		Perro1.speak();
		*/

		// Humano
		Animal animal = new Humano();
		animal.speak();

		// Gato
		animal = new Gato();
		animal.speak();

		// Gallo
		animal = new Gallo();
		animal.speak();

		// PErro
		animal = new Perro();
		animal.speak();

	}

}
