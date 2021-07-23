/**
 * This class encapsulates the data required to represent a song in a song collection.
 * The attributes of a song are: title, album, artist, and playing time.
 * The title, artist, and playing time are required fields. The album field is optional.
 * The playing time is represented by a double value. For example, a playing time of 
 * five minutes and thirty-five seconds would be the number 5.35.
 **/
 public class Song {

  private String title;
  private String album;
  private String artist;
  private double playTime;
  
  /* Constructor when the album field is not present.
  */
  public Song(String title, String artist, double playTime){
    this.title = title;
    this.album = "";
    this.artist = artist; 
    this.playTime = playTime;
  }
 
  /* Constructor when all fileds are present.
  */ 
  public Song(String title, String album, String artist, double playTime){
    this.title = title;
    this.album = album;
    this.artist = artist; 
    this.playTime = playTime;
  }
  
  public String getTitle(){
     return title;
  }
  
  public String getAlbum(){
     return album;
  }
  
  public String getArtist(){
     return artist;
  }
  
  public double getPlayTime(){
     return playTime;
  }

  public String toString(){
     return title+", "+album+", "+artist+", "+playTime;
  }
}