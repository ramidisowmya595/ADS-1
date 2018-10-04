import java.util.Scanner;

public class BinarySearch 
{
	public static void main(String args[])
	{
		int a[];
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number of elements to insert in an array");
		int n=sc.nextInt();
		a=new int[n];
		System.out.println("enter  elements of an  array");
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		System.out.println("enter key  element of an  array");
		int key=sc.nextInt();
		int first=0;
		int last=a.length-1;
		int mid;
		while(first<=last)
		{
			 mid=(first+last)/2;
			if (key==a[mid] &&(!(key==a[mid - 1])))
			{	
					System.out.println("element is "+mid);
					break;
			}
			else if (key>a[mid])
			{
				first= mid + 1;
			}
		    else
		    {
	               last = mid- 1;

		    }
		}
	}
}
