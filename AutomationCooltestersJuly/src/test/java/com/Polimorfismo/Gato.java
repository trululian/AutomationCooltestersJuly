package com.Polimorfismo;

public class Gato extends Animal {

	public Gato() {
		super("Gato");
	}

	@Override
	public void speak() {
		System.out.println(getAnimal() + " Meow-Meow");
	}

}
