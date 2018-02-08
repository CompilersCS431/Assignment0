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
                return this.interpret((PrintStmt)stm);
            }
            else if(stm instanceof AssignStmt)
            {
                return this.interpret((AssignStmt)stm) ;
            }
            else if(stm instanceof Stmts)
            {
                this.interpret(((Stmts) stm).stmt) ;
                return this.interpret(((Stmts) stm).stmtList) ;
            }
            return 0 ;
 	}
	
	public int interpret(Stmts stms)
	{
            if(stms instanceof Stmt)
            {
                return this.interpret(stms.stmt) ;
            }
            else
            {
                return this.interpret(stms.stmtList) ;
            }
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
            return 0;
 	}

 	public int interpret(NumExp exp) 
	{
    	return exp.num;
 	}

 	public int interpret(ExpList list) 
	{
    	return this.interpret((LastExpList)list);
 	}

 	public int interpret(LastExpList list) 
	{
    	return this.interpret(list.head);
  	}
        
        public int interpret(IdExp exp)
        {
            return this.interpret(map.get(exp.id)) ;
        }
        
        public int interpret(AssignStmt exp)
        {
            map.put(exp.id , exp.exp) ;
            return 0 ;
        }
}
