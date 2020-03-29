public class ExampleException {
  public static int rectangleArea(int a, int b) {
    if ((a | b) < 0){
      throw new IllegalArgumentException("input value is below zero!");
    } else {return a * b;}
  }
}


