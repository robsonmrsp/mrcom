package com.strategy;

public class SimUDuck {

	public static void main(String[] args) {
		
		Duck duck = new MallardDuck();
		duck.setFlyBehavior(new FlyNoWay());
		duck.setQuackBehavior(new Quack());
		
		//inicialmente faremos a execução dos comportamentos setados para nosso pato
		duck.performFly();
		duck.performQuack();
		
		//Agora iremos ltrerar EM TEMPO DE EXECUCAO os comportamentos do pato
		
		
	}
}
