/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sorter;

/**
 *
 * @author sok
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterHtml {
  
  static FileWriter writer;
  static File file;
  
  public static void generateHTML(char kind)
  {
      String html;
      
      switch (kind)
      {
          
          case 'h':
              html = "<html><head><title>Sortierergebnisse für Sortieralogorithmen</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/></head><body>";
              schreiben(html);
              break;
          case 'f':
              html = "</body></hmtl>";
              schreiben(html);
              break;
          
          default:
              
      
      }
  }
  
  public static void schreiben(String code){
    // File anlegen
     file = new File("Sortierergebnisse.html");
     try {
       // new FileWriter(file ,true) - falls die Datei bereits existiert
       // werden die Bytes an das Ende der Datei geschrieben
       
       // new FileWriter(file) - falls die Datei bereits existiert
       // wird diese überschrieben
       writer = new FileWriter(file, true);
       
       // Text wird in den Stream geschrieben
       writer.write(code);
       
       // Platformunabhängiger Zeilenumbruch wird in den Stream geschrieben
       writer.write(System.getProperty("line.separator"));
       
       // Schreibt den Stream in die Datei
       // Sollte immer am Ende ausgeführt werden, sodass der Stream 
       // leer ist und alles in der Datei steht.
       writer.flush();
       
       // Schließt den Stream
       writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
