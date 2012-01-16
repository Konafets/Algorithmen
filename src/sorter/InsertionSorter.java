package sorter;

/**
 * This class implements a insertion sorter
 * 
 * @author Stefano Kowalke 485366
 * @author Finn Kondering 399083
 */
public class InsertionSorter implements ISorter
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
        insertionsort();
    }

    /**
     * Returns the name of the sort algoritm
     * 
     * @return A string with the name of the sort alorithm  
     */
    @Override
    public String getSorterName()
    {
        return "Insertionsort";
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
     * Sort the set by the insertion sort alorithm iterativ
     */
    private void insertionsort()
    {
        int i, j, t;
        for (i = 1; i < n; i++)
        {
            j = i;
            t = a[c(j)];

            while ((j > 0) && (a[c(j - 1)] > t))
            {
                a[c(j)] = a[c(j - 1)];
                j--;
            }

            a[c(j)] = t;
        }
    }
}    // end class InsertionSorter
