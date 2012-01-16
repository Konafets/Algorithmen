package sorter;

/**
 * This is an interface of a sorter
 * 
 * @author Stefano Kowalke 485366
 * @author Finn Kondering 399083 
 */
public interface ISorter
{
    /**
     * An abstract sort method. 
     * 
     * @param a An array of the items to sort
     */
    void sort(int[] a);
    
    /**
     * Returns the name of the sort algoritm
     * 
     * @return A string with the name of the sort alorithm  
     */
    String getSorterName();
    
    /**
     * Returns the amount of array accesses
     * 
     * @return Returns a amount of array accesses
     */
    public long getArrayAccessCounter();
}
