package Starter;

public class ProgramThree
{
	//the syntax tree representation of:  two <-- 20 - 10 * 5 ; three <-- two % 4 + 6 ; echo(two, three)
	//You should create separate programs for each tree you create.
        private static Stmt programThree = new Stmts( new AssignStmt("four" , new BinaryOpExp( new NumExp(5) , "+" , new NumExp(10) )),
                                                    new Stmts( new AssignStmt("five" , new BinaryOpExp( new NumExp(10) , "/" , new NumExp(3) )) , 
                                                    new Stmts( new PrintStmt( new LongExpList(new IdExp("four") , new LastExpList(new IdExp("five") ) ) ), 
                                                    new Stmts(new AssignStmt("four", new UnaryOpExp(new IdExp("four"), ">>")),
                                                    new Stmts (new PrintStmt(new LastExpList(new IdExp("four"))),
                                                    new Stmts(new AssignStmt("five", new BinaryOpExp(new UnaryOpExp(new IdExp("four"), "<<"), "/", new UnaryOpExp(new IdExp("four"), ">>"))),
                                                    new Stmts(new PrintStmt(new LongExpList(new IdExp("four"), new LastExpList(new IdExp("five")))))))))));
	public static void main(String[] args) 
	{
		//Create a new Interpreter Object
	    Interpreter interpreter = new Interpreter();
	    System.out.println("Evaluating...");
	    //Call the overloaded interpret method with the
	    //static program created above. Should print out 34.
	    interpreter.interpret(programThree);
	}
}