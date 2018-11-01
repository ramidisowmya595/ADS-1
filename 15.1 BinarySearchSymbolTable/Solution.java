
import java.util.NoSuchElementException;
import java.util.Scanner;

class BST<Key extends Comparable<Key>, Value>
{
 private Node root = null;
 int n=0;
 int count=0;

 private class Node
 {
 private Key key;
 private Value val;
 private Node left;
 private Node right;
 private int size;
 public Node(Key key2, Value val2,int size)
 {
		
	 this.key=key2;
	 this.val=val2;
	 this.size=size;
	}
 }
 
 public boolean isEmpty()
 { 
 return root == null; 
 }
 
 public void put(Key key, Value value)
 { 
 root = put(root, key, value); 
 }
 private Node put(Node x, Key key, Value val)
 {
  if (x == null)
  {
	  n++;
	  return new Node(key, val,1);
  }
  
  int cmp = key.compareTo(x.key);
  if (cmp < 0) x.left = put(x.left, key, val);
  else if (cmp > 0) x.right = put(x.right, key, val);
  else x.val = val;
  return x;
 }
 public Value get(Key key)
 { 

 return get(root, key);
 }
 
 public boolean contains(Key key)
 { 
   return get(key) != null; 
 }
 private Value get(Node x, Key key)
 {
  if (x == null) 
	  return null;
  int cmp = key.compareTo(x.key);
  if (cmp < 0) 
	  return get(x.left, key);
  else if (cmp > 0) 
	  return get(x.right, key);
  else if (cmp == 0) 
	  return x.val;
return null;
 }
 public Iterable<Key> keys()
 { 
 Queue<Key> q = new Queue<Key>();
 inorder(root, q);
 return q;
 
 }
 private void inorder(Node x, Queue<Key> queue)
 {
  if (x == null) return;
  inorder(x.left, queue);
  queue.enqueue(x.key);
  inorder(x.right, queue);
 }
 
 
 public Key max() {
     if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
     return max(root).key;
 } 
 private Node max(Node x) {
     if (x.right == null) return x; 
     else                 return max(x.right); 
 }
 public Key floor(Key key)
 {
	 
	 Node temp=floor(root,key);
	 if(temp==null) {
		 return null;
	 }
	 return temp.key;
 }
 private Node floor(Node x,Key key)
 {
	 if(x==null)
		 return null;
	 if(key.compareTo(x.key)==0)
	 {
		 return x;
	 }
	 
	 if(key.compareTo(x.key)<0)
	 {
		
		 return floor(x.left,key);
	 }
      Node t=floor(x.right,key);
	 if(t!=null) {
		 return t;
	 }
	 else {
		 return x;
	 }
 }
 public int rank(Key key)
 {
	 return rank(key,root);
 }
 private int rank(Key key, Node x) {
     if (x == null) return 0; 
     int cmp = key.compareTo(x.key); 
     if      (cmp < 0) 
    	 return rank(key, x.left); 
     else if (cmp > 0) 
    	 return 1 + size(x.left) + rank(key, x.right); 
     else              
    	 return size(x.left); 
 } 
 public int size() {
     return size(root);
 }

 // return number of key-value pairs in BST rooted at x
 private int size(Node x) {
	
     if (x == null) {
    	 return 0;}
     
     else
    	 {
    	 System.out.println("size "+x.size);
    	 return x.size;
    	 }
 }

 public void deleteMin()
 {
	 root=deleteMin(root);
 }
 private Node deleteMin(Node x)
 {
	 if(x.left==null)
		 return x.right;
	 x.left=deleteMin(x.left);
	 return x;
 }
 
}

public class Solution {
	 public static void main(String[] args)
	 {
	 BST<String, Integer> st = new BST<String, Integer>();
	  
	  Scanner sc=new Scanner(System.in);
	  String s=sc.nextLine();
	  String[] k=s.split(" ");
	  for(int i=0;i<k.length;i++)
	  {
		  st.put(k[i],i);
	  }
	  while(sc.hasNext())
	  {
	  String kk=sc.nextLine();
	  
	  String[] c=kk.split(" ");
	  
	  switch (c[0])
	  {
	  case "max": 
		         System.out.println(st.max());
		         break;
	  case "floor":
		         System.out.println(st.floor(c[1]));
		         break;
	  case "rank":
		  int count=0;
		         Iterable<String> se=st.keys();
		         for(String s1:st.keys()) {
					   if(s1.compareTo(c[1])<0)
						   count++;
				   }
		         System.out.println(count);
		         break;
	  case "contains":	         
		         System.out.println(st.contains(c[1]));
		         break;
	  case "get":
		         System.out.println(st.get(c[1]));
		         break;
	  case "deleteMin":
		           st.deleteMin();
		         break;
	  case "keys":
		   Iterable<String> sk=st.keys();
		   for(String s1:st.keys()) {
			   System.out.println(s1+" "+st.get(s1));
		   }
		      break;
	  
	  
	  }
	  }
	  
	  
 
	 }


}
