package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import application.blocks.*;

public class FileToBlocks 
{
	private File file;
	private ArrayList<Block> ListBlocks = new ArrayList<Block>();
	private ArrayList<String> variables = new ArrayList<String>();
	private Scanner in;
	
	private Block b;
	
	FileToBlocks(File f, Block m, ArrayList<String> v) throws FileNotFoundException
	{
		file = f;
		variables = v;
		ListBlocks.add(m);
		in = new Scanner(file);
	}
	
	public void start() throws FileToBlocksException
	{
		String s = "";
		String old_s = "";
		
		while(in.hasNextLine())
		{
			old_s = s;
			/*
			System.out.println(s);
			
			for(Block tmp : ListBlocks)
			{
				System.out.print(tmp.getName() + " -> ");
			}
			*/
			s = in.nextLine();
			s = s.replaceAll("\t", "");
			
			if(s.matches("Main().+") || s.matches("^[\n]$") );
			else if(s.contains("{")) ftb_openCurlyBracket(old_s);
			else if(s.contains("}")) ftb_closeCurlyBracket();
			else if(s.matches("int.+") || s.matches("double.+") || s.matches("String.+") || s.matches("boolean.+")) ftb_variable(s);
			
			else if(s.matches("write.+")) ftb_write(s);
			else if(s.matches("read.+")) ftb_read(s);

			else if(s.matches("if.+")) ftb_if(s);
			else if(s.matches("else.*")) ftb_else(s);
			else if(s.matches("skip;.*")) ;

			else if(s.matches("while.+")) ftb_while(s);
			/*
			else if(s.matches("for.+")) ftb_for(s);

			else if(s.matches("switch.+")) ftb_switch(s);
			else if(s.matches("case.+")) ftb_case(s);
			else if(s.matches("default.+")) ftb_default(s);
			else if(s.matches("break.+")) ftb_break();
			*/
			else ftb_operation(s);
		}
		
		
		if(! ListBlocks.isEmpty())
		{
			//((MainBlock) ListBlocks.get(0)).clear();
			System.out.println(ListBlocks.get(0).getName());
			throw new FileToBlocksException(ListBlocks.size() + " Nieoczekiwany koniec pliku");
		}
	}

	
	private void ftb_openCurlyBracket(String s) throws FileToBlocksException
	{
		if(s.matches("Main.+") || s.matches("if.+")  || s.matches("else*") || s.matches("while.+") || s.matches("for.*") || s.matches("switch.*"));
		else
		{
			throw new FileToBlocksException("Nieoczekiwany znak \"{\"");
		}
		
	}
	private void ftb_closeCurlyBracket() throws FileToBlocksException
	{

		if (ListBlocks.get(ListBlocks.size()-1) instanceof IfBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		
		if(! ListBlocks.isEmpty())
		{
			ListBlocks.remove(ListBlocks.size()-1);
		}
		else
		{
			throw new FileToBlocksException("Nieoczekiwany znak \"}\"");
		}
	}
	
	private void ftb_variable(String s)
	{
		if (ListBlocks.get(ListBlocks.size()-1) instanceof IfBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		if (ListBlocks.get(ListBlocks.size()-1) instanceof ForBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		if (ListBlocks.get(ListBlocks.size()-1) instanceof SwitchBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		
		
		String block = "";
		if(s.matches("int.+")) block = "Int";
		else if(s.matches("double.+")) block = "Double";
		else if(s.matches("String.+")) block = "String";
		else if(s.matches("boolean.+")) block = "Boolean";
		
		
		s = s.replaceAll("int ", "");
		s = s.replaceAll("double ", "");
		s = s.replaceAll("String ", "");
		s = s.replaceAll("boolean ", "");
		s = s.replaceAll("\'", "");
		s = s.replaceAll(";", "");

		String [] s2 = s.split(" = ");

		b = ListBlocks.get(ListBlocks.size()-1).addBlock(block);
		b.setVariables(variables);
		b.setTname(s2[0]);
		if(s2.length==2) b.setTvalue(s2[1]);
	}
	
	private void ftb_write(String s)
	{
		if (ListBlocks.get(ListBlocks.size()-1) instanceof IfBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		if (ListBlocks.get(ListBlocks.size()-1) instanceof ForBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		if (ListBlocks.get(ListBlocks.size()-1) instanceof SwitchBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		
		
		s = s.replaceAll("write ", "");
		s = s.replaceAll(";", "");

		b = ListBlocks.get(ListBlocks.size()-1).addBlock("Write");
		b.setVariables(variables);
		b.setTvalue(s.replaceAll("\"", ""));
	}
	private void ftb_read(String s)
	{
		if (ListBlocks.get(ListBlocks.size()-1) instanceof IfBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		if (ListBlocks.get(ListBlocks.size()-1) instanceof ForBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		if (ListBlocks.get(ListBlocks.size()-1) instanceof SwitchBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		
		
		s = s.replaceAll("read ", "");
		s = s.replaceAll(";", "");

		b = ListBlocks.get(ListBlocks.size()-1).addBlock("Read");
		b.setVariables(variables);
		b.setTname(s);
	}

	private void ftb_if(String s)
	{
		if (ListBlocks.get(ListBlocks.size()-1) instanceof IfBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		if (ListBlocks.get(ListBlocks.size()-1) instanceof ForBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		if (ListBlocks.get(ListBlocks.size()-1) instanceof SwitchBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		
		s = s.replace("if( ", "");
		s = s.substring(0, s.length()-2);

		b = ListBlocks.get(ListBlocks.size()-1).addBlock("If");
		b.setVariables(variables);

		Block b0 = (Block) b.getVb().getChildren().get(0);
		Block b1 = (Block) b.getVb().getChildren().get(1);

		ListBlocks.add(b);
		ListBlocks.add(b0);

		if(s.matches("[(].*[)]") || s.charAt(0) == '!')  ftb_logic(s,0);
		else ftb_condition(s, 0);
		
		
		ListBlocks.remove(b0);
		
		ListBlocks.add(b1);
	}

	private void ftb_else(String s) throws FileToBlocksException
	{
		if (ListBlocks.get(ListBlocks.size()-1) instanceof IfBlock)
		{
			b = ListBlocks.get(ListBlocks.size()-1).addElseBlock("Else");
			b.setVariables(variables);

			ListBlocks.add(b);
		}
		else
		{
			throw new FileToBlocksException("Nie by³o funkcji if");
		}
	}
	

	

	private void ftb_while(String s)
	{
		if (ListBlocks.get(ListBlocks.size()-1) instanceof IfBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		if (ListBlocks.get(ListBlocks.size()-1) instanceof ForBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		if (ListBlocks.get(ListBlocks.size()-1) instanceof SwitchBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		
		s = s.replace("while( ", "");
		s = s.substring(0, s.length()-2);

		b = ListBlocks.get(ListBlocks.size()-1).addBlock("While");
		b.setVariables(variables);

		Block b0 = (Block) b.getVb().getChildren().get(0);
		Block b1 = (Block) b.getVb().getChildren().get(1);

		ListBlocks.add(b0);

		if(s.matches("[(].*[)]") || s.charAt(0) == '!')  ftb_logic(s,0);
		else ftb_condition(s, 0);
		
		
		ListBlocks.remove(b0);
		
		ListBlocks.add(b1);
	}

	@SuppressWarnings("unused")
	private void ftb_for(String s)
	{
		if (ListBlocks.get(ListBlocks.size()-1) instanceof IfBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		if (ListBlocks.get(ListBlocks.size()-1) instanceof ForBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		if (ListBlocks.get(ListBlocks.size()-1) instanceof SwitchBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		
		s = s.replace("for(", "");
		s = s.substring(0, s.length()-1);
		
		b = ListBlocks.get(ListBlocks.size()-1).addBlock("For");
		b.setVariables(variables);
		
		String[] s2 = s.split(";");
		
		Block b0 = (Block) b.getVb().getChildren().get(0);			
		Block b1 = (Block) b.getVb().getChildren().get(1);			
		Block b2 = (Block) b.getVb().getChildren().get(2);	
		Block b3 = (Block) b.getVb().getChildren().get(3);		
		
		// init
		s2[0] = s2[0].replaceAll("int ", "");
		s2[0] = s2[0].replaceAll(";", "");
		String [] s3 = s2[0].split(" = ");
		if(! s3[0].equals("")) b0.setTname(s3[0]);
		if(! s3[1].equals("")) b0.setTvalue(s3[1]);

		//warunek
		ListBlocks.add(b1);
		if(s2[1].matches("[(].*[)]") || s2[1].charAt(0) == '!')  ftb_logic(s,0);
		else ftb_condition(s2[1], 0);
		ListBlocks.remove(b1);

		//++
		if(! s2[2].equals("")) b2.setTvalue(s2[2]);
		
		//wykonywanie pêtli
		ListBlocks.add(b3);
	}
	
	private void ftb_condition(String s, int pos)
	{
		String block = "";
		if(s.contains("=")) block = "=";
		//else if(s.contains("!=")) block = "!=";
		//else if(s.contains("<=")) block = "<=";
		//else if(s.contains(">=")) block = ">=";
		else if(s.contains("<")) block = "<";
		else if(s.contains(">")) block = ">";
		
		String [] s2 = s.split(block);

		b = ListBlocks.get(ListBlocks.size()-1).addConditionBlock(block, pos);
		b.setVariables(variables);
		b.setTleft(s2[0]);
		if(s2.length==2) b.setTright(s2[1]);
	}
	

	
	private void ftb_logic(String s, int pos)
	{
		String block = "";
		if(s.charAt(0) == '!') block = "! ";
		else if(s.matches("^[(].*[)] [|] [(].*[)]$")) block = " [|] ";
		else if(s.matches("^[(].*[)] & [(].*[)]$")) block = " & ";
		

		String [] s2 = s.split(block);

		if(s2[0] != "" /*&& block != "! "*/) s2[0] = s2[0].substring(1, s2[0].length()-1);
		if(s2[1] != "" ) s2[1] = s2[1].substring(1, s2[1].length()-1);

		block = block.replaceAll(" ", "");
		block = block.replaceAll("\\[", "");
		block = block.replaceAll("\\]", "");
		b = ListBlocks.get(ListBlocks.size()-1).addLogicBlock(block, pos);
		b.setVariables(variables);

		ListBlocks.add(b);
		
		if(block.equals("!"))
		{
			if(s2[1].matches("[(].*[)]") /*|| s2[1].charAt(0) == '!'*/)  ftb_logic(s2[1], 1);
			else ftb_condition(s2[1], 1);
		}
		else
		{
			System.out.println(s2[0] + "|" + s2[1]);
			
			if(s2[0].matches("[(].*[)]")/* || s2[0].charAt(0) == '!'*/)  ftb_logic(s2[0],0);
			else ftb_condition(s2[0], 0);

			if(s2[1].matches("[(].*[)]")/* || s2[1].charAt(0) == '!'*/)  ftb_logic(s2[1],2);
			else ftb_condition(s2[1], 2);
			
		}

		ListBlocks.remove(ListBlocks.size()-1);
		
	}
	
	
	
	

	@SuppressWarnings("unused")
	private void ftb_switch(String s)
	{
		if (ListBlocks.get(ListBlocks.size()-1) instanceof IfBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		if (ListBlocks.get(ListBlocks.size()-1) instanceof ForBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		if (ListBlocks.get(ListBlocks.size()-1) instanceof SwitchBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		
		b = ListBlocks.get(ListBlocks.size()-1).addBlock("Switch");
		b.setVariables(variables);

		s = s.replace("switch(", "");
		s = s.replace(")", "");
		b.setTnameNoCheck(s);
		
		ListBlocks.add(b);

		
		
	}
	
	

	@SuppressWarnings("unused")
	private void ftb_case(String s) throws FileToBlocksException
	{
		if (ListBlocks.get(ListBlocks.size()-1) instanceof SwitchBlock)
		{
			b = ListBlocks.get(ListBlocks.size()-1).addBlock("Case");
			b.setVariables(variables);

			s = s.replace("case ", "");
			s = s.replace(":", "");
			b.setTvalue(s);
			
			ListBlocks.add(b);
		}
		else
		{
			throw new FileToBlocksException("Nie by³o funkcji switch");
		}
	}
	

	@SuppressWarnings("unused")
	private void ftb_default(String s) throws FileToBlocksException
	{
		if (ListBlocks.get(ListBlocks.size()-1) instanceof SwitchBlock)
		{
			b = ListBlocks.get(ListBlocks.size()-1).addBlock("Default");
			b.setVariables(variables);

			ListBlocks.add(b);
		}
		else
		{
			throw new FileToBlocksException("Nie by³o funkcji switch");
		}
	}
	@SuppressWarnings("unused")
	private void ftb_break() throws FileToBlocksException
	{
		if (ListBlocks.get(ListBlocks.size()-1) instanceof IfBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		else if (ListBlocks.get(ListBlocks.size()-1) instanceof ForBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		else if (ListBlocks.get(ListBlocks.size()-1) instanceof SwitchBlock)
			ListBlocks.remove(ListBlocks.size()-1);
		
		if(! ListBlocks.isEmpty())
		{
			ListBlocks.remove(ListBlocks.size()-1);
		}
		else
		{
			throw new FileToBlocksException("Nieoczekiwany break;");
		}
	}
	
	
	
	
	
	
	private void ftb_operation(String s)
	{
		if (ListBlocks.get(ListBlocks.size()-1) instanceof IfBlock)
		{
			ListBlocks.remove(ListBlocks.size()-1);
		}
		s = s.replaceAll(";", "");
		if(! s.equals(""))
		{
			b = ListBlocks.get(ListBlocks.size()-1).addBlock("Wykonaj");
			b.setVariables(variables);
			b.setTvalue(s);
		}
	}
	
	
	///
	
	
	
}
