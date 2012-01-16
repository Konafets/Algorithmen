package sorter;

/**
 * This class implements a heap sorter
 * 
 * @author Stefano Kowalke 485366
 * @author Finn Kondering 399083  
 */
public class HeapSorter implements ISorter
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
        heapsort();
    }

    /**
     * Returns the name of the sort algoritm
     * 
     * @return A string with the name of the sort alorithm  
     */
    @Override
    public String getSorterName()
    {
        return "Heapsort";
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
     * Sort the items in a set between lower and upper bound recursivly by the heapsort alorithm
     * - First it builds the heap
     * - As long as items in the array
     *   - Decrement n
     *   - put last item to first place
     *   - 
     * 
     */
    private void heapsort()
    {
        buildheap();
        while (n > 1)
        {
            n--;
            exchange(0, n);
            downheap(0);
        }
    }

    /**
     * 
     */
    private void buildheap()
    {
        for (int v = n / 2 - 1; v >= 0; v--)
        {
            downheap(v);
        }
    }

    private void downheap(int v)
    {
            // first successor of v
        int w = 2 * v + 1;
        while (w < n)
        {
                // is there second successor?
            if (w + 1 < n)       
            {
                if (a[c(w + 1)] > a[c(w)])
                {
                    w++;
                }
            }
            // w is the successor of v with the maximum flag

            if (a[c(v)] >= a[c(w)])
            {
                    // v has the heap property
                return; 
            }

                // else change flags of v and w
            exchange(v, w);  
                // move on with v = w
            v = w;             
            w = 2 * v + 1;
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
