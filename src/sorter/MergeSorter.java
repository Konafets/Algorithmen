package sorter;

/**
 * This class implements a merge sorter
 * 
 * @author Stefano Kowalke 485366
 * @author Finn Kondering 399083
 */
public class MergeSorter implements ISorter
{
    /**
     * An array of the numbers to sort
     */
    private int[] a;

    /**
     * A help array 
     */
    private int[] b;

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
        // je nach Variante entweder/oder:
        // Hilfarray für die effizientere Variante dimensionieren
        b = new int[(n + 1) / 2];
        //b = new int[n];
        mergesort(0, n - 1);
    }

    /**
     * Returns the name of the sort algoritm
     * 
     * @return A string with the name of the sort alorithm  
     */
    @Override
    public String getSorterName()
    {
        return "Mergesort";
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
     * Sort the items in a set between lower and upper bound recursivly by the merge sort alorithm
     * 
     * @param lo The lower bound of the set to sort
     * @param hi The upper bound of the set to sort
     */
    private void mergesort(int lo, int hi)
    {
        if (lo < hi)
        {
            int m = (lo + hi) / 2;
            mergesort(lo, m);
            mergesort(m + 1, hi);
            merge(lo, m, hi);
        }
    }

    /**
     * Sort the items in a set between lower and upper bound recursivly by the merge sort alorithm
     * This is the efficently variant of the algorithm
     * 
     * @param lo The lower bound of the set to sort
     * @param m  The middle item in the set to sort
     * @param hi The upper bound of the set to sort
     */
    private void merge(int lo, int m, int hi)
    {
        int i, j, k;

        i = 0;
        j = lo;
        // vordere Hälfte von a in Hilfsarray b kopieren
        while (j <= m)
        {
            b[c(i++)] = a[c(j++)];
        }

        i = 0;
        k = lo;

        // jeweils das nächstgrößte Element zurückkopieren
        while (k < j && j <= hi)
        {
            if (b[c(i)] <= a[c(j)])
            {
                a[c(k++)] = b[c(i++)];
            } else
            {
                a[c(k++)] = a[c(j++)];
            }
        }

        // Rest von b falls vorhanden zurückkopieren
        while (k < j)
        {
            a[c(k++)] = b[c(i++)];
        }
    }
}    // end class MergeSorter
