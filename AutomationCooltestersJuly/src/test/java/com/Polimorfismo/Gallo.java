package com.Polimorfismo;

public class Gallo extends Animal {

	public Gallo() {
		super("Gallo");
	}
	
	@Override
	public void speak() {
		System.out.println(getAnimal() + " kikiriki");
	}
	

}
