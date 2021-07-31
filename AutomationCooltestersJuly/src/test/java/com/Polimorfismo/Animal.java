package com.Polimorfismo;

public abstract class Animal {
	String animal;
	
	
	
	public Animal(String animal) {
		this.animal = animal;
	}

	public String getAnimal() {
		return this.animal;
		}

	public abstract void speak();
	
}
