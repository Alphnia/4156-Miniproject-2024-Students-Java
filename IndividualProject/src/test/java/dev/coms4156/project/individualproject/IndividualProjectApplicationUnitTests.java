package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*--------------------------------------------------------- */

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


/** 
 * This is the unit test class.
*/
@SpringBootTest
@ContextConfiguration
public class IndividualProjectApplicationUnitTests {

  @BeforeAll
  public static void setupForTesting() {
    testApp = new IndividualProjectApplication();
    testApp2 = new IndividualProjectApplication();
  }

  @Test
  public void progressTest() {
    String[] args = new String[1];
    args[0] = "setup";
    testApp.run(args);
    args[0] = "";
    MyFileDatabase myFileDatabase = new MyFileDatabase(0, "./data.txt");
    testApp2.overrideDatabase(myFileDatabase);
    testApp.overrideDatabase(myFileDatabase);
  }

  /** The test course instance used for testing. */
  public static IndividualProjectApplication testApp;
  public static IndividualProjectApplication testApp2;
}

