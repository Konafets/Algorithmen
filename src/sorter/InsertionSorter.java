/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sorter;

/**
 * 
 * @author Stefano Kowalke 485366
 * @author Finn Kondering  
 */
public class InsertionSorter implements ISorter
{

    private int[] a;
    private int n;
    private long arrayAccessCounter;

    public void sort(int[] a)
    {
        setArrayAccessCounter(0);
        this.a = a;
        n = a.length;
        insertionsort();
    }

    public String getSorterName()
    {
        return "Insertionsort";
    }

    private void setArrayAccessCounter(int i)
    {
        arrayAccessCounter = i;
    }

    public long getArrayAccessCounter()
    {
        return arrayAccessCounter;
    }

    private int c(int k)
    {
        arrayAccessCounter++;
        return k;
    }

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
