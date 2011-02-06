package com.strategy;

public class FlyWithWings implements FlyBehavior{

	@Override
	public void fly() {
		System.out.println("Estou voando com as asas");
	}

}
