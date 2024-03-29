package sorter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class provides methods to write some HTML into a file
 * Used to generate a HTML page for comparing the various sort alorithm 
 * 
 * @author Stefano Kowalke 485366
 * @author Finn Kondering 399083  
 */
public class FileWriterHtml
{
    /**
     * An object of the file writer class
     */
    static FileWriter writer;
    
    /**
     * A representation of a file
     */
    static File file;

    /**
     * Creates a new file. If the file exits, it will be deleted
     * 
     * @param filename 
     * @return void
     */
    public static void createNewFile(String filename)
    {
        boolean existFile = (new File(filename)).exists();
        if (existFile)
        {
            new File(filename).delete();
        }

        file = new File(filename);
    }

    /**
     * Outputs some predefined HTML-Tags
     * Values for codePart are:
     *    - h: header part of html file
     *    - f: footer part of html file
     * 
     * @param codePart 
     * @return void
     */
    public static void generateHTML(char codePart)
    {
        String html;

        switch (codePart)
        {
            case 'h':
                html = "<html><head><title>Sortierergebnisse für Sortieralogorithmen</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/></head><body>";
                writeLn(html);
                break;
            case 'f':
                html = "</body></hmtl>";
                writeLn(html);
                break;

            default:
        }
    }

    /**
     * Writes a line of text into a given file
     * 
     * @param code
     * @return void
     */
    public static void writeLn(String code)
    {
        try
        {
            // with second param is set to true, new lines will be append to the end of file
            writer = new FileWriter(file, true);

            // write the text into the stream
            writer.write(code);

            // insert platform-independ linebreak into the stream
            writer.write(System.getProperty("line.separator"));

            // write stream content into the file.
            // should be called at the end to be secure that the stream is empty and
            // everthing is in the file
            writer.flush();

            writer.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
