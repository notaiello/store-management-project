import java.util.Scanner;

/**
 * Represents a Image file
 */
public class Image extends File {
  
  private int width;                                // width of the Image in pixels
  private int height;                               // height of the Image in pixels
  private final double PRICE_PER_PIXEL = 0.0001;    // price for each pixel in the Image

  /**
   * No-Argument Constructor
   */
  public Image() {
    super();
    this.width = 0;
    this.height = 0;
  }
  
  /**
   * Parameterized Constructor
   */
  public Image(String name, String extension, int width, int height) {
    super(name, extension, 5.00);
    this.width = width;
    this.height = height;
  }

  /**
   * Calculate price of Image (overriden from File class)
   */
  public double calculatePrice() {
    return super.getPrice() + width * height * PRICE_PER_PIXEL;
  }
  
  /**
   * Returns a Image object based on the information provided by user input
   */
  public static Image createImageWithScanner() {
    Scanner input = new Scanner(System.in);
    
    System.out.println("What is the name of this image?");
    String fileName = input.nextLine();

    System.out.println("What is file extension");
    String fileExtension = input.nextLine();

    System.out.println("What is the width of the image?");
    int fileWidth = input.nextInt();
    
    System.out.println("What is the height of the image?");
    int fileHeight = input.nextInt();

    input.close();
    
    return new Image(fileName, fileExtension, fileWidth, fileHeight);
  }

  /**
   * Accessor Method for height
   */
  public int getHeight() {
    return height;
  }
  
  /**
   * Mutator Method for height
   */
  public void setHeight(int height) {
    this.height = height;
  }

  /**
   * Accessor Method for width
   */
  public int getWidth() {
    return width;
  }
  
  /**
   * Mutator Method for height
   */
  public void setWidth(int width) {
    this.width = width;
  }

  /**
   * toString() Method Override
   */
  public String toString() {
    return super.toString() + " (" + width + " x " + height + ")";
  }
  
}