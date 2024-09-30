import java.util.Scanner;

/**
 * Represents a Store which sells Documents, Images, or Videos
 */
public class FileStore {
  
  private boolean isBuying;              // whether or not the user is still buying at shop
  private double totalOrderPrice;        // total price of order
  private String receipt;                // string representation of order

  /**
   * Constructor of FileStore
   */
  public FileStore() {
    receipt = "";
  }

  /**
   * Prints out welcome message and starts the buying interaction.
   */
  public void startStore() {
    System.out.println("Welcome to my File Shop! I can make you the best digital files for purchase!\n");
    System.out.println("Would you like to purchase something today? (y/n)");
    
    Scanner input = new Scanner(System.in);
    String willPurchase = input.nextLine();
    
    if (willPurchase.equals("y")) {
      isBuying = true;
    }

    printBuyingMessage();

    input.close();
  }
  
  /**
   * Prints out buying message, and based off user input calls the appropriate 
   * purchase method. Then prompts the user if they still want to buy at the shop.
   */
  public void printBuyingMessage() {
    Scanner input = new Scanner(System.in);
    
    while (isBuying) {
      System.out.println("\nWhat would you like to buy today?");
      System.out.println("\t1. Document");
      System.out.println("\t2. Image");
      System.out.println("\t3. Video");
      
      int itemToBuy = input.nextInt();

      // 1 -> Document, 2 -> Image, 3 -> Video
      if (itemToBuy == 1) {
        printPurchaseChoice(FileType.DOCUMENT);
      } else if (itemToBuy == 2) {
        printPurchaseChoice(FileType.IMAGE);
      } else if (itemToBuy == 3) {
        printPurchaseChoice(FileType.VIDEO);
      } else {
        System.out.println("I dont understand that option, try again");
      }
      
      continueBuying();
    }

    System.out.println(receipt);
    System.out.println("Thank you! See you soon! =)");
    
    input.close();
  }

  /**
   * Determines how many Files the user wants to purchase.
   */
  public void printPurchaseChoice(FileType fileType) {
    Scanner input = new Scanner(System.in);
    
    System.out.println("\nHow many " + fileType.name().toLowerCase() + "s do you want to purchase?");
    int numToBuy = input.nextInt();
    
    createFile(fileType, numToBuy);
    
    input.close();
  }

  /**
   * Creates a File object based on the type of file the user is purchasing,
   * and sets appropriate instance variables for file based on user input.
   */
  public void createFile(FileType fileType, int numToBuy) {
    if (fileType == FileType.DOCUMENT) {
      Document d = Document.createDocumentWithScanner();
      
      System.out.println("\nAdded to receipt:\n(" + numToBuy + ") " +  d);
      addToReceipt(d, numToBuy);
    } else if (fileType == FileType.IMAGE) {
      Image i = Image.createImageWithScanner();
      
      System.out.println("\nAdded to receipt:\n(" + numToBuy + ") " +  i);
      addToReceipt(i, numToBuy);
    } else {
      Video v = Video.createVideoWithScanner();
      
      System.out.println("\nAdded to receipt:\n(" + numToBuy + ") " +  v);
      addToReceipt(v, numToBuy);
    }
  }

  /**
   * Adds a string representation of the File to the user's reciept
   */
  public void addToReceipt(File f, int numToBuy) {
    double totalItemPrice = f.calculatePrice() * numToBuy;
    totalOrderPrice += totalItemPrice;
    
    if (receipt.equals("")) {
      receipt = "\n+-- Qty --+--------------- Item ---------------+-- Price --+\n";
    }
    
    String leftAlignFormat = "%-7d | %-34s | %-9s";
    receipt += "| " + String.format(leftAlignFormat, numToBuy, f, "$" + totalItemPrice + "0") + " |\n";
  }

  /**
   * Asked the user if they still want to buy from the shop
   */
  public void continueBuying() {
    Scanner input = new Scanner(System.in);
    
    System.out.println("\nWould you like to buy anything else? (y/n)");
    String continueBuying = input.nextLine();
    
    if (continueBuying.equals("n")) {
      isBuying = false;
      
      receipt += "+---------+------------------------------------+-----------+\n";
      String alignFormat = "%60s";
      receipt += String.format(alignFormat, "Total: $" + totalOrderPrice + "0\n");
    }

    input.close();
  }
  
}