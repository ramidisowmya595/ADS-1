import java.util.Scanner;
class Stack
{
	char st[];
	int top;
	Stack(int n)
	{
		st=new char[n];
		top=0;
	}
	public void push(char item)
	{
        st[top++] = item;
        
    }
	public char pop()
	{
        char popped= st[--top];
        
        return popped;
    }
	public boolean isEmpty()
	{
		return top==0;
	}
	boolean isFull()
	{
		return top==st.length;
	}
	public  char gettop() {
        return st[top - 1];
    }
	
}
public class Parenthesis
{
	public String balanced(String str)
	{
		Stack stk=new Stack(str.length()/2);
		for(char each : str.toCharArray()) 
		{
			if (each == '{' || each == '[' || each == '(')
			{
                stk.push(each);
            }
			else
			{
				if(!stk.isEmpty())
				{
					char top = stk.gettop();
					if((top=='(' && each == ')') || (top=='{'
		                     && each=='}') || (top=='[' && each==']')) 
					{
						 char poppeditem = stk.pop();
					}
					else
					{
						return "No";
					}
				}
				else
				{
					return "No";
				}
			}
		}
		if(stk.isEmpty())
		{
            return "YES";
        }
		return "No";
		
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Parenthesis p=new Parenthesis();
		System.out.println("enter number of inputs");
		int noOfInputs = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<noOfInputs;i++)
		{
			String input=sc.nextLine();
			System.out.println(p.balanced(input));
		}
		
		
	}

}
