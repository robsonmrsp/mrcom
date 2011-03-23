
package com.springteste.impl;

import com.springteste.interfaces.GreetingService;

public class GreetingServiceImp implements GreetingService{

	@Override
	public void sayGreeting() {
		System.out.println(greet);

	}
	private String greet;
	public void setGreet(String greet) {
		this.greet = greet;
	}
	public String getGreet() {
		return greet;
	}
	
	public GreetingServiceImp() {
	
	}
}
