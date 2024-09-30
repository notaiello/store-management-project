import java.util.Scanner;

/**
 * Represents a Word Document file
 */
public class Document extends File {

  private int numWords;                         // number of words in the Document file
  private final double PRICE_PER_WORD = 0.01;   // price for each word in the Document
  
  /**
   * No-Argument Constructor
   */
  public Document() {
    super();
    this.numWords = 0;
  }
  
  /**
   * Parameterized Constructor
   */
  public Document(String name, String extension, int numWords) {
    super(name, extension, 2.0);
    this.numWords = numWords;
  }

  /**
   * Calculate price of document (overriden from File class)
   */
  public double calculatePrice() {
    return super.getPrice() + numWords * PRICE_PER_WORD;
  }

  /**
   * Returns a Document object based on the information provided by user input
   */
  public static Document createDocumentWithScanner() {
    Scanner input = new Scanner(System.in);
    
    System.out.println("What is the name of this document?");
    String fileName = input.nextLine();

    System.out.println("What is file extension");
    String fileExtension = input.nextLine();

    System.out.println("How many words are in the document?");
    int fileNumWords = input.nextInt();

    input.close();

    return new Document(fileName, fileExtension, fileNumWords);
  }

  /**
   * Accessor Method for numWords
   */
  public int getNumWords() {
    return numWords;
  }
  
  /**
   * Mutator Method for numWords
   */
  public void setNumWords(int numWord) {
    this.numWords = numWords;
  }

  /**
   * toString() Method Override
   */
  public String toString() {
    return super.toString() + " (" + numWords + " words)";
  }

  
}