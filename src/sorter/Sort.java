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
    
    /**
     * Here we will save a object of a sort algorithm for DI
     */
    private static Sorter sorter;
    
    /**
     * Set the sorter -> Setter-Injection
     * @param Sorter s 
     * @return void
     */
    private static void setSorter(Sorter s)
    {
        sorter = s;
    }
    
    /**
     * Creates a array of random integers in the given size
     * 
     * @param int size
     * @return array 
     */
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
    
    /**
     * Here we call the various sort algoritm by dependency injection
     * 
     * @param int randomNumber
     * @param Sorter s
     * @return String A HTML table row with some output of the called algoritm
     */
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
        writer.createNewFile("Sortierergebnisse.html");
 
        writer.generateHTML('h');
        writer.writeLn("<table style=\"border=1px solid black;\">");
        writer.writeLn("<tr><th>Sortierverfahren</th><th>Problemgröße n</th><th>Zeit</th></tr>");
        QuickSorterYT qSorterYT = new QuickSorterYT();
        writer.writeLn(sort(10, qSorterYT));
        writer.writeLn(sort(1000, qSorterYT));
        writer.writeLn(sort(10000, qSorterYT));
        writer.writeLn(sort(100000, qSorterYT));
		
        InsertionSorter iSorter = new InsertionSorter();
        writer.writeLn(sort(1000, iSorter));
        writer.writeLn(sort(10000, iSorter));
        writer.writeLn(sort(100000, iSorter));
		
        QuickSorter qSorter = new QuickSorter();
        writer.writeLn(sort(1000, qSorter));
        writer.writeLn(sort(10000, qSorter));
        writer.writeLn(sort(100000, qSorter));
        
        MergeSorter mSorter = new MergeSorter();
        writer.writeLn(sort(1000, mSorter));
        writer.writeLn(sort(10000, mSorter));
        writer.writeLn(sort(100000, mSorter));
        writer.writeLn("</table>");
        writer.generateHTML('f');
    }
}


