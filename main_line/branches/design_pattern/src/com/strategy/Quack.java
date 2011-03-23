package com.strategy;

public class Quack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("Quack, quack, quack!!!");
		System.out.println("Teste de branch");
	}
}