package sorter;

import java.util.Random;

/**
 * 
 * @author Stefano Kowalke 485366
 * @author Finn Kondering  
 */
public class Sort
{
    /**
     * An object of the file writer class
     */
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
            array[i] = randomGenerator.nextInt(1000);
        }

        return array;
    }

    /**
     * Here we call the various sort algoritm by dependency injection
     * 
     * @param int size
     * @param Sorter s
     * @return String A HTML table row with some output of the called algoritm
     */
    private static String sort(int size, Sorter s, char method)
    {
        String result;
        setSorter(s);
        int counter = 0;
        switch (method)
        {
            case 'a':
                int[] ascendingNumbersArray = new int[size];
                counter = 0;
                for (int i = 0; i < size; i++)
                {
                    ascendingNumbersArray[counter++] = i;
                }

                sorter.sort(ascendingNumbersArray);
                break;

            case 'd':
                int[] descendingNumbersArray = new int[size];
                counter = 0;
                for (int i = size - 1; i >= 0; i--)
                {
                    descendingNumbersArray[counter++] = i;
                }

                sorter.sort(descendingNumbersArray);
                break;

            case 'r':
                int randomNumberArray[] = getRandomIntArray(size);

                sorter.sort(randomNumberArray);
                break;

            default:
        }

        result = "<tr><td>" + sorter.getSorterName() + "</td><td>" + size + "</td><td>" + sorter.getArrayAccessCounter() + "</td></tr>";

        return result;
    }

    ;
	
	
    public static void main(String[] args)
    {
        Sorter mySorter;
        writer.createNewFile("Sortierergebnisse.html");

        writer.generateHTML('h');
        writer.writeLn("<h1>Vergleich von verschiedenen Sortierverfahren</h1>");

        writer.writeLn("<h2>Sortierverfahren mit aufsteigend sortierten Zahlen</h2>");
        writer.writeLn("<table style=\"border=1px solid black;\">");
        writer.writeLn("<tr><th>Sortierverfahren</th><th>Problemgröße n</th><th>Zeitkomplexität</th></tr>");

        mySorter = new InsertionSorter();
        writer.writeLn(sort(1000, mySorter, 'a'));
        writer.writeLn(sort(10000, mySorter, 'a'));
        writer.writeLn(sort(100000, mySorter, 'a'));

        mySorter = new QuickSorter();
        writer.writeLn(sort(1000, mySorter, 'a'));
        writer.writeLn(sort(10000, mySorter, 'a'));
        writer.writeLn(sort(100000, mySorter, 'a'));

        mySorter = new QuickSorterIterativ();
        writer.writeLn(sort(1000, mySorter, 'a'));
        writer.writeLn(sort(10000, mySorter, 'a'));
        writer.writeLn(sort(100000, mySorter, 'a'));
        
        mySorter = new MergeSorter();
        writer.writeLn(sort(1000, mySorter, 'a'));
        writer.writeLn(sort(10000, mySorter, 'a'));
        writer.writeLn(sort(100000, mySorter, 'a'));

        mySorter = new HeapSorter();
        writer.writeLn(sort(1000, mySorter, 'a'));
        writer.writeLn(sort(10000, mySorter, 'a'));
        writer.writeLn(sort(100000, mySorter, 'a'));

        writer.writeLn("</table>");

        writer.writeLn("<h2>Sortierverfahren mit Zufallszahlen</h2>");
        writer.writeLn("<table style=\"border=1px solid black;\">");
        writer.writeLn("<tr><th>Sortierverfahren</th><th>Problemgröße n</th><th>Zeitkomplexität</th></tr>");

        mySorter = new InsertionSorter();
        writer.writeLn(sort(1000, mySorter, 'r'));
        writer.writeLn(sort(10000, mySorter, 'r'));
        writer.writeLn(sort(100000, mySorter, 'r'));

        mySorter = new QuickSorter();
        writer.writeLn(sort(1000, mySorter, 'r'));
        writer.writeLn(sort(10000, mySorter, 'r'));
        writer.writeLn(sort(100000, mySorter, 'r'));

        mySorter = new QuickSorterIterativ();
        writer.writeLn(sort(1000, mySorter, 'r'));
        writer.writeLn(sort(10000, mySorter, 'r'));
        writer.writeLn(sort(100000, mySorter, 'r'));
        
        mySorter = new MergeSorter();
        writer.writeLn(sort(1000, mySorter, 'r'));
        writer.writeLn(sort(10000, mySorter, 'r'));
        writer.writeLn(sort(100000, mySorter, 'r'));

        mySorter = new HeapSorter();
        writer.writeLn(sort(1000, mySorter, 'r'));
        writer.writeLn(sort(10000, mySorter, 'r'));
        writer.writeLn(sort(100000, mySorter, 'r'));

        writer.writeLn("</table>");

        writer.writeLn("<h2>Sortierverfahren mit absteigend sortierten Zahlen</h2>");
        writer.writeLn("<table style=\"border=1px solid black;\">");
        writer.writeLn("<tr><th>Sortierverfahren</th><th>Problemgröße n</th><th>Zeitkomplexität</th></tr>");

        mySorter = new InsertionSorter();
        writer.writeLn(sort(1000, mySorter, 'd'));
        writer.writeLn(sort(10000, mySorter, 'd'));
        writer.writeLn(sort(100000, mySorter, 'd'));

        mySorter = new QuickSorter();
        writer.writeLn(sort(1000, mySorter, 'd'));
        writer.writeLn(sort(10000, mySorter, 'd'));
        writer.writeLn(sort(100000, mySorter, 'd'));

        mySorter = new QuickSorterIterativ();
        writer.writeLn(sort(1000, mySorter, 'd'));
        writer.writeLn(sort(10000, mySorter, 'd'));
        writer.writeLn(sort(100000, mySorter, 'd'));
        
        mySorter = new MergeSorter();
        writer.writeLn(sort(1000, mySorter, 'd'));
        writer.writeLn(sort(10000, mySorter, 'd'));
        writer.writeLn(sort(100000, mySorter, 'd'));

        mySorter = new HeapSorter();
        writer.writeLn(sort(1000, mySorter, 'd'));
        writer.writeLn(sort(10000, mySorter, 'd'));
        writer.writeLn(sort(100000, mySorter, 'd'));

        writer.writeLn("</table>");

        writer.generateHTML('f');
    }
}
