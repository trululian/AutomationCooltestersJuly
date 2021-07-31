package com.poo;

public class MAIN {

	public static Perro labrador = new Perro(4, "dorado","grande","Golden labrador");
	public static Perro Chihuaha = new Perro ("Blanco","Chico","Cabeza de manzana");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("antes de cambios");
		labrador.imprimir();
		System.out.println("despues de cambios");
		labrador.ingresar(4, "cafe", "pequeño", "labrador mezclado]");
		labrador.imprimir();
	}

}
