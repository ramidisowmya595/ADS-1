import java.util.Scanner;

class Pair
{
	public void noofpairs(int arr[])
	{
		int temp=0,count=0;
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					
				}
			}
		}
		int temp1=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]==temp1)
			{
				count++;
			}
			temp1=arr[i];
			 
		}
		System.out.println("total number of common pairs in an array "+count);
		
	}
}
class Solution
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
		Pair p=new Pair();
		p.noofpairs(a);
	}
}