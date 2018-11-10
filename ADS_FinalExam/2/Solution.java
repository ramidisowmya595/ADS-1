import java.util.Scanner;


class Student
{
	Integer rollno;
	String name;
	Double total;
	Student(Integer rollno,String name,Double total)
	{
		this.rollno=rollno;
		this.name=name;
		this.total=total;
	}
	String getName()
	{
		return this.name;
	}
	Double getTotal()
	{
		return this.total;
	}
	Integer getRollno()
	{
		return this.rollno;
	}
	int compareTo(Student current)
	{
		if(this.total.compareTo(current.total)>=0)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}

class BinarySearchTree
{
	class Node
	{
		Node left,right;
		Student key;
		String value;
		Node(Student key,String value)
		{
			this.key=key;
			this.value=value;
			
		}
	}
	Node root;
	BinarySearchTree()
	{
		root=null;
	}
	public void put(Student key,String value)
	{
		root=put(root,key,value);
	}
	public Node put(Node root,Student key,String value)
	{
		if(root==null)
		{
			return new Node(key,value);
		}
		int cmp=key.compareTo(root.key);
		if(cmp<0)
        {
            root.left=put(root.left,key,value);
        } 
        else 
        {
            root.right = put(root.right,key,value);
        }
        
		return root;
	}
	
	public void get(Node root,Double key1,Double key2)
	{
		if(root==null)
		{
			return;
		}
		 if(key1<root.key.getTotal()) 
		 { 
	            get(root.left, key1, key2); 
	     } 
		 if(key1<=root.key.getTotal() && key2>=root.key.getTotal())
		 { 
	            System.out.println(root.value); 
	     } 
	     if(key2>root.key.getTotal())
	     { 
	            get(root.right,key1,key2); 
	     } 
	}
	void between(Double key1,Double key2)
    {
    	get(root,key1,key2);
    }
	void lesser(Double k) 
    {
    	get(root,0.0,k);
    }	
	Double High(Node root) 
    { 
        if(root == null)
        {
            return 0.0; 
        }
        Double rootresult=root.key.getTotal(); 
        Double leftresult=High(root.left); 
        Double rightresult=High(root.right); 
  
        if(leftresult>rootresult)
        {
            rootresult=leftresult; 
        }
        if(rightresult>rootresult)
        {	
            rootresult = rightresult; 
        }
        return rootresult; 
    }
    void greater(Double key)
    {
    	get(root,key,High(root));
    }
}
class Solution
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		BinarySearchTree bst=new BinarySearchTree();
		for(int i=0;i<n;i++)
		{
			String elements1[]=sc.nextLine().split(",");
			bst.put(new Student(Integer.parseInt(elements1[0]),
		             elements1[1], Double.parseDouble(elements1[2])),elements1[1]);
		}
		int m=Integer.parseInt(sc.nextLine());
		for(int i=0;i<m;i++)
		{
			String elements2[]=sc.nextLine().split(" ");
			if(elements2[0].equals("BE")) 
            {
                bst.between(Double.parseDouble(elements2[1]),Double.parseDouble(elements2[2]));
            }
            else if(elements2[0].equals("LE"))
            {
                bst.lesser(Double.parseDouble(elements2[1]));
            }
            else 
            {
                bst.greater(Double.parseDouble(elements2[1]));
            }
			
		}
		
	}
}
