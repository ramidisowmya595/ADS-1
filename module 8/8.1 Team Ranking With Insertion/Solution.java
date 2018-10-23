import java.util.Scanner;

class Teams
{
	String name;
	int noofwins;
	int noofloses;
	int noofdraws;
	Teams(String name,int noofwins,int noofloses,int noofdraws)
	{
		this.name=name;
		this.noofwins=noofwins;
		this.noofloses=noofloses;
		this.noofdraws=noofdraws;
	}
	
}
class SelectionSort 
{ 
	int count=0;
    void sort(Teams a[]) 
    { 
    	int i=0;
        while(a[i]!=null)
        {
        	if(a[i]!=null)
        	{
        		count++;
        	}
        	i++;
        }
        for(i=0;i<count;i++) 
        { 
            // Find the minimum element in unsorted array 
            int min=i; 
            for(int j=i+1;j<count;j++)
            {
                if(a[j].noofwins > a[min].noofwins)
                {
                    min=j;
                }
                if(a[j].noofwins == a[min].noofwins)
                {
                	if(a[j].noofloses<a[min].noofloses) 
                	{
                        min=j; 
                	}
                }
                if((a[j].noofwins == a[min].noofwins)&&(a[j].noofloses == a[min].noofloses)) 
                {
                	if(a[j].noofdraws>a[min].noofdraws) 
                	{
                        min=j;
                	}
                }
            }
            Teams temp = a[min]; 
            a[min] = a[i]; 
            a[i] = temp; 
        } 
    } 
   
    void printArray(Teams a[]) 
    { 
        for (int i=0; i<count; i++) 
        	if(count==1)
            {
            	System.out.println(a[0].name);
            	break;
            }
        	else if((i+1)!=count)
	        {
            	System.out.print(a[i].name+","); 
	        }
	        else
	        {
	            System.out.print(a[i].name);
	        }
              System.out.println(); 
       
    } 
} 
class Solution 
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i=0;
		Teams k[]= new Teams[10];
		while(sc.hasNext())
		{
			String team = sc.nextLine();
			if(team!=null)
			{
				String[] token= team.split(",");
				String name= token[0];
				int wins= Integer.parseInt(token[1]);
		int loses= Integer.parseInt(token[2]);
		int draws= Integer.parseInt(token[3]);
		
		k[i]=new Teams(name,wins,loses,draws);
		i++;
		}
		}
		SelectionSort so =new SelectionSort();
		so.sort(k);
		so.printArray(k);
	}
}

