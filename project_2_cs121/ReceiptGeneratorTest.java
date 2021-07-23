import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.*;


public class ReceiptGeneratorTest {

   ReceiptGenerator gen;

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      gen = new ReceiptGenerator();
   }


   /* Tests to make sure that the constructor is initializing the receipt variable correctly.
    * If you are seeing "PLACEHOLDER_STRING" as your actual value, you either aren't initializing 
    * it at all, or you changed the name of the variable */
   @Test public void constructorTest1(){
      String receipt = "PLACEHOLDER_STRING";
      try{
         /* Note that you do not need to understand how this test works. This is some
          * fancy stuff to get around the fact that these variables are private. You
          * should not try to do this outside of testing, as it defeats the purpose of
          * things being private */
         Field receiptField = ReceiptGenerator.class.getDeclaredField("receipt");
         receiptField.setAccessible(true);
         receipt = (String)receiptField.get(gen);
      } catch (Exception e){}
      //                   Message for the test                              Expected, Actual
      Assert.assertEquals("receipt is initialized correctly by constructor", ""      , receipt);
   }
   
   /* Tests to make sure that the constructor is initializing the total variable correctly.
    * If you are seeing -1 as your actual value, you either aren't initializing it at all,
    * or you changed the name of the variable */
   @Test public void constructorTest2(){
      double total = -1;
      try{
         /* Note that you do not need to understand how this test works. This is some
          * fancy stuff to get around the fact that these variables are private. You
          * should not try to do this outside of testing, as it defeats the purpose of
          * things being private */
         Field totalField = ReceiptGenerator.class.getDeclaredField("total");
         totalField.setAccessible(true);
         total = (double)totalField.get(gen);
      } catch (Exception e){}
      // Note that int assertions don't need an acceptable margin of error
      //                   Message for the test                            Expected, Actual, acceptable tolerance
      Assert.assertEquals("total is initialized correctly by constructor", 0       , total , 0.0);
   }
   
   /* Checks to make sure that getReceipt() returns the correct value after the ReceiptGenerator has been created */
   @Test public void getReceiptTest1(){
      Assert.assertEquals("getReceipt returns the correct value of the receipt after initialization", "", gen.getReceipt());
   }
   
   /* Checks to make sure that getTotal() returns the correct value after the ReceiptGenerator has been created */
   @Test public void getTotalTest1(){
      Assert.assertEquals("getTotal returns the correct value of the total after initialization", 0.0, gen.getTotal(), 0.0);
   }
   
   /* Checks to make sure that addNewItem() returns the correct total after it has been updated*/
   @Test public void addNewItemTest1(){
      gen.addNewItem("Shirt (small)", 19.43);
      double result = gen.getTotal();
      Assert.assertEquals("addNewItem() returns the correct total after it has been updated the first time", 19.43, result, 0.0);
   }
      
   /* Checks to make sure that addNewItem() returns the correct total after it has been updated repeatedly*/
   @Test public void addNewItemTest2(){
      gen.addNewItem("Shirt (small)", 19.43);
      gen.addNewItem("Caramel candy", 0.57);
      gen.addNewItem("U.S.S. Enterprise", 706000000000.0); // see https://en.wikipedia.org/wiki/Build_the_Enterprise
      double result = gen.getTotal();
      double expected = (19.43 + 0.57 + 706000000000.0);
      Assert.assertEquals("addNewItem returns the correct total after being updated multiple times", expected, result, 0.0001);
   }
   
   /* Checks to make sure that addNewItem() returns the correct total after it has been updated more complexly*/
   @Test public void addNewItemTest3(){
      gen.addNewItem("", 10.01);
      gen.addNewItem("discount", -3.4);
      gen.addNewItem("5.56", 3.3);
      double result = gen.getTotal();
      double expected = (10.01-3.4+3.3);
      Assert.assertEquals("addNewItem returns the correct total after it has been updated in more complex ways", expected, result, 0.0001);
   }
   
   /* Checks to make sure getReceipt continues to return correct receipt values after updates */
   @Test public void getReceiptTest2(){
      gen.addNewItem("Shirt (small)", 19.43);
      gen.addNewItem("Caramel candy", 0.57);
      String result = gen.getReceipt();
      String expected = "Shirt (small):\t19.43\nCaramel candy:\t0.57\n";
      Assert.assertEquals("getReceipt returns the correct receipt after it has been updated", expected, result);
   }
   
   /* Checks to make sure getTotal continues to return correct values after updates */
   @Test public void getTotalTest2(){
      gen.addNewItem("Shirt (small)", 19.43);
      gen.addNewItem("Caramel candy", 0.57);
      gen.addNewItem("GradSchool", 38000.0);
      double result = gen.getTotal();
      double expected = (19.43 + 0.57 + 38000.0);
      Assert.assertEquals("getCredits returns the correct number of total credits taken", expected, result, 0.0);
   }
   
   /* Checks to make sure reset() resets total correctly */
   @Test public void resetTest1(){
      gen.addNewItem("Shirt (small)", 19.43);
      gen.addNewItem("Caramel candy", 0.57);
      gen.addNewItem("GradSchool", 38000.0);
      gen.reset();
      double result = gen.getTotal();
      double expected = 0;
      Assert.assertEquals("reset correctly resets the total", expected, result, 0);
   }
   
   /* Checks to make sure reset() resets receipt correctly */
   @Test public void resetTest2(){
      gen.addNewItem("Shirt (small)", 19.43);
      gen.addNewItem("Caramel candy", 0.57);
      gen.addNewItem("GradSchool", 38000.0);
      gen.reset();
      String result = gen.getReceipt();
      String expected = "";
      Assert.assertEquals("reset correctly resets the receipt", expected, result);
   }

}
