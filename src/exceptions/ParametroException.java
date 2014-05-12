package exceptions;

public class ParametroException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ParametroException(String parametro){
		super("O campo " + parametro + " não foi preenchido ou seu valor é inválido");
	}

}
