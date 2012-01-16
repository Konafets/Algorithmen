package sorter;

/**
 * 
 * @author Stefano Kowalke 485366
 * @author Finn Kondering 399083  
 */
public class HeapSorter implements ISorter
{

    private int[] a;
    private int n;
    private long arrayAccessCounter;

    public void sort(int[] a)
    {
        setArrayAccessCounter(0);
        this.a = a;
        n = a.length;
        heapsort();
    }

    public String getSorterName()
    {
        return "Heapsort";
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

    private void buildheap()
    {
        for (int v = n / 2 - 1; v >= 0; v--)
        {
            downheap(v);
        }
    }

    private void downheap(int v)
    {
        int w = 2 * v + 1;         // erster Nachfolger von v
        while (w < n)
        {
            if (w + 1 < n)       // gibt es einen zweiten Nachfolger?
            {
                if (a[c(w + 1)] > a[c(w)])
                {
                    w++;
                }
            }
            // w ist der Nachfolger von v mit maximaler Markierung

            if (a[c(v)] >= a[c(w)])
            {
                return; // v hat die Heap-Eigenschaft
            }

            // sonst
            exchange(v, w);  // vertausche Markierungen von v und w
            v = w;             // fahre mit v=w fort
            w = 2 * v + 1;
        }
    }

    private void exchange(int i, int j)
    {
        int t = a[c(i)];
        a[c(i)] = a[c(j)];
        a[c(j)] = t;
    }
}
