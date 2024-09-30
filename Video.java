import java.util.Scanner;

/**
 * Represents a Video file
 */
public class Video extends File {
  
  private int duration;                              // length of the Video in second
  private boolean isHD;                              // whether or not the Video is in HD
  private final int HD_FACTOR = 2;                   // factor if video is in HS
  private final double PRICE_PER_SECOND = 0.01;      // price for each second of the Video

  /**
   * No-Argument Constructor
   */
  public Video() {
    super();
    this.duration = 0;
    this.isHD = false;
  }
  
  /**
   * Parameterized Constructor
   */
  public Video(String name, String extension, int duration, boolean isHD) {
    super(name, extension, 10.0);
    this.duration = duration;
    this.isHD = isHD;
  }

  /**
   * Calculate price of Video (overriden from File class)
   */
  public double calculatePrice() {
    int HDFactor = isHD ? HD_FACTOR : 1;
    return (super.getPrice() + duration * PRICE_PER_SECOND) * HDFactor;
  }

  /**
   * Returns a Video object based on the information provided by user input
   */
  public static Video createVideoWithScanner() {
    Scanner input = new Scanner(System.in);
    
    System.out.println("What is the name of this video?");
    String fileName = input.nextLine();

    System.out.println("What is file extension");
    String fileExtension = input.nextLine();

    System.out.println("How long is the video?");
    int fileDuration = input.nextInt();

    System.out.println("Is it in HD? (y/n)");
    String isHDChoice = input.next();
    boolean fileHD = false;

    if(isHDChoice.equals("y")) {
      fileHD = true;
    }

    input.close();

    return new Video(fileName, fileExtension, fileDuration, fileHD);
  }

  /**
   * Accessor Method for duration
   */
  public int getDuration() {
    return duration;
  }
  
  /**
   * Mutator Method for duration
   */
  public void setDuration(int duration) {
    this.duration = duration;
  }

  /**
   * Accessor Method for isHD
   */
  public boolean getIsHD() {
    return isHD;
  }
  
  /**
   * Mutator Method for height
   */
  public void setIsHD(boolean isHD) {
    this.isHD = isHD;
  }

  /**
   * toString() Method Override
   */
  public String toString() {
    String isHDString = isHD ? " [HD]" : "";
    return super.toString() + " (" + duration + " seconds)" + isHDString;
  }

  
}