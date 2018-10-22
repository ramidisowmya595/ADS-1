import java.util.Scanner;

class Deque
{
	int elements;
	Node first,last;

	class Node
	{
		String data;
		Node next;
		Node(String val,Node link)
		{
            data = val;
            next = link;
        }
	}
	Deque()
	{
        elements=0;
        first=null;
        last=null;
    }
	void push(String value) 
	{
        if(first==null)
        {
            first=new Node(value, null);
            //first.data = value;
            //first.next = null;
            last=first;
        } 
        else
        {
            Node newnode=new Node(value, first);
            // newnode.data = value;
            // newnode.next = first;
            first=newnode;
        }

        elements++;
    }
	void enqueue(final String value) 
	{
        if(last==null) 
        {
            last=new Node(value,null);
            // last.data = value;
            // last.next = null;
            first=last;
        } 
        else 
        {
            Node newnode=new Node(value,null);
            // newnode.data = value;
            // newnode.next = null;
            last.next=newnode;
            last=newnode;
        }
        elements++;
    }
	public void pop()
	{
        if(first!=null) 
        {
            Node popped=first;
            first=first.next;
            popped.data=null;
            popped.next=null;
            elements--;
        }
        if(first==null)
        {
            last=null;
        }
    }
	public void setsize() 
	{
        elements=0;
    }
	public int size()
    {
        return elements;
    }
	public boolean isEmpty() 
    {
        return first==null;
    }
	public String print()
	{
        if(elements!=0)
        {
            String str="";
            Node temp=first;
            while(temp.next != null)
            {
                str=str+temp.data + ", ";
                temp=temp.next;
            }
            str=str+temp.data + ", ";
            return str.substring(0,str.length()-2);
        }
        return "Steque is empty.";

    }
}

public class Solution
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		 int n=sc.nextInt();
	        sc.nextLine();
	        for(int i=0;i<n;i++) 
	        {
	            Deque d = new Deque();
	            while(sc.hasNextLine()) 
	            {
	                String line = sc.nextLine();
	                //System.out.println(line);
	                if(line.equals("\n") || line.equals("") || line.equals(" ")) 
	                {
	                    break;
	                }
	                else 
	                {
	                    String input[] = line.split(" ");
	                    switch(input[0]) 
	                    {
	                    case "push":
	                        d.push(input[1]);
	                        System.out.println(d.print());
	                        break;
	                    case "enqueue":
	                        d.enqueue(input[1]);
	                        System.out.println(d.print());
	                        break;
	                    case "pop":
	                        if(!d.isEmpty()) 
	                        {
	                            d.pop();
	                            System.out.println(d.print());
	                        } 
	                        else 
	                        {
	                            System.out.println("Steque is empty.");
	                        }
	                        break;
	                    default:
	                        break;

	                    }
	                }

	            }
	            System.out.println();
	        }
	}
}
