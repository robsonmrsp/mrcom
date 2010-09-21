package br.com.mrcom.domain.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable 
public class Cpf implements Serializable{
	
	private String valor = "";
	private static final long serialVersionUID = 1L;
	public static long contadorCpf = 0;
	
	private static final  List<String> cpfsInvalidos = new ArrayList<String>();
	static {
		cpfsInvalidos.add("00000000000");
		cpfsInvalidos.add("11111111111");
		cpfsInvalidos.add("22222222222");
		cpfsInvalidos.add("33333333333");
		cpfsInvalidos.add("44444444444");
		cpfsInvalidos.add("55555555555");
		cpfsInvalidos.add("66666666666");
		cpfsInvalidos.add("77777777777");
		cpfsInvalidos.add("88888888888");
		cpfsInvalidos.add("99999999999");
	}
	@Transient
	private int[] digitos = null;

	public Cpf() {
		
		contadorCpf++;				
	}

	/** Contrutor
	 * @param pCpf
	 */
	public Cpf(String pCpf) {

		setValor(pCpf);
	}

	public void setValor(String pCpf){

		digitos = convertString2ArrayInt(pCpf);
		//valor = this.toString();  removido em 20 de 04
		valor = pCpf.replaceAll("[^\\d]", "");
	}

	public String getValor(){

		return this.valor;
	}
	
	public String format(){
		
		return this.toString();
	}
	/**
	 * Remove todos os caracteres NÃO numéricos e transforma a string resultant em um array de ints
	 * @param pString 	representa o cpf
	 * @return	um array de ints contendo 11 caracteres numericos.
	 */
	private int[] convertString2ArrayInt(String pString){
		
		String auxValor = pString.replaceAll("[^\\d]", "");
		auxValor = String.format("%1$11s",auxValor).replace(" ", "0");
		char[] charDigitos = auxValor.toCharArray();
		int[] intDigitos = new int[]{0,0,0,0,0,0,0,0,0,0,0};

		for(int i  = 0 ; i<11 ; i++){

			intDigitos[i] = charDigitos[i] - 48;		
		}
		return intDigitos;		
	}
	
	public String toString() {

		if(valor.equals("")){
			
			return valor;
		}
		
		if(digitos == null){
			digitos = convertString2ArrayInt(valor);
		}
		String wValor = "";
		for(int i  = 0 ; i < 11 ; i++){

			wValor = wValor + digitos[i];
			if(i == 2 || i == 5){
				wValor = wValor + ".";
			}
			if(i == 8){
				wValor = wValor + "-";
			}
		}
		return wValor;
	}

	public boolean isValid(){

		int primeiroDV = 0;
		int segundoDV = 0;

		System.out.println("Cpf.isValid()  " + valor.replaceAll("[^\\d]", ""));
		if(cpfsInvalidos.contains(valor.replaceAll("[^\\d]", ""))){

			return false;
		}		
		
		if(digitos == null){
			
			digitos = convertString2ArrayInt(valor);
		}
		
		int somaIni = 0;

		for(int i = 0; i<=8 ; i++){

			somaIni = somaIni + (digitos[i] * (10 - i));
		}
		int divisao = somaIni/11;
		int valor = divisao * 11;
		int resultado = somaIni - valor;

		if(resultado == 0 || resultado == 1){

			primeiroDV = 0;
		}else{

			primeiroDV = 11 - resultado	;
		}
		somaIni = 0;

		for(int i = 0; i<=8 ; i++){

			somaIni = somaIni + (digitos[i] * (11 - i));
		}
		somaIni = somaIni + (primeiroDV * 2);
		divisao = somaIni/11;
		valor = divisao * 11;
		resultado = somaIni - valor;

		if(resultado == 0 || resultado == 1){

			segundoDV= 0;
		}else{

			segundoDV = 11 - resultado	;
		}
		if((primeiroDV == digitos[9] )&& (segundoDV == digitos[10])){

			return true;
		}

		return false;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cpf other = (Cpf) obj;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	protected void finalize() throws Throwable {
		contadorCpf--;
	}

	public void init() {}

}
