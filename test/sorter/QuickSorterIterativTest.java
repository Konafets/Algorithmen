/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sorter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sok
 */
public class QuickSorterIterativTest
{
    
    private QuickSorterIterativ quicksorterIterative;
    private int[] numbersDesc, numbersAsc, numbersRandom;
    
    public QuickSorterIterativTest()
    {
    }

    @Before
    public void setUp()
    {
        quicksorterIterative = new QuickSorterIterativ();
        
        int size = 10;
        
        numbersDesc = new int[size];
        int counter = 0;
        for (int i = size - 1; i >= 0; i--)
        {
            numbersDesc[counter++] = i;
        }
        
        numbersAsc = new int[size];
        counter = 0;
        for (int i = 0; i < size; i++)
        {
            numbersAsc[counter++] = i;
        }
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of sort method, of class QuickSorterIterativ.
     */
    @Test
    public void SortDesc()
    {
        System.out.println("QuickSorterIterativTest: sortDesc()");
        int[] a = null;

        int[] expResult = numbersDesc;
        for (int i = 0; i < numbersDesc.length; i++)
        {
            System.out.println(numbersDesc[i]);
        }
        quicksorterIterative.sort(numbersDesc);
        for (int i = 0; i < numbersDesc.length; i++)
        {
            System.out.println(numbersDesc[i]);
        }
        
        int[] result = numbersDesc;
        assertEquals(expResult, result);
    }

        /**
     * Test of sort method, of class QuickSorterIterativ.
     */
    @Test
    public void SortAsc()
    {
        System.out.println("QuickSorterIterativTest: sortAsc()");
        int[] a = null;

        int[] expResult = numbersDesc;
        for (int i = 0; i < numbersDesc.length; i++)
        {
            System.out.println(numbersDesc[i]);
        }
        
        quicksorterIterative.sort(numbersAsc);
        int[] result = numbersAsc;
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getSorterName method, of class QuickSorterIterativ.
     */
    @Test
    public void GetSorterName()
    {
        System.out.println("QuickSorterIterativTest: getSorterName()");
        String expResult = "Quicksort Iterativ";
        String result = quicksorterIterative.getSorterName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getArrayAccessCounter method, of class QuickSorterIterativ.
     */
    @Test
    public void GetArrayAccessCounter()
    {
        System.out.println("QuickSorterIterativTest: getArrayAccessCounter()");
        int[] a = {1,2};

        quicksorterIterative.sort(a);

        long expResult = 8L;
        long result = quicksorterIterative.getArrayAccessCounter();
        assertEquals(expResult, result);
    }
}
