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
public class MyFileDatabaseUnitTests {

  @BeforeAll
  public static void setupFileDatabaseForTesting() {
    testFileDatabase = new MyFileDatabase(0, "./data.txt");
    testFileDatabase2 = new MyFileDatabase(1, "./data.txt");
  }


  @Test
  public void toStringTest() {
    testFileDatabase.toString();
  }

  /** The test course instance used for testing. */
  public static MyFileDatabase testFileDatabase;

  public static MyFileDatabase testFileDatabase2;
}

