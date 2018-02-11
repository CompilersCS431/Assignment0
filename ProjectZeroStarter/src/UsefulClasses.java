package Starter;

/*
	You will need to add many more classes to this file to get the interpreter 
	to work. The pattern shown below for the simple example should be enough 
	to show you what to do for the remaining classes.
*/

abstract class Stmt {}

//handles the Stmt --> echo ( ExpList ) production
class PrintStmt extends Stmt
{
    public ExpList exps;
    public PrintStmt(ExpList e)
	{
        exps = e;
    }
}

class Stmts extends Stmt
{
	public Stmt stmt ;
	public Stmts stmtList ;
	
	public Stmts (Stmt stmt1)
	{
		stmt = stmt1 ;
	}
	public Stmts (Stmt stmt1 , Stmts stmts2)
	{
		stmt = stmt1 ;
		stmtList = stmts2 ;
	}
}

//handles the Stmt --> id <-- Expression production
class AssignStmt extends Stmt
{
    public String id;
    public Expression exp;
    public AssignStmt(String i, Expression e)
    {
        id = i ;
        exp = e ;
    }
}

abstract class Expression {}

class NumExp extends Expression
{
    public int num;
    public NumExp(int n)
	{
        num = n;
    }
}

class IdExp extends Expression
{
    public String id ;
    public IdExp(String id)
    {
        this.id = id ;
    }
}
    
class BinaryOpExp extends Expression
{
    public Expression left ;
    public Expression right ;
    public String operator ;
    public BinaryOpExp(Expression left , String operator , Expression right)
    {
        this.left = left ;
        this.right = right ; 
        this.operator = operator ;
    }

}

class UnaryOpExp extends Expression
{
    public Expression exp;
    public String operator;
    public UnaryOpExp(Expression exp, String operator)
    
        this.exp = exp;
        this.operator = operator;
    }
}

abstract class ExpList {}

class LongExpList extends ExpList
{
    public Expression head ;
    public ExpList tail ;
    public LongExpList(Expression head , ExpList tail)
    {
        this.head = head ;
        this.tail = tail ;
    }
}

class LastExpList extends ExpList
{
    public Expression head;
    public LastExpList(Expression h)
    {
        head = h;
    }

}