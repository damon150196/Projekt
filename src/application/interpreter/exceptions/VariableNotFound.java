package application.interpreter.exceptions;

@SuppressWarnings("serial")
public class VariableNotFound extends Throwable {

	public VariableNotFound() 
	{
		super();
	}
	public VariableNotFound(String string) 
	{
		super(string);
	}
}
