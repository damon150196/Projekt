package application.interpreter.exceptions;

@SuppressWarnings("serial")
public class UnknownType extends Throwable {

	public UnknownType() 
	{
		super();
	}
	public UnknownType(String string) 
	{
		super(string);
	}
}
