package sorter;

/**
 * 
 * @author Stefano Kowalke 485366
 * @author Finn Kondering 399083
 */
public class QuickSorterIterativ implements ISorter
{
    private int[] a;
    private int n;
    private long arrayAccessCounter;

    public void sort(int[] a)
    {
        setArrayAccessCounter(0);
        this.a = a;
        n = a.length;
        quicksortIterativ(0, n - 1);
    }

    public String getSorterName()
    {
        return "Quicksort Iterativ";
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

    private void quicksortIterativ(int lo, int hi)
    {
        int m, x;

        while (lo < hi)
        {
            
            
            // Vergleichselement
            m = (lo + hi) / 2;
            x = a[c(m)];
            
            int i = lo;
            int j = hi;
            
            // Aufteilung
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
            
            // Rekursion
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
//        // äußere Schleife
//        while (true)
//        {
//            if (lo < hi)
//            {
//                int x = a[c((lo + hi) / 2)];
//                int i = lo - 1;
//                int j = hi + 1;
//
//                // innere Schleife
//                while (true)
//                {
//                    while (a[c(i)] < x)
//                    {
//                        i++;
//                    }
//                    while (a[c(j)] > x)
//                    {
//                        j--;
//                    }
//
//                    if (i >= j)
//                    {
//                        break;
//                    }
//                    
//                    exchange(a[c(i)], a[c(j)]);
//                }
//                
//            }
//            else
//            {
//                if ()
//            }
//        }

//        int i = lo, j = hi;
//
//        // Vergleichs­element x
//        int x = a[c((lo + hi) / 2)];
//
//        //  Aufteilung
//        while (i <= j)
//        {    
//            while (a[c(i)] < x) i++; 
//            while (a[c(j)] > x) j--;
//            if (i <= j)
//            {
//                exchange(i, j);
//                i++; j--;
//            }
//        }
//
//        // Rekursion
//        if (lo < j) quicksort(lo, j);
//        if (i < hi) quicksort(i, hi);
    }

    private void exchange(int i, int j)
    {
        int t = a[c(i)];
        a[c(i)] = a[c(j)];
        a[c(j)] = t;
    }
}
