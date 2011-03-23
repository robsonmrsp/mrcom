package com.teste.veiculo;


public class Carro {
	Motor motor ;
	CaixaMarcha caixaMarcha;
	public void setCaixaMarcha(CaixaMarcha caixaMarcha) {
		this.caixaMarcha = caixaMarcha;
	}
	public CaixaMarcha getCaixaMarcha() {
		return caixaMarcha;
	}
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
}
