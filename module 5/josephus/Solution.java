import java.util.Scanner;



class LinkedList
{
	int elements;
	Node first,last,temp;

	class Node
	{
		int data;
		Node next;
    
		Node(int val,Node link)
		{
			this.data=val;
			this.next=link;
		}
		
	}
	LinkedList()
    {
        elements = 0;
        first = null;
        last = null;
    }
	
	public void add(int val)
	{
   		if(first==null)
   		{
   			first=new Node(val, first);
   			first.next=first;
   			last=first;
   			temp=first;
   		}
   		else
   		{
   			Node newnode = new Node(val, null);
   			last.next=newnode;
   			newnode.next=first;
   			last=newnode;
   		}
   		elements++;
   	}
	public void print()
	{
   		Node temp=first;
   		while(temp.next != first)
   		{
   			System.out.println(temp.data);
   			temp = temp.next;
   		}
   	}
	public int remove(int pos)
	{
   		Node temp2=temp, prev= null;
   		// System.out.println(temp.next.data);
   		for(int i=0;i<pos-1;i++)
   		{
   			prev=temp2;
   			// System.out.println(temp.data + " "+ temp.next.data);
   			temp2=temp2.next;

   		}
   		prev.next=temp2.next;
   		//temp.next = temp.next.next;
   		temp=temp2.next;
   		elements--;
   		return temp2.data;

   	}
	public int size()
	{
		return elements;
	}
	
}
class Solution 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int noOfinputs=sc.nextInt();
		LinkedList obj=new LinkedList();
		for(int i=0;i<noOfinputs;i++)
		{
			sc.nextLine();
			int n=sc.nextInt();
			int m=sc.nextInt();
			for(int j=0;j<n;j++)
			{
				obj.add(j);
			}
			while(obj.size()!=0)
			{
				System.out.println(obj.remove(m));
			}

		}
	}
}
