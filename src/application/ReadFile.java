package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile 
{
	private static String str;
	private static StringBuffer strB = new StringBuffer();
	
	public static void main(String [] args)
	{
		readFile();
		displayFile();
	}
	
	public static void readFile()
	{
		File file = new File("DATA.txt");
		
		try 
		{
			@SuppressWarnings("resource")
			Scanner in = new Scanner(file);
		
			while(in.hasNextLine())
			{
				str = in.nextLine();
				strB.append(str + "\n");
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("File not found!");
		}
		
	}
	
	public static void displayFile()
	{
		System.out.println(getStrFromFile());
	}
	
	public static String getStrFromFile()
	{
		return strB.toString();
	}
}
