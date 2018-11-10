import java.util.HashMap;
import java.util.Scanner;

class Student
{
	int rollno;
	String name;
	double totalmarks;
	
	Student(String name,double totalmarks)
	{
		
		this.name=name;
		this.totalmarks=totalmarks;
	}
	public Double getTotal()
	{
		return this.totalmarks;
	}
	public String getName()
	{
		return this.name;
	}
	
}



public class Solution 
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n1=Integer.parseInt(sc.nextLine());
		HashMap<Integer,Student> h=new HashMap<Integer,Student>(n1);
		//sc.nextLine();
		for(int i=0;i<n1;i++)
		{
			String elements1[]=sc.nextLine().split(",");
			h.put(Integer.parseInt(elements1[0]),
					new Student(elements1[1],Double.parseDouble(elements1[2])));
		}
		int n2=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n2;i++)
		{
			String elements2[]=sc.nextLine().split(" ");
			Student details=h.get(Integer.parseInt(elements2[1]));
			if(details == null)
			{
				System.out.println("Student doesn't exists...");
			}
			else
			{
				if(elements2[2].equals("1"))
				{
					System.out.println(details.getName());
				}
				else
				{
					System.out.println(details.getTotal());
				}
			}
		}
			
	}

}
