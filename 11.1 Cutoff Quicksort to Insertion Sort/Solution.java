import java.util.Scanner;

class Quicksort
{

    public static void sort(final Comparable[] array, final int pi)
    {
        sort(array, 0,array.length - 1,pi);
        assert isSorted(array);
    }

    private static void sort(Comparable[] array,int low,int high,int pi) 
    {
        if(high <= low+pi-1) 
        {
            System.out.println("insertionSort called");
            insertionSort(array, low, high);
            return;
        }

        if (high <= low) 
        {
            return;
        }
        int j = partition(array, low, high);
        sort(array,low,j-1,pi);
        sort(array,j+1,high,pi);
        assert isSorted(array,low,high);
    }
   
    private static int partition(Comparable[] array,int low,int high) 
    {
        int i=low;
        int j=high + 1;
        Comparable v = array[low];
        while(true) 
        {

            
            while (less(array[++i],v))
            {
                if(i==high)
                {
                    break;
                }
            }

            // find item on hi to swap
            while (less(v,array[--j]))
            {
                if (j == low) 
                {

                    break;
                }
            }


            // check if pointers cross
            if (i >= j) 
            {
                break;
            }

            exch(array, i, j);
        }

        exch(array, low, j);
        show(array);
        System.out.println();

        return j;
    }

 
    public static Comparable select(Comparable[] array,int k) 
    {
        if (k < 0 || k >= array.length) 
        {
            throw new IllegalArgumentException("index is not between 0 and " + array.length + ": " + k);
        }
        // StdRandom.shuffle(a);
        int low=0,high=array.length-1;
        while (high > low) 
        {

            int i = partition(array, low, high);
            if (i > k) 
            {
                high = i - 1;
            } 
            else if (i < k) 
            {
                low = i + 1;
            }
            else
            {
                return array[i];
            }
        }
        return array[low];
    }

    static boolean less(final Comparable v, final Comparable w) {
        if (v == w)
        {
            return false;   // optimization when reference equals

        }
        return v.compareTo(w) < 0;
    }
    static void exch(final Object[] array, final int i, final int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static boolean isSorted(final Comparable[] array)
    {
        return isSorted(array, 0, array.length - 1);
    }
    
    static boolean isSorted(Comparable[] a, final int lo, final int hi) 
    {
        for (int i = lo+1;i<=hi;i++)
        {
            if (less(a[i], a[i-1])) 
            {
                return false;
            }
        }
        return true;
    }

    public  static void show(Comparable[] a) 
    {
        String str = "[";
        for (int i = 0; i < a.length; i++) 
        {
            str += a[i] + ", ";
        }
        System.out.print(str.substring(0, str.length() - 2) + "]");
    }
   
    public static void insertionSort(Comparable[] a,
                                     int lo,int hi) 
    {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) 
            {
                exch(a, j, j - 1);
                // show(a);
            }
        }
    }

}

class Solution
{
    
   
    public static void main(final String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int noOfTestcases = sc.nextInt();
        for (int i=0;i<noOfTestcases;i++)
        {
            int pivot = sc.nextInt();
            sc.nextLine();
            String input = sc.nextLine();
            Quicksort q = new Quicksort();
            String[] tokens = input.split(" ");
            q.sort(tokens, pivot);
            q.show(tokens);
            System.out.println();



        }
    }
}