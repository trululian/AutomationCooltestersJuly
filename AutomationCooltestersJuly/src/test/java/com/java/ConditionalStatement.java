package com.java;

public class ConditionalStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int limiteVel,velVehiculo;
		limiteVel = 80;
		velVehiculo = 60;
		
		if (velVehiculo > limiteVel) {
			System.out.println("toma tu multa");
		} else if (velVehiculo==limiteVel){
			System.out.println("vas al limite");
		} else {
			System.out.println("vas bien campeon :P ");
		}

	}

}
