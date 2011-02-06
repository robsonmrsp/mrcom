package com.strategy;

public abstract class Duck {

	FlyBehavior flyBehavior; 
	QuackBehavior quackBehavior;

	public void performFly(){
		if(flyBehavior == null)
			throw new IllegalStateException("É necessário definir o comportamento de fly");
		flyBehavior.fly();
	}
	public void performQuack(){
		if(quackBehavior == null)
			throw new IllegalStateException("É necessário definir o comportamento de quack");
		quackBehavior.quack();
	}
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}
	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	public abstract void display() ;
}
