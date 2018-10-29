import java.util.Scanner;
class MinHeap
{
	public boolean isHeap(Comparable a[])
    {
        for(int i=0;i<a.length;i++)
        {
            if(a.length>2*i+1&& a.length>2*i+2)
            {
                if(a[i].compareTo(a[2*i+1])>0 || a[i].compareTo(a[2*i+2])>0)
                {
                    return false;
                }
            }

        }
        return true;
		
	}
	
}
class Solution 
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int size;
		String datatype=sc.nextLine();
		int n=sc.nextInt();
		MinHeap mh=new MinHeap();
		sc.nextLine();
		for(int i=0;i<n;i++)
		{
			String line=sc.nextLine();
			if(line.length()==0)
			{
				System.out.println("false");
			}
			else
			{
				String input[]=line.split(",");
				switch(datatype)
				{
				case "String":size=0;
								String sheap[]=new String[input.length];
								for(int j=0;j<input.length;j++)
								{
									sheap[size++]=input[j];
								}
								System.out.println(mh.isHeap(sheap));
								break;
				case "Float":
								size=0;
								Float fheap[]=new Float[input.length];
								for(int j=0;j<input.length;j++)
								{
									fheap[size++]=Float.parseFloat(input[j]);
								}
								System.out.println(mh.isHeap(fheap));
								break;
				case "Double":
								size=0;
								Double dheap[]=new Double[input.length];
								for(int j=0;j<input.length;j++)
								{
									dheap[size++]=Double.parseDouble(input[j]);
								}
								System.out.println(mh.isHeap(dheap));
								break;
				case "Integer":
								size=0;
								Integer iheap[]=new Integer[input.length];
								for(int j=0;j<input.length;j++)
								{
									iheap[size++]=Integer.parseInt(input[j]);
								}
								System.out.println(mh.isHeap(iheap));
								break;
					
				}
				
			}
			
		}
		
	}
}
