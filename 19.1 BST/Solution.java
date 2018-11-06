
import java.util.NoSuchElementException;
import java.util.Scanner;



class Book
{
   
    String name;
    String author;
    Double price;
    Book(String n,String a,Double p)
    {
        this.name = n;
        this.author = a;
        this.price = p;
    }
    String getname() 
    {
        return this.name;
    }
     String getauthor() 
    {
        return this.author;
    }
    Double getprice()
    {
        return this.price;
    }
     int compareTo(Book current)
    {
    	 if(this.name.compareTo(current.name) > 0) 
    	 {
             return 1;
         } 
    	 else if(this.name.compareTo(current.name)<0)
    	 {
    		 return -1;
    	 }
    	 else
    	 {
    		 return 0;
    	 }
    }
     public String toString() {
    	    return this.getname() + ", " + this.getauthor() + ", " + this.getprice();
    	    }
}
class BinarySearchTree 
{
    Node root=null;
    class Node 
    {
       
        Book key;
        Integer value;
         Node left;
         Node right;
		//public int size;
		public int count;
        Node(Book key,Integer value,int size)
        {
        	this.key=key;
        	this.value=value;
        	this.count=size;
        }
        
    }
    public boolean isEmpty()
    { 
    return root == null; 
    }
    
    public void put(Book key, Integer value)
    { 
    root = put(root, key, value); 
    }
    private Node put(Node x, Book key, Integer val)
    {
     if (x == null) 
   	  return new Node(key, val,1);
     int cmp = key.compareTo(x.key);
     if (cmp < 0)
     {
    	 x.left = put(x.left, key, val);
     }
     else if (cmp > 0) 
     {
    	 x.right = put(x.right, key, val);
     }
     else
    { 
    	 x.value = val;
    	
    }
     x.count = 1 + size(x.left) + size(x.right);
     return x;
    }
    
    public Integer get(Book key)
    { 

    return get(root, key);
    }
    
   
    private Integer get(Node x, Book key)
    {
     if(x == null) 
   	  return null;
     int cmp = key.compareTo(x.key);
     if(cmp < 0) 
   	  return get(x.left, key);
     else if(cmp > 0) 
   	  return get(x.right, key);
     else if(cmp == 0) 
   	  return x.value;
   return null;
    }
    
    
    public Book min() 
    {     return min(root).key; 
    } 
    private Node min(Node x) 
    {   if (x.left == null)
   	 	return x;  
       return min(x.left); 
    } 
    
    public Book max() 
    {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return max(root).key;
    } 
    private Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    }
    
    
    public Book floor(Book key) 
    {
        if (key == null) 
        {
        	throw new IllegalArgumentException("argument to floor() is null");
        }
       
        Node x = floor(root, key);
        //System.out.println(x);

        if (x == null)
        {
        	return null;
        }
        else
        {
        	return x.key;
        }
    } 

    private Node floor(Node x, Book key) {
        if (x == null)
        {
        	return null;

        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) 
        {
        	return x;
        }
        if (cmp <  0)
        {
       	 return floor(x.left, key);
        }
       // System.out.println("Hi");
        Node t = floor(x.right, key); 
        if (t != null)
        {
        	return t;

        }
        else
        {
        	return x; 
        }
    } 
    
    public Book ceiling(final Book key) {
        if (key == null) {
            throw new IllegalArgumentException("argument is null");
        }
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    
    private Node ceiling(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }

    
    
    
    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    
    
    
    public int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.count;

        }
    }
    
    
    
    
    
    
  /*  public Book select(int k)
    {     return select(root, k).key;
    } */
    
    public Book select(int k) {
       if (k < 0 || k >= size()) {
            //throw new IllegalArgumentException("argument  is invalid: " + k);
        }
        Node x = select(root, k);
        return x.key;
    }
    
    private Node select(Node x,int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if      (t > k) {
            return select(x.left,  k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else  {
            return x;
        }
    }
    
    
   /* private Node select(Node x, int k) 
    {   // Return Node containing key of rank k.  
    	if (x == null) return null;  
    	int t = size(x.left); 
    	if      (t > k)
    		return select(x.left,  k); 
    	else if (t < k)
    		return select(x.right, k-t-1);   
    	else            return x; 
    	}*/
    
    
    

    
    
}
class Solution
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		BinarySearchTree bt=new BinarySearchTree();
		while(sc.hasNext())
		{
			String i=sc.nextLine();
			String input[]=i.split(",");
			//Book k;
			switch(input[0])
			{
			case "put":
				bt.put( new Book(input[1],input[2],Double.parseDouble(input[3])),Integer.parseInt(input[4]));
						break;
			
			case "get":
				System.out.println(bt.get(new Book(input[1],input[2],Double.parseDouble(input[3]))));
						break;
			case "min":
				Book b=bt.min();
				System.out.println(b.name+", "+b.author+", "+b.price);
				break;
			case "max":
				Book b1=bt.max();
				System.out.println(b1.name+", "+b1.author+", "+b1.price);
				break;
			case "floor":
						System.out.println(bt.floor(new Book(input[1],input[2],Double.parseDouble(input[3]))));
					break;
			
			case "select":Book b3=bt.select(Integer.parseInt(input[1]));
							System.out.println(b3.name+", "+b3.author+", "+b3.price);
							break;
			
			case "ceiling":
						System.out.println(bt.ceiling(new Book(input[1],input[2],Double.parseDouble(input[3]))));
							break;
			}
		}
		
	}

	
}
