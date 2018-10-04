import java.util.Scanner;

class Check
{
	public void combine(int a[],int a1[])
	{
		int i=0,j=0;
		
		while(i<a.length && j<a1.length)
		{
			
			if(a[i]<a1[j])
			{
		          System.out.print(a[i++]); 
			}
			else if(a1[j]<a[i]) 
			{
		          System.out.print(a1[j++]);
			}
		        else
		        { 
		          System.out.print(a1[j++]); 
		          i++; 
		        } 
		}
		while(i<a.length)
		{
		       System.out.print(a[i++]); 
		}
		while(j < a1.length) 
		{
		       System.out.print(a1[j++]); 
		}
	}
}

public class Sort1 
{
	public static void main(String args[])
	{
		int a[],a1[];
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number of elements to insert in first array");
		int n=sc.nextInt();
		a=new int[n];
		System.out.println("enter number of elements to insert in second array");
		int n1=sc.nextInt();
		a1=new int[n1];
		System.out.println("enter  elements of first  array");
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		System.out.println("enter  elements of second  array");
		for(int i=0;i<n;i++)
		{
			a1[i] = sc.nextInt();
		}
		Check c=new Check();
		c.combine(a, a1);
	}
}
