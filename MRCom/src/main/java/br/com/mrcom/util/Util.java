package br.com.mrcom.util;

public class Util {



	public static String  gerarCPF() {

		boolean  comPontos = false;

		int n = 9;
		int n1 = (int)(10 * Math.random());
		int n2 = (int)(10 * Math.random());
		int n3 = (int)(10 * Math.random());
		int n4 = (int)(10 * Math.random());
		int n5 = (int)(10 * Math.random());
		int n6 = (int)(10 * Math.random());
		int n7 = (int)(10 * Math.random());
		int n8 = (int)(10 * Math.random());
		int n9 = (int)(10 * Math.random());
		String cpf = "";

		int d1 = n9*2+n8*3+n7*4+n6*5+n5*6+n4*7+n3*8+n2*9+n1*10;
		d1 = 11 - ( d1%11 );
		if (d1>=10) d1 = 0;
		int d2 = d1*2+n9*3+n8*4+n7*5+n6*6+n5*7+n4*8+n3*9+n2*10+n1*11;
		d2 = 11 - ( d2%11 );
		if (d2>=10) d2 = 0;
		
		if (comPontos) 
			cpf = "" +n1+n2+n3+"."+n4+n5+n6+"."+n7+n8+n9+"-"+d1+d2;
		else
			cpf = ""+n1+n2+n3+n4+n5+n6+n7+n8+n9+d1+d2;

		return cpf;
	}

	public static void main(String[] args) {

////		Util util = new Util();
//
//		System.out.println("Util.main() " + Util.gerarCPF() );
//		
//		for (int i = 0 ; i < 20 ; i++){
//
//			Cpf cpf = new Cpf(Util.gerarCPF());
//			System.out.println("Cpf " + cpf  + " � valido : " +  cpf.isValid());
//		}
//		for (int i = 0 ; i < 20 ; i++)
//		System.out.println("Util.main()" + new SimpleDateFormat("dd/MM/yyyy").format( new Date((long)((new Long("924564567890")) * Math.random()))));
//		geraNomePessoa();
	}
	
	public static String removeCaracterNaoNumerico(Object paran){

		String ret = paran.toString().replaceAll("[^\\d]", "");
		return ret; 
	}
}
