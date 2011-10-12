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
    
    
    private static String sort(int randomNumber, char typeOfSorter) 
    {
        int randomNumberArray[];
        // sortiere 1000 Zufallszahlen mit Insertionsort
        randomNumberArray = getRandomIntArray(randomNumber);
     
        String result;
        switch (typeOfSorter)
        {
            
            case 'i':
                InsertionSorter iSorter = new InsertionSorter();
                start = new Date().getTime();
                iSorter.sort(randomNumberArray);
                runningTime = new Date().getTime() - start;
                result = "<tr><td>Insertionsort</td><td>"  + randomNumber + "</td><td>" + runningTime + "</td></tr>";
                //System.out.println("sortiere " + randomNumber + " Zufallszahlen mit Insertionsort \n Laufzeit: " + runningTime + "ms"); 
                break;
            case 'q':
                QuickSorter qSorter = new QuickSorter();
                start = new Date().getTime();
                qSorter.sort(randomNumberArray);
                runningTime = new Date().getTime() - start;
                result = "<tr><td>Quicksort</td><td>"  + randomNumber + "</td><td>" + runningTime + "</td></tr>";
                //System.out.println("sortiere " + randomNumber + " Zufallszahlen mit Quicksort \n Laufzeit: " + runningTime + "ms"); 
                break;
            case 'm':
                MergeSorter mSorter = new MergeSorter();
                start = new Date().getTime();
                mSorter.sort(randomNumberArray);
                runningTime = new Date().getTime() - start;
                result = "<tr><td>Mergesort</td><td>"  + randomNumber + "</td><td>" + runningTime + "</td></tr>";
                //System.out.println("sortiere " + randomNumber + " Zufallszahlen mit Mergesort \n Laufzeit: " + runningTime + "ms"); 
                break;
            default:
                //System.out.println("No sorter selected");
                result = "";
                
                
        }
        
        return result;
    };
	
	
    public static void main(String [] args)
    {
        writer.generateHTML('h');
        writer.schreiben("<table style=\"border=1px solid black;\">");
        writer.schreiben("<tr><th>Sortierverfahren</th><th>Problemgröße n</th><th>Zeit</th></tr>");
        writer.schreiben(sort(1000, 'i'));
        writer.schreiben(sort(10000, 'i'));
        writer.schreiben(sort(100000, 'i'));
		
        writer.schreiben(sort(1000, 'q'));
        writer.schreiben(sort(10000, 'q'));
        writer.schreiben(sort(100000, 'q'));
        
        writer.schreiben(sort(1000, 'm'));
        writer.schreiben(sort(10000, 'm'));
        writer.schreiben(sort(100000, 'm'));
        writer.schreiben("</table>");
        writer.generateHTML('f');
    }
}


