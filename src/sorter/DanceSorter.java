package sorter;

/**
 * This class rebuild the YouTube dance sorter
 * 
 * @author Stefano Kowalke 485366
 * @author Finn Kondering 399083  
 * @see http://www.youtube.com/watch?v=ywWBy6J5gz8
 */
public class DanceSorter implements ISorter
{
    /**
     * An array of the numbers to sort
     */
    private int[] numbers;
    
    /**
     * The length of the array
     */
    private int length;
    
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
        this.numbers = a;
        // Lenght of complete array
        length = a.length;
        dance(0, length - 1);
    }

    /**
     * Returns the name of the sort algoritm
     * 
     * @return A string with the name of the sort alorithm  
     */
    @Override
    public String getSorterName()
    {
        return "Quicksort YoutTube";
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
     * Sort the items in a set between lower and upper bound recursivly by the dance alorithm
     * @param lo The lower bound of the set to sort
     * @param hi The upper bound of the set to sort
     */
    private void dance(int lo, int hi)
    {
        int i = lo, j = hi;

        while (i <= j)
        {

            while (numbers[i] < numbers[j])
            {
                j--;
            }
            if (i <= j)
            {
                exchange(i, j);
                i++;
            }


            while (numbers[j] > numbers[i])
            {
                i++;
            }
            if (j >= i)
            {
                exchange(i, j);
                j--;
            }
        }

        // Rekursion
        if (lo < j)
        {
            dance(lo, j);
        }
        if (i < hi)
        {
            dance(i, hi);
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
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}    // end class QuickSorter
