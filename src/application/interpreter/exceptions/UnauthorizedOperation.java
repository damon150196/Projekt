package application.interpreter.exceptions;

@SuppressWarnings("serial")
public class UnauthorizedOperation extends Throwable {

	public UnauthorizedOperation() 
	{
		super();
	}
	public UnauthorizedOperation(String string) 
	{
		super(string);
	}
}
