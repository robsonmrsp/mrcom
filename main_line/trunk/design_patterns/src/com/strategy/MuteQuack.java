package com.strategy;

public class MuteQuack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("Infelizmente, não sei fazer Quack");		
	}
}
