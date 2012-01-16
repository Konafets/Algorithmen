package sorter;

/**
 * This class implements a iterativ quick sorter
 * 
 * @author Stefano Kowalke 485366
 * @author Finn Kondering 399083
 */
public class QuickSorterIterativ implements ISorter
{
    /**
     * An array of the numbers to sort
     */
    private int[] a;

    /**
     * The length of the array
     */
    private int n;
    
    /**
     * Holds the local number of array accesses
     */
    private long arrayAccessCounter;

    /**
     * Sort the given array ascending.
     * 
     * @param a An array of the items to sort
     */
    @Override
    public void sort(int[] a)
    {
        arrayAccessCounter = 0;
        this.a = a;
        n = a.length;
        quicksortIterativ(0, n - 1);
    }

    /**
     * Returns the name of the sort algoritm
     * 
     * @return A string with the name of the sort alorithm  
     */
    @Override
    public String getSorterName()
    {
        return "Quicksort Iterativ";
    }

    /**
     * Returns the amount of array accesses
     * 
     * @return Returns a amount of array accesses
     */
    @Override
    public long getArrayAccessCounter()
    {
        return arrayAccessCounter;
    }

    /**
     * Counts every array access
     * Here we passing the current index of the array through the method 
     * and count just the call to this method. This number is equal to the array
     * accesses of the particular array.
     * 
     * @param k The current index of the array
     * @return The current index of the array
     */
    private int c(int k)
    {
        arrayAccessCounter++;
        return k;
    }

    /**
     * Sort the items in a set between lower and upper bound by the quick sort alorithm
     * Sort the greater half of the set iterativly and the smaller half recursivly
     * 
     * @param lo The lower bound of the set to sort
     * @param hi The upper bound of the set to sort
     */
    private void quicksortIterativ(int lo, int hi)
    {
        int m, x;

        while (lo < hi)
        {
            
            
            // Compare element x
            m = (lo + hi) / 2;
            x = a[c(m)];
            
            int i = lo;
            int j = hi;
            
            // Split
            while( i <= j)
            {
                while (a[c(i)] < x) 
                {
                    i++;
                }
                
                while (a[c(j)] > x) 
                {
                    j--;
                }
                
                if (i <= j)
                {
                    exchange(i, j);
                    i++; 
                    j--;        
                }
            }
            
            // Recursion
            if (j < m)
            {
                quicksortIterativ(lo, j);
                lo = i;
            }
            else 
            {
                quicksortIterativ(i, hi);
                hi = j;
            }
                
        }
    }

    /**
     * Change the given parameters
     * 
     * @param i First particular value to change
     * @param j Second particular value to change
     */
    private void exchange(int i, int j)
    {
        int t = a[c(i)];
        a[c(i)] = a[c(j)];
        a[c(j)] = t;
    }
}
