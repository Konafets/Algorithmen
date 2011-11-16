/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sorter;

/**
 *
 * @author sok
 */
public class QuickSorterYT implements Sorter
{
    private int[] numbers;
    private int length;

    public void sort(int[] a)
    {
        this.numbers = a;
			// Lenght of complete array
        length = a.length;
		quicksortYT(0, length - 1);
    }
    
    public String getSorterName()
    {
        return "Quicksort YoutTube";
    }

    private void quicksortYT (int lo, int hi)
    {
        int i=lo, j=hi;
		
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
      if (lo<j) quicksortYT(lo, j);
      if (i<hi) quicksortYT(i, hi);
    }

    private void exchange(int i, int j)
    {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

}    // end class QuickSorter