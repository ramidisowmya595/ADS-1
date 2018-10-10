import java.util.Scanner;
/**
 * Class for deque.
 */
class Deque
{
    
    int elements;
    Node first,last;
    /**
     * Class for node.
     */
    class Node
    {
        String data;
         Node next;
        /**
         * Constructs the object.
         *
         * @param      val   The value
         * @param      link  The link
         */
        Node(String val,Node link)
        {
            this.data = val;
            this.next = link;
        }
    }
    /**
     * Constructs the object.
     */
    Deque()
    {
        elements = 0;
        first = null;
        last = null;
    }
    /**
     * Pushes element to left.
    
     */
    public void pushLeft(String value)
    {
        if(first==null) 
        {
            first=new Node(value,null);
            last=first;
        } 
        else
        {
            Node newnode=new Node(value,first);
             first=newnode;
        }

        elements++;
    }
    /**
     * Pushes element to right.
    
     */
    public void pushRight(String value) 
    {
        if (last==null)
        {
            last=new Node(value,null);
            
            first=last;
        } else {
            Node newnode=new Node(value, null);
            
            last.next=newnode;
            last=newnode;
        }
        elements++;
    }
    /**
     * popleft.
     */
    void popLeft() 
    {
        if(first!=null) 
        {
            Node popped=first;
            first=first.next;
            popped.data=null;
            popped.next=null;
            elements--;
        }
    }
    /**
     * popright.
     */
    void popRight()
    {
        if (last != null) 
        {
            Node temp=null;
            Node popped=last;
            Node element=first;
            while (element!=last)
            {
                temp=element;
                element=element.next;
            }
            last = temp;
            last.next=null;
            popped.data=null;
            popped.next=null;
            elements--;
        }
    }
    /**
     * size.
     *
     * @return     { description_of_the_return_value }
     */
    int size() 
    {
        return elements;
    }
    /**
     * checks if it is empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty()
    {
        return first==null;
    }
    /**
     * prints elements.
     *
     * @return     { description_of_the_return_value }
     */
    public String print() 
    {
        if (elements != 0) 
        {
            String str = "";
            Node temp = first;
            while (temp != null) 
            {
                str += temp.data + ", ";
                temp = temp.next;
            }
            return "[" + str.substring(0, str.length() - 2) + "]";
        }
        return "[]";

    }

}
/**
 * Class for solution.
 */
final class Solution {
    
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        Deque d=new Deque();
        for(int i=0;i<n;i++)
        {
            String input[] = sc.nextLine().split(" ");
            switch (input[0]) 
            {
            case "pushLeft":
                d.pushLeft(input[1]);
                System.out.println(d.print());
                break;
            case "pushRight":
                d.pushRight(input[1]);
                System.out.println(d.print());
                break;
            case "popLeft":
                if (!d.isEmpty()) 
                {
                    d.popLeft();
                    System.out.println(d.print());
                } 
                else 
                {
                    System.out.println("Deck is empty");
                }
                break;
            case "popRight":
                if (!d.isEmpty())
                {
                    d.popRight();
                    System.out.println(d.print());
                } 
                else
                {
                    System.out.println("Deck is empty");
                }
                break;
            case "size":
                System.out.println(d.size());
                break;
            case "isEmpty":
                System.out.println(d.isEmpty());
                break;
            default:
                break;

            }
        }
    }
}
