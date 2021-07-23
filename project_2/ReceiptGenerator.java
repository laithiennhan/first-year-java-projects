/* This class keeps track of the information for a sales receipt, namely a "receipt:,
 * which is a String that lists the names and costs of individual itels that have been puchased, 
 * and the total of all costs for items on the receipt.
 * It's methods provide a way to enter and store the names and costs of the items purchased, 
 * as well as provide a report of each item and its cost and the recipt total.
 */
public class ReceiptGenerator{
   
   /* Instance variable declarations. */
   private String receipt;
   private double total;
   
      /* Constructor. Initializes the instance variables to default values. */
   public ReceiptGenerator() {
     //TODO 1: Initialize receipt to the empty string and total to 0.0. 
      receipt = "";
      total = 0.0;

   }

   
   /* This method adds the name and cost of an item to the receipt and the cost to the running total.
    * Parameters: name, cost.
    * For receipt, we want to add the name of the item, a colon (':'), a tab ('\t'), the cost, then a newline ('\n').
    *    Example: If name is "Shirt (Large)", cost is 19.50, and the receipt is empty, after adding
    *    the item receipt should hold the value "Shirt (Large):\t19.50\n" which, when printed,
    *    will look like "Shirt (Large):   19.50"
    */
   public void addNewItem(String name, double cost){
      //TODO 2: Update the instance variables using the 'name' and 'cost' parameters.
      receipt = receipt + name + ":\t" + cost +"\n";
      total = total + cost;
   }

  /*  This method returns the receipt you have so far. It returns a String representing
   *  the receipt. */
   public String getReceipt(){
      //TODO 3: Implement this method.
      return receipt;
   }
   
  /*  This method returns the running total. It returns a double representing
   *  the total price for the receipt. */
   public double getTotal(){
      //TODO 4: Implement this method.
      return total;
   }
   
   /* This method resets the instance variables to their default values. */
   public void reset(){
      receipt = "";
      total = 0.0;
      //TODO 5: Implement this method.
   }
}