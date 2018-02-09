package Starter;

public class ProgramTwo
{
	//the syntax tree representation of:  two <-- 20 - 10 * 5 ; three <-- two % 4 + 6 ; echo(two, three)
	//You should create separate programs for each tree you create.
  	//private static Stmt programTwo = new AssignStmt("two" , new BinaryOpExp(new BinaryOpExp( new NumExp(20) , "-" , new NumExp(10) ) , "*" , new NumExp(5) ) ) ;
        private static Stmt programTwo = new Stmts( new AssignStmt("two" , new BinaryOpExp(new BinaryOpExp( new NumExp(20) , "-" , new NumExp(10) ) , "*" , new NumExp(5) ) ) ,
                                                    new Stmts( new AssignStmt("three" , new BinaryOpExp( new BinaryOpExp( new IdExp("two") , "%" , new NumExp(4) ) , "+" , new NumExp(6) ) ) , 
                                                    new Stmts( new PrintStmt( new LongExpList(new IdExp("two") , new LastExpList(new IdExp("three") ) ) ) ) ) ) ;
        //public Stmt fish = new Stmts( new AssignStmt("three" , new BinaryOpExp( new BinaryOpExp( new IdExp("two") , "%" , new NumExp(4) ) , "+" , new NumExp(6) ) )
        //                            , new Stmts( new PrintStmt( new LongExpList(new IdExp("two") , new LastExpList(new IdExp("three") ) ) ) ) ) ;
	public static void main(String[] args) 
	{
		//Create a new Interpreter Object
	    Interpreter interpreter = new Interpreter();
	    System.out.println("Evaluating...");
	    //Call the overloaded interpret method with the
	    //static program created above. Should print out 34.
	    interpreter.interpret(programTwo);
	}
}