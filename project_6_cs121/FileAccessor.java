import java.util.Scanner;
import java.io.*;

/**
 * This abstract class contains the functionality of reading lines from a text file
 * and writing a String to a text file. Its abstract method, processLine, is intended to 
 * be implemented by subclasses so they can process each line in their specialized manner.
 * This class utilizes a Scanner member variable to read from a text file. The file name is 
 * a protected member variable and is available directly to its subclasses. A PrintWriter is used
 * in the writeToFile method to write a String to the file.
 */
public abstract class FileAccessor{
  protected String fileName; 
  Scanner scan;

  /* Constructor that initializes the Scanner and opens the file.
   * An IOException is thrown if the file cannot be opened or is not found.
  */
  public FileAccessor(String fName) throws IOException{
    fileName = fName;
    scan = new Scanner(new FileReader(fileName));
  }

  /* Assumes the Scanner instance contains the lines of text from the file.
   * The lines are read from the scanner, and processLine is called in each line.
  */
  public void processFile() { 
    while(scan.hasNext()){
      processLine(scan.nextLine());
    }
    scan.close();
  }
  
  /* This method must be implemented by any subclass. This allows the 
   * subclass to handle the line of text in its own specialized manner.
  */
  public abstract void processLine(String line);
  
  /* This method utilizes a PrintWriter to write a String to a text file.
   * An IOException is thrown if the file cannot be opened or found.
  */
  public void writeToFile(String data, String fileName) throws IOException{
		PrintWriter pw = new PrintWriter(fileName);
      pw.print(data);
      pw.close();
   }
   
}
