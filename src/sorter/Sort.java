/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sorter;

import java.util.*;


/**
 *
 * @author sok
 */
public class Sort
{
	
    private static long start, runningTime;
    private static FileWriterHtml writer = new FileWriterHtml();
    
    private static Sorter sorter;
    
    private static void setSorter(Sorter s)
    {
        sorter = s;
    }
    
    private static int[] getRandomIntArray(int size)
    {
        Random randomGenerator = new Random();	
	int array[] = new int[size];
        for (int i = 0; i < size; i++)
	{
            array[i] = randomGenerator.nextInt();
	}
		
        return array;
    }	
    
    
    private static String sort(int randomNumber, Sorter s) 
    {
        String result;
        setSorter(s);
        int randomNumberArray[] = getRandomIntArray(randomNumber);   
        
        start = new Date().getTime();
        sorter.sort(randomNumberArray);
        runningTime = new Date().getTime() - start;
        result = "<tr><td>" + sorter.getSorterName() + "</td><td>"  + randomNumber + "</td><td>" + runningTime + "</td></tr>";
                
        return result;
    };
	
	
    public static void main(String [] args)
    {
        writer.generateHTML('h');
        writer.schreiben("<table style=\"border=1px solid black;\">");
        writer.schreiben("<tr><th>Sortierverfahren</th><th>Problemgröße n</th><th>Zeit</th></tr>");
        
        InsertionSorter iSorter = new InsertionSorter();
        writer.schreiben(sort(1000, iSorter));
        writer.schreiben(sort(10000, iSorter));
        writer.schreiben(sort(100000, iSorter));
		
        QuickSorter qSorter = new QuickSorter();
        writer.schreiben(sort(1000, qSorter));
        writer.schreiben(sort(10000, qSorter));
        writer.schreiben(sort(100000, qSorter));
        
        MergeSorter mSorter = new MergeSorter();
        writer.schreiben(sort(1000, mSorter));
        writer.schreiben(sort(10000, mSorter));
        writer.schreiben(sort(100000, mSorter));
        writer.schreiben("</table>");
        writer.generateHTML('f');
    }
}


