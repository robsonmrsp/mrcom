package com.strategy;

public class MuteQuack implements FlyBehavior{

	@Override
	public void fly() {
		System.out.println("Infelizmente, não sei fazer Quack");		
	}
}
