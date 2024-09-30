import java.util.Scanner;

/**
 * Represents a File that is on a computer
 */
public class File {

  private String name;          // The name of the File
  private String extension;     // The extension of the File (ex. "png" or "docx")
  private boolean isOpen;       // Whether or not the File is currently open
  private double price;         // basr price of the File

  /**
   * No-Arguement Constructor
   */
  public File() {
    this("no name", "no extension", 0.0);
  }
  
  /**
   * Parameterized Constructor
   */
  public File(String name, String extension, double price) {
    this.name = name;
    this.extension = extension;
    this.price = price;
  }

  /**
   * Calculates price of File, will be overrided in File subclasses
   */
  public double calculatePrice() {
    return price;
  }

  /**
   * Accessor Method for name
   */
  public String getName() {
    return name;
  }
  
  /**
   * Accessor Method for extension
   */
  public String getExtension() {
    return extension;
  }

  /**
   * Accessor Method for isOpen
   */
  public boolean getIsOpen() {
    return isOpen;
  }

  /**
   * Accessor Method for isOpen
   */
  public double getPrice() {
    return price;
  }

  /**
   * Mutator Method for name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Mutator Method for extension
   */
  public void setExtension(String extension) {
    this.name = extension;
  }
  
  /**
   * Mutator Method for isOpen
   */
  public void setIsOpen(boolean isOpen) {
    this.isOpen = isOpen;
  }

  /**
   * Mutator Method for price
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * toString() Method Override
   */
  public String toString() {
    return name + "." + extension;
  }
 
}