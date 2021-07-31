package com.poo;

public class Perro {
	
	int numPatas;
	String Color, tama�o, raza;
	
	//Constructor
	public Perro(int numPatas, String color, String tama�o, String raza) {

		this.numPatas = numPatas;
		Color = color;
		this.tama�o = tama�o;
		this.raza = raza;
	}
	
	public Perro(String color, String tama�o, String raza) {

		this.numPatas = 3;
		Color = color;
		this.tama�o = tama�o;
		this.raza = raza;
	}
	
	
	// Getters and setters
	public int getNumPatas() {
		return numPatas;
	}

	public void setNumPatas(int numPatas) {
		this.numPatas = numPatas;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public String getTama�o() {
		return tama�o;
	}

	public void setTama�o(String tama�o) {
		this.tama�o = tama�o;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	// metodo para imprimir datos del Perro
	
	public void imprimir () {
		System.out.println("el numero de patas es: "+numPatas);
		System.out.println("El color del perro es: "+Color);
		System.out.println("El tama�o del perro es: "+tama�o);
		System.out.println("La razo del Perro es: "+raza);
	}
	

}
