package Starter;

public class ProgramOne
{
	//the syntax tree representation of:  one <-- 30 ; echo(one)
	//You should create separate programs for each tree you create.
  	private static Stmt programOne = new Stmts( new AssignStmt( "one" , new NumExp(30) ) , new Stmts( new PrintStmt( new LastExpList(new IdExp("one") ) ) ) ) ;

	public static void main(String[] args) 
	{
		//Create a new Interpreter Object
	    Interpreter interpreter = new Interpreter();
	    System.out.println("Evaluating...");
	    //Call the overloaded interpret method with the
	    //static program created above. Should print out 34.
	    interpreter.interpret(programOne);
	}
}
