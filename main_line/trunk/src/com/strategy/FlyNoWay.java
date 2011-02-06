package com.strategy;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("Infelizmente, não sei voar!!!");

	}

}
