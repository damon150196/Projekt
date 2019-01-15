package application.interpreter.exceptions;

@SuppressWarnings("serial")
public class NotParsed extends Throwable {

	public NotParsed() 
	{
		super();
	}
	public NotParsed(String string) 
	{
		super(string);
	}
}
