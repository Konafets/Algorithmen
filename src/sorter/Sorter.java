package sorter;

/**
 * 
 * @author Stefano Kowalke 485366
 * @author Finn Kondering  
 */
public interface Sorter
{
    void sort(int[] a);
    String getSorterName();
    public long getArrayAccessCounter();
}
