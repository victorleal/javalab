package exceptions;

public class Validadores {
	
	// Validador de CPF
	// Retirado de http://debugcodigos.blogspot.com.br/2012/05/validacao-de-cpf-em-java.html por Felipe Bonezi
	/**public static boolean validaCPF(String cpf) {  
	      boolean ret = false;  
	      String base = "000000000";  
	      String digitos = "00";  
	      if (cpf.length() <= 11) {  
	         if (cpf.length() < 11) {  
	            cpf = base.substring(0, 11 - cpf.length()) + cpf;  
	            base = cpf.substring(0, 9);  
	         }  
	         base = cpf.substring(0, 9);  
	         digitos = cpf.substring(9, 11);  
	         int soma = 0, mult = 11;  
	         int[] var = new int[11];  
	         // Recebe os números e realiza a multiplicação e soma.  
	         for (int i = 0; i < 9; i++) {  
	            var[i] = Integer.parseInt("" + cpf.charAt(i));  
	            if (i < 9)  
	               soma += (var[i] * --mult);  
	         }  
	         // Cria o primeiro dígito verificador.  
	         int resto = soma % 11;  
	         if (resto < 2) {  
	            var[9] = 0;  
	         } else {  
	            var[9] = 11 - resto;  
	         }  
	         // Reinicia os valores.  
	         soma = 0;  
	         mult = 11;  
	         // Realiza a multiplicação e soma do segundo dígito.  
	         for (int i = 0; i < 10; i++)  
	            soma += var[i] * mult--;  
	         // Cria o segundo dígito verificador.  
	         resto = soma % 11;  
	         if (resto < 2) {  
	            var[10] = 0;  
	         } else {  
	            var[10] = 11 - resto;  
	         }  
	         if ((digitos.substring(0, 1).equalsIgnoreCase(new Integer(var[9])  
	               .toString()))  
	               && (digitos.substring(1, 2).equalsIgnoreCase(new Integer(  
	                     var[10]).toString()))) {  
	            ret = true;  
	            System.out.println("sucesso validador");
	            System.out.println(cpf);
	         }  
	      }
	  
	      return ret;  
	   }**/
	
	
	public static boolean validaCPF(String strCpf){
	    int iDigito1Aux = 0, iDigito2Aux = 0, iDigitoCPF;
	    int iDigito1 = 0, iDigito2 = 0, iRestoDivisao = 0;
	    String strDigitoVerificador, strDigitoResultado;
	 
	    if (! strCpf.substring(0,1).equals("")){
	        try{
	            strCpf = strCpf.replace('.',' ');
	            strCpf = strCpf.replace('-',' ');
	            strCpf = strCpf.replaceAll(" ","");
	            for (int iCont = 1; iCont < strCpf.length() -1; iCont++) {
	                iDigitoCPF = Integer.valueOf(strCpf.substring(iCont -1, iCont)).intValue();
	                iDigito1Aux = iDigito1Aux + (11 - iCont) * iDigitoCPF;
	                iDigito2Aux = iDigito2Aux + (12 - iCont) * iDigitoCPF;
	            }
	            iRestoDivisao = (iDigito1Aux % 11);
	            if (iRestoDivisao < 2) {
	                iDigito1 = 0;
	            } else {
	                iDigito1 = 11 - iRestoDivisao;
	            }
	            iDigito2Aux += 2 * iDigito1;
	            iRestoDivisao = (iDigito2Aux % 11);
	            if (iRestoDivisao < 2) {
	                iDigito2 = 0;
	            } else {
	                iDigito2 = 11 - iRestoDivisao;
	            }
	            strDigitoVerificador = strCpf.substring(strCpf.length()-2, strCpf.length());
	            strDigitoResultado = String.valueOf(iDigito1) + String.valueOf(iDigito2);
	            return strDigitoVerificador.equals(strDigitoResultado);
	        } catch (Exception e) {
	            return false;
	        }
	    } else {
	        return false;
	    }
	}


}
