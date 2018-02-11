package Starter;

import java.util.HashMap;

/*
	Add methods to handle the traversal of other nodes in 
	the syntax tree. Some methods will need to be updated. 
	For instance, the interpret method for a Stmt assumes 
	that all statements are print statements. This is 
	obviously not the case and needs to be handled.
*/

public class Interpreter
{
        public static HashMap<String , Expression> map = new HashMap<>() ;
	//currently assumes all Stmt are PrintStmt
	//probably needs to be updated
 	public int interpret(Stmt stm)  
	{
            if(stm instanceof PrintStmt)
            {
               // System.out.println("Found Print Statement") ;
                return this.interpret((PrintStmt)stm);
            }
            else if(stm instanceof AssignStmt)
            {
                //System.out.println("Found Assign Statement") ;
                return this.interpret((AssignStmt)stm) ;
            }
            else if(stm instanceof Stmts)
            {
                //System.out.println("Found Multiple Statement") ;
                this.interpret(((Stmts) stm).stmt) ;
                return this.interpret(((Stmts) stm).stmtList) ;
            }
            return 0 ;
 	}
	
	public int interpret(Stmts stms)
	{
            if(stms instanceof Stmt)
            {
                this.interpret(stms.stmt) ;
                return this.interpret(stms.stmtList) ;
            }
            else if(stms instanceof Stmts)
            {
                this.interpret((Stmts)stms.stmt) ;
                return this.interpret(stms.stmtList) ;
            }
            return 0;
	}

	//each PrintStmt contains an ExpList
	//evaluate the ExpList
 	public int interpret(PrintStmt stm) 
	{
 		ExpList exp = stm.exps;
 	   	System.out.println(this.interpret(exp));
 	   	return 0;
 	}

 	public int interpret(Expression exp) 
	{
            if (exp instanceof NumExp)
            {
      		return this.interpret((NumExp)exp);
            }
            else if(exp instanceof IdExp)
            {
                return this.interpret((IdExp)exp) ;
            }
            else if(exp instanceof BinaryOpExp)
            {
                return this.interpret((BinaryOpExp)exp) ;
            }
            else if(exp instanceof UnaryOpExp){
                return this.interpret((UnaryOpExp) exp);
            }
            return 0;
 	}

 	public int interpret(NumExp exp) 
	{
    	return exp.num;
 	}

 	public int interpret(ExpList list) 
	{
            if(list instanceof LastExpList)
            {
                return this.interpret((LastExpList)list);
            }
            else
            {
                return this.interpret((LongExpList)list) ;
            }
 	}

 	public int interpret(LastExpList list) 
	{
    	return this.interpret(list.head);
  	}
        
        public int interpret(LongExpList list)
        {
            System.out.println(this.interpret(list.head)) ;
            return this.interpret(list.tail) ;
        }
        
        public int interpret(IdExp exp)
        {
            return this.interpret(map.get(exp.id)) ;
        }
        
        public int interpret(AssignStmt exp)
        {
            NumExp num;
            if(map.containsKey(exp.id)){
                num = new NumExp(this.interpret(exp.exp));
                map.put(exp.id, num);
            }
            else{
                map.put(exp.id , exp.exp) ;
            }
            return 0 ;
        }
        
        public int interpret(BinaryOpExp exp)
        {
            int left = this.interpret(exp.left) ;
            int right = this.interpret(exp.right) ;
            String operator = exp.operator ;
            if(operator.equals("+"))
            {
                return left + right ;
            }
            else if(operator.equals("-"))
            {
                return left - right ;
            }
            else if(operator.equals("*"))
            {
                return left * right ;
            }
            else if(operator.equals("/"))
            {
                return left / right ;
            }
            else if(operator.equals("%"))
            {
                return left % right ;
            }
            else
            {
                //If the operator is something that souldn't be there it just
                //returns a large "error" value.
                return Integer.MAX_VALUE ;
            }
        }
            
        public int interpret(UnaryOpExp exp)
        {
            //int expression = this.interpret(exp.exp) ;
            String operator = exp.operator ;
            if(operator.equals("<<"))
            {
                return this.interpret(exp.exp) << 1;
            }
            else if(operator.equals(">>"))
            {
                return this.interpret(exp.exp) >> 1 ;
            }
            else
            {
                //If the operator is something that souldn't be there it just
                //returns a large "error" value.
                return Integer.MAX_VALUE ;
            }
        }
}
