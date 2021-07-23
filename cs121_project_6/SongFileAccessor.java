 

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class extends FileAccessor to process the song data in a text file.
 * The songs are stored in the file in comma-delimited(CSV) format. Each
 * line in the file represents one song. Each line in the file is processed
 * into a new Song object, which is placed on the SongList member variable "songs".
 * Another method, writeSongsToFile, takes a SongList, converts its songs to a single 
 * CSV formatted String and writes it to the text file. 
**/
public class SongFileAccessor extends FileAccessor{

  SongList songs;
  /* After the call to the superclass constructor, initialize the member variable "songs" 
     to a new SongList.  
  */
  public SongFileAccessor(String f) throws IOException{
    super(f);
    songs = new SongList();
  }
  
  /* This method implements the abstract method processLine in the FileAccessor class.
     It uses the String class method split to parse the line into individual Strings.
     The split method is passed "," as a parameter since the comma is the delimeter.
     
     Each line of the file has this format:
     title,album,artist,playTime
     Where title, artist and playTime are required, and album is optional. An example of
     a line with no album:
     title,,artist,playTime
     
     You may assume that the title, artist and playTime fields will always be present. After 
     the line has been tokenized, the array returned by split contains the data needed to create a 
     new Song object which is then added to the SongList object songs. 
     You have to check the length of the second token to determine if the album field is present and based 
     on that length which Song constructor to call.
  */
  public void processLine(String line){
	   String[] lineContent;
	   lineContent = line.split(",");
	   if (lineContent[1].length() == 0) {
		   Song currentSong = new Song(lineContent[0], lineContent[2], Double.valueOf(lineContent[3]));   
		   songs.addSong(currentSong);
	   }else { 
		   Song currentSong = new Song(lineContent[0], lineContent[1], lineContent[2], Double.valueOf(lineContent[3]));
		   songs.addSong(currentSong);
	   	}
  }
  
  /*  Formats the data in a Song object into a String in CSV format.
   *  See the text files and instructions for examples of this format.
  */   
   public String songToCSVString(Song song){
     return song.getTitle() + "," + song.getAlbum() + "," + song.getArtist() + "," + song.getPlayTime() + "\n";
   }
  
  /* This method returns a String of all songs in the song list
     in CSV format. Each song must be put into CSV format, and
     a line break inserted between songs. Calls songToCSVString.
  */
  public String getSongsAsCSV(SongList songList){
	  String allSongs = "";
	  for (int i = 0; i< songList.getSongList().size();i++) {
		  allSongs += songToCSVString(songList.getSongList().get(i));
	  }
     return allSongs;
   }
   
  /* Returns the SongList member variable "songs".
  */
  public SongList getSongList(){
    return songs;
  }

  /* This method writes the data in a SongList object to the text file.
     The songs on the list must first be converted into a String in CSV
     format. Then this method calls the writeToFile method, passing it the 
     CSV String and the fileName.
  */  
  public void writeSongsToFile(SongList songs) throws IOException{
    writeToFile(getSongsAsCSV(songs), fileName);
  }
  
  // This main can be run for testing SongFileAccessor.
    public static void main(String[] args)throws IOException{
        // need a file to pass in, but can ignore it and enter your own inputs.
         String dataFile = "songfiles/test0songs.txt";
         SongFileAccessor sfa = new SongFileAccessor(dataFile);
         Song song1 = new Song("Kashmir", "Physical Graffiti", "Led Zepplin", 8.37);
     //  Test songToCSVString 
         System.out.println("****** Test songToCSVString ******");
         String songCSVstr = sfa.songToCSVString(song1);
         System.out.println("songToCSVString output: "+ songCSVstr); 
         System.out.println("correct output:  Kashmir,Physical Graffiti,Led Zepplin,8.37");
         System.out.println(" "); 
     //  Test getSongsAsCSV 
         System.out.println("****** Test getSongsAsCSV ******");
         SongList songList = new SongList();
         songList.addSong(new Song("What About Us", "Beautiful Trauma", "P!nk", 4.31));
         String songsCSVstr = sfa.getSongsAsCSV(songList);
         System.out.println("songToCSVString output:  "+ songsCSVstr);
         System.out.println("correct output:  What About Us,Beautiful Trauma,P!nk,4.31");
         System.out.println("-note: should see a space between the above because a line break is added in getSongsAsCSV.");
         System.out.println(" "); 
     //  Test processLine
         System.out.println("****** Test processLine ******");
         String csvLine = "Like It Is,The Blue,Yusef Lateef,7.36";
         sfa.processLine(csvLine);
         SongList songs = sfa.getSongList();
         ArrayList<Song> songArrayList = songs.getSongList();
         Song testSong = songArrayList.get(0);
         System.out.println("title test: "+"Like It Is"+ " - "+testSong.getTitle());
         System.out.println("album test: "+"The Blue"+ " - "+testSong.getAlbum());
         System.out.println("artist test: "+"Yusef Lateef"+ " - "+testSong.getArtist());
         System.out.println("playtime test: 7.36"+ " - "+testSong.getPlayTime());
    }
}