import java.util.Scanner;
/* This application manages a collection of songs for a user. The songs
 * are representeed by Song objects. The songs are managed by a SongList object.
 * The songs are stored in a comma-delimited text file.
 * A user has several options that are displayed in a menu format.
 * This class runs a console interface between a user and the SongList
*/
import java.io.*;

public class LibraryMain {
       
    public static void main(String[] args) throws IOException{
         // the file to store the user's songs:
         String dataFile = "songfiles/mysongs.txt";
         // testing files- uncomment a file for running tests:
         //dataFile = "songfiles/test_no_album.txt";
         //dataFile = "songfiles/test1song.txt";
         //dataFile = "songfiles/test2songs.txt";
   //      dataFile = "songfiles/test7songs.txt";

         System.out.println("My Song Library");
         Scanner scan = new Scanner(System.in);
         
         // for reading the song file
         SongFileAccessor sfa = null;
         // maintains the song list
         SongList songs = null;
         
        // Load any songs that were saved in the dataFile.
   /********* comment out these 3 lines to bypass the fileIO part.****/ 
         sfa = new SongFileAccessor(dataFile);
         sfa.processFile();
         songs = sfa.getSongList();
   /*****************************************************************/
         
    /******* Testing without FileIO- to test only the SongList- without FileIO
             uncomment the line below.   ********/
        // songs = getSongsForTesting();
    /***************************************/
       
         boolean keepGoing = true;
         String userStr = "";
         int position;
         
         while(keepGoing) {
              System.out.println("Main Menu:");
              System.out.println("Enter A to add a song."); 
              System.out.println("Enter R to remove a song."); 
              System.out.println("Enter P to view all songs.");
              System.out.println("Enter S to save all songs."); 
              System.out.println("Enter C to clear all songs."); 
              System.out.println("Enter X to quit.");
              System.out.println("");
              userStr = scan.nextLine();
              
              if (userStr.equalsIgnoreCase("A")){
                 System.out.println("Enter the title: ");
                 String title = scan.nextLine();
                 System.out.println("Enter the album, enter a space if none: ");
                 String album = scan.nextLine();
                 System.out.println("Enter the artist: ");
                 String artist = scan.nextLine();
                 System.out.println("Enter the playing time: ");
                 String playTime = scan.nextLine();
                 songs.addSong(new Song(title, album, artist, Double.parseDouble(playTime)));
              }
              else if (userStr.equalsIgnoreCase("R")){
                 System.out.println("Enter the title of the song to be removed:");
                 String title = scan.nextLine();
                 if(songs.removeSongByTitle(title))
                     System.out.println("Song "+title+" removed.");
                 else
                     System.out.println("Could not find "+title+" in the list.");
              }
              else if (userStr.equalsIgnoreCase("S")){
                 System.out.println("Your songs have been saved.");
                 sfa.writeSongsToFile(songs);
              }
              else if (userStr.equalsIgnoreCase("P")){
                 System.out.println("Your songs: ");
                 System.out.println(songs.getSongListAsString());
              }
              else if (userStr.equalsIgnoreCase("C")){
                 songs.clearSongList();
                 System.out.println("Songs cleared.");
              }
              else if(userStr.equalsIgnoreCase("X"))
                 keepGoing = false;
              else
                 System.out.println("Unrecognized input.");               
         }
         System.out.println("Bye for now.");
         scan.close();
    }
    
    public static SongList getSongsForTesting(){
       SongList songs = new SongList();       
       songs.addSong(new Song("XO Tour Llif3", "Luv Is Rage 2", "Lil Uzi Vert", 3.02));
       songs.addSong(new Song("Redbone", "Awaken, My Love!", "Childish Gambino", 5.27));
       songs.addSong(new Song("Bodak Yellow (Money Moves)", "", "Cardi B", 3.36));
       songs.addSong(new Song("What About Us", "Beautiful Trauma", "P!nk", 4.31));
       songs.addSong(new Song("DNA", "DAMN.", "Kendrick Lamar", 3.06)); 
       songs.addSong(new Song("Snow on tha Bluff", "","J. Cole", 3.55));
       songs.addSong(new Song("Like It Is","The Blue","Yusef Lateef",7.36));
       return songs;
    } 

}