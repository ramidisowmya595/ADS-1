

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
	public String getName()
	{
		return this.name;
	}
	public int getLoses()
	{
		return this.noofloses;
	}
	public int getWins()
	{
		return this.noofwins;
		
	}
	public int getDraws()
	{
		return this.noofdraws;
	}
	public int Compare(Teams current)
	{
		if(this.getWins()>current.getWins())
		{
			return 1;
		}
		else if(this.getWins()<current.getWins())
		{
			return -1;
		}
		else
		{
			if(this.getLoses()> current.getLoses())
			{
				return -1;
			}
			else if(this.getLoses()<current.getLoses())
			{
				return 1;
			}
			else
			{
				if(this.getDraws()>current.getDraws())
				{
					return 1;
				}
				else if(this.getDraws()<current.getDraws())
				{
					return -1;
				}
				else
				{
					return 0;
				}
			}
		}
	}
}
public class Solution 
{
	static Teams[] insertionsort(Teams[] list,int n) 
	{
        for(int  i=0;i<n;i++) 
        {
            for(int j=i;j>0;j--) 
            {
                if (list[j].Compare(list[j-1])>-1) 
                {
                    Teams temp = list[j-1];
                    list[j-1]=list[j];
                    list[j] = temp;
                }
            }

        }
        return list;
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Teams[] list = new Teams[2 * (2 + 2 + 1)];
        int k=0;
        while(sc.hasNextLine()) 
        {
            String[] tokens = sc.nextLine().split(",");
            list[k++] = new Teams(tokens[0], Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2]), Integer.parseInt(tokens[2 + 1]));
        }
        list=insertionsort(list,k);
        for(int i= 0;i<k-1;i++)
        {
            System.out.print(list[i].getName() + ",");
        }
        System.out.print(list[k-1].getName());
	}
}
