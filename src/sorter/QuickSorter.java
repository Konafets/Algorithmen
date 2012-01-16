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
public class QuickSorter implements ISorter
{

    private int[] a;
    private int n;
    private long arrayAccessCounter;

    public void sort(int[] a)
    {
        setArrayAccessCounter(0);
        this.a = a;
        n = a.length;
        quicksort(0, n - 1);
    }

    public String getSorterName()
    {
        return "Quicksort Rekursiv";
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

    private void quicksort(int lo, int hi)
    {
        int i = lo, j = hi;

        // Vergleichs­element x
        int x = a[c((lo + hi) / 2)];

        //  Aufteilung
        while (i <= j)
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

        // Rekursion
        if (lo < j)
        {
            quicksort(lo, j);
        }
        if (i < hi)
        {
            quicksort(i, hi);
        }
    }

    private void exchange(int i, int j)
    {
        int t = a[c(i)];
        a[c(i)] = a[c(j)];
        a[c(j)] = t;
    }
}    // end class QuickSorter
