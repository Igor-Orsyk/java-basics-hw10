import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExampleExceptionTest {

  /**
   * Test data for positive test.
   *
   * @return test data array
   */
  @DataProvider(name = "data")
  public static Object[][] data() {
    return new Object[][]{
        {2, 2, 4},
        {2, 3, 6},
            {5, 2, 10},
            {20, 20, 400},
    };
  }

  /**
   * Test data for exception test.
   *
   * @return test data array
   */
  @DataProvider(name = "negativeData")
  public static Object[][] negativeData() {
    return new Object[][]{
        {-2, 2},
        {2, -2},
            {-5, -2},
            {-225, -12},
    };
  }

  @Test(dataProvider = "data")
  public void testRectangleArea(int a, int b, int c) {
    assertEquals(ExampleException.rectangleArea(a, b), c);
  }


  @Test(dataProvider = "negativeData")
  public void testRectangleAreaNegative(int a, int b){
    try{
      ExampleException.rectangleArea(a, b);
      fail("Test failed, exception must be thrown");
    } catch (IllegalArgumentException exception){
      assertEquals(exception.getMessage(), "input value is below zero!");
    }
  }
}

