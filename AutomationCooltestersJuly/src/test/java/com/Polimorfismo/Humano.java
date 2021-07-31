package com.Polimorfismo;

public class Humano extends Animal {

	public Humano() {
		super("Humano");
	}

	@Override
	public void speak() {
		System.out.println(getAnimal() + " Habla");
	}

}
