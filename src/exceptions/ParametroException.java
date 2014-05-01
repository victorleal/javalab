package exceptions;

public class ParametroException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String parametro;
	
	public ParametroException(String parametro){
		this.parametro = parametro;
	}
	
	public String getMessage(){
		return "O campo  " + parametro + " não foi preenchido";
		
	}

}
