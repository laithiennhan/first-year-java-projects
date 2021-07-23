import java.util.ArrayList;
/* This class encapsulates a list of songs in a user's collection and several
 * operations that can be performed on that list. A song is represented 
 * by an instance of the Song class. Each song has the following fields:
 * a title, an (optional) album, an artist, and a playing time.
*/
public class SongList {
   //Class member variable declaration(s):
    ArrayList<Song> songList;


   /* Constructor that initializes the list and any other 
   *  variables.
   */    
   public SongList(){
	   songList = new ArrayList<Song>();
   }
   
   /* Returns true if the song list contains no songs, false otherwise.
    */
   public boolean isEmpty(){
	  if (songList.isEmpty() == true) {
		  return true;
	  }else return false;
   }
   
   /* Add the song passed in to the end of the list. 
    * For example, if the list contained: song1, song2,
    * the next song added, song3, would result in this list:
    * song1, song2, song3.
   */
   public void addSong(Song newSong){
	   songList.add(newSong);
     
   }
   
      /* This method returns a String which consists of the String
    * representation of each song in the list. A line break is
    * inserted between each song String.
    * If the song list is empty, the String "no songs" is returned.
   */
   public String getSongListAsString(){
	  String list = "";
	   if (songList.isEmpty() == true) {
		  list = "no songs";
	  } else {
		  for (int i = 0; i<songList.size();i++) {
			  list += (i+1) + songList.get(i).toString() + "\n";
		  }
	  }
     return list;
   }
   
  /* Remove the song in the songList with the targetTitle.
   * First, the method searches for a song in the list with a title that 
   * matches the targetTitle. If it is found, that song is removed from 
   * the list. If the targetTitle is not matched, the list remains the same and false is returned.
   * Note that there should not be any null values between songs in the list.
   * For example, if the list contained: song1, song2, song3,
   * and the title of song2 was "MyTitle", this call:  
   *          removeSongByTitle("MyTitle");
   * would result in this list:  song1, song3.
   * This method returns true if the targetTitle matches the title of a song in the list,
   * false otherwise.
   */
   public boolean removeSongByTitle(String targetTitle){
	   if (isEmpty() == true){
		   return false;
	   }
	   for (Song l: songList) {
		   if (l.getTitle().equalsIgnoreCase(targetTitle)){
			   songList.remove(l);
			   return true;
		   }
	   }
	   return false;  
   }
   
  /* 
   * Return the song list object.
   */
   public ArrayList<Song> getSongList(){
      return songList;
   }
   
   /* Remove all songs from the list, resulting in an empty list.
    */
   public void clearSongList(){
	   songList.removeAll(songList);
   }
}