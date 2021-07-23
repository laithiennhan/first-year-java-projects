import java.util.Scanner;
import java.io.*;
/* This class interacts with the user to get a list of search terms and the
 * name of a directory that contains text files to be searched. 
 * It uses an instance of FileRelations to analyze the text in each file
 * and prints the results to the user.
 */
public class FileRelationsMain{
   
   public static void main(String[] args){
      
      // Our user input reader
      Scanner scan = new Scanner(System.in);
      // Our FileRelations object
      FileRelations analyser;
      
      // Get user's search terms:
      System.out.println("Welcome to Coogle, your favorite file searcher. What can I help you find?");
      System.out.println("Please enter the search terms separated with spaces then press 'enter':");
      
      // Get the next line of user input, then split it into words (tokenize).
      String[] termsArray = scan.nextLine().replaceAll("[^a-zA-Z ]", "").split(" ");
      // Initialize the FileRelations object with the tokenized search terms.
      analyser = new FileRelations(termsArray);

      // Get the directory to search. All files in this directory are searched.
      File f = null;
      System.out.println("Enter a directory to search: ");
      String startDirStr = scan.nextLine();
      File startDir = new File(startDirStr);

      // Use the Java File class to access the files in the startDir. 
      // Call the listFiles() method to obtain an array of File objects.
      // Each File object represents a file in the startDir.          
      File[] fileList = startDir.listFiles();

      // Traverse the fileList, call the getTextFileContents method
      // to get the text from the file as an array of Strings. 
      // Then call the analyseFile method to analyse the file content.
      for(File curFile : fileList){
         String filePath = curFile.getPath(); 
         String[] fileContent = getTextFileContents(filePath);
         analyser.analyseFile(fileContent, filePath);
      }
      System.out.println();
      System.out.println("Search complete, displaying results:");
      if(analyser.getTopScore() <= 0){
         System.out.println("Your search could not be found. Try again with different terms.");
      } else {
         System.out.println("I recommend you look at: " + analyser.getTopFile());
      }
   }
   
  /**
   * This method reads the text (as lines of Strings) in the file 
   * at the location passed in. 
   * @param the location and name of a file to be read.
   * @return a String array containing all lines in the file.
   */
   public static String[] getTextFileContents(String filePath){
      String[] fileContent = null;
      String lines = "";
      BufferedReader reader = null;
      try{
         reader = new BufferedReader(new FileReader(filePath));
         String line = reader.readLine();
         while(line != null){
            // Removing punctuation from the string before it is processed
            lines += line.replaceAll("[^a-zA-Z ]", "") + "\n";
            line = reader.readLine();
         }   
         fileContent = lines.split("\n");
      } catch (FileNotFoundException e){
         System.out.println("Could not find file: \"" + filePath + "\". Skipping...");
      } catch (IOException e){
         System.out.println("Unknown error reading file. Attempting to continue.");
      }
      return fileContent;
   }
}