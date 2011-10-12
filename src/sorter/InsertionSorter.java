/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sorter;

/**
 *
 * @author sok
 */
public class InsertionSorter
{
    private int[] a;
    private int n;

    public void sort(int[] a)
    {
        this.a=a;
        n=a.length;
        insertionsort();
    }

    private void insertionsort()
    {
        int i, j, t;
        for (i=1; i<n; i++)
        {
            j=i;
            t=a[j];
            while (j>0 && a[j-1]>t)
            {
                a[j]=a[j-1];
                j--;
            }
            a[j]=t;
        }
    }

}    // end class InsertionSorter
