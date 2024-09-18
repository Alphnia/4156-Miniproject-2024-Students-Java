package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*--------------------------------------------------------- */

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;


/** 
 * This is the unit test class.
*/
@SpringBootTest
@ContextConfiguration
public class RouteControllerUnitTests {

  @BeforeAll
  public static void setupCourseForTesting() {
    testRouteController = new RouteController();
  }


  @Test
  public void indexTest() {
    testRouteController.index();
  }

  @Test
  public void retrieveDepartmentTest() {
    ResponseEntity<?> result = testRouteController.retrieveDepartment("COMS");
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    result = testRouteController.retrieveDepartment("ABCD");
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
  }
  
  @Test
  public void retrieveCourseTest() {
    ResponseEntity<?> result = testRouteController.retrieveCourse("COMS", 1004);
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    result = testRouteController.retrieveCourse("ABCD", 1004);
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    result = testRouteController.retrieveCourse("COMS", 1234);
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    
  }

  @Test
  public void retrieveCoursesTest() {
    ResponseEntity<?> result = testRouteController.retrieveCourses(1004);
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    result = testRouteController.retrieveCourses(4102);
    String[] times = {"11:40-12:55", "4:10-5:25", "10:10-11:25", "2:40-3:55"};
    Course ieor4102 = new Course("Antonius B Dieker", "209 HAM", times[2], 110);
    Course chem4102 = new Course("Dalibor Sames", "320 HAV", times[2], 28);
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    assertEquals(chem4102.toString()+'\n'+ieor4102.toString()+'\n', result.getBody().toString());
    result = testRouteController.retrieveCourses(1234);
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);

    result = testRouteController.retrieveCourses(1234565432);
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    
  }

  @Test
  public void isCourseFullTest() {
    ResponseEntity<?> result = testRouteController.isCourseFull("COMS", 1004);
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    result = testRouteController.isCourseFull("ABCD", 1004);
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    result = testRouteController.isCourseFull("COMS", 1234);
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    
  }

  @Test
  public void getMajorCtFromDeptTest() {
    ResponseEntity<?> result = testRouteController.getMajorCtFromDept("COMS");
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    result = testRouteController.getMajorCtFromDept("ABCD");
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
  }

  @Test
  public void identifyDeptChairTest() {
    ResponseEntity<?> result = testRouteController.identifyDeptChair("COMS");
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    result = testRouteController.identifyDeptChair("ABCD");
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
  }

  @Test
  public void findCourseLocationTest() {
    ResponseEntity<?> result = testRouteController.findCourseLocation("COMS", 1004);
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    result = testRouteController.findCourseLocation("ABCD", 1004);
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    result = testRouteController.findCourseLocation("COMS", 1234);
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
  }

  @Test
  public void findCourseInstructorTest() {
    ResponseEntity<?> result = testRouteController.findCourseInstructor("COMS", 1004);
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    result = testRouteController.findCourseInstructor("ABCD", 1004);
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    result = testRouteController.findCourseInstructor("COMS", 1234);
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
  }

  @Test
  public void findCourseTimeTest() {
    ResponseEntity<?> result = testRouteController.findCourseTime("COMS", 1004);
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    result = testRouteController.findCourseTime("ABCD", 1004);
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    result = testRouteController.findCourseTime("COMS", 1234);
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
  }

  @Test
  public void addMajorToDeptTest() {
    ResponseEntity<?> result = testRouteController.addMajorToDept("COMS");
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    result = testRouteController.addMajorToDept("ABCD");
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
  }

  @Test
  public void removeMajorFromDeptTest() {
    ResponseEntity<?> result = testRouteController.removeMajorFromDept("COMS");
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    result = testRouteController.removeMajorFromDept("ABCD");
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
  }

  @Test
  public void dropStudentTest() {
    ResponseEntity<?> result = testRouteController.dropStudent("COMS", 1004);
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    result = testRouteController.dropStudent("ABCD", 1004);
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    result = testRouteController.dropStudent("COMS", 1234);
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
  }

  @Test
  public void setEnrollmentCountTest() {
    ResponseEntity<?> result = testRouteController.setEnrollmentCount("COMS", 1004, 401);
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    result = testRouteController.setEnrollmentCount("ABCD", 1004, 401);
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    result = testRouteController.setEnrollmentCount("COMS", 1234, 401);
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
  }

  @Test
  public void changeCourseTimeTest() {
    ResponseEntity<?> result = testRouteController.changeCourseTime("COMS", 1004, "10:10-12:40");
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    result = testRouteController.changeCourseTime("ABCD", 1004, "10:10-12:40");
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    result = testRouteController.changeCourseTime("COMS", 1234, "10:10-12:40");
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    
  }
  
  @Test
  public void changeCourseTeacherTest() {
    ResponseEntity<?> result = testRouteController.changeCourseTeacher("COMS", 1004, "Dr. Ross");
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    result = testRouteController.changeCourseTeacher("ABCD", 1004, "Dr. Ross");
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    result = testRouteController.changeCourseTeacher("COMS", 1234, "Dr. Ross");
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
  }
  
  @Test
  public void changeCourseLocationTest() {
    ResponseEntity<?> result = testRouteController.changeCourseLocation("COMS", 1004, "111 Mudd");
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    result = testRouteController.changeCourseLocation("ABCD", 1004, "111 Mudd");
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    result = testRouteController.changeCourseLocation("COMS", 1234, "111 Mudd");
    assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
  }
  
  
  /** The test course instance used for testing. */
  public static RouteController testRouteController;
}

