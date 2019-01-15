package application.interpreter.exceptions;

@SuppressWarnings("serial")
public class UnknownOperator extends Throwable {

	public UnknownOperator() 
	{
		super();
	}
	public UnknownOperator(String string) 
	{
		super(string);
	}
}
