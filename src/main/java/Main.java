import base.BaseTypesUtilImpl;

import java.math.BigDecimal;

public class Main{
  public static void main(String[] args) {
    BaseTypesUtilImpl mainInstance = new BaseTypesUtilImpl();

    String decimal = "120658.345";
    String scientific = "1.34E5";

    System.out.println("\nToggle:");
    String sci = mainInstance.toggleScientificNotation(decimal);
    System.out.println(decimal + " => " + sci);
    String dec = mainInstance.toggleScientificNotation(scientific);
    System.out.println(scientific + " => " + dec);

    System.out.println("\nSort:");
    int[] listOfNumbers = {2, 6, 1, 4, 3, 5};
    mainInstance.print(listOfNumbers);

    listOfNumbers = mainInstance.sort(listOfNumbers);
    mainInstance.print(listOfNumbers);

    System.out.println("\nMean:");
    float mean = mainInstance.arithmeticMean(listOfNumbers);
    System.out.println("Mean = " + mean);

    System.out.println("\nFormat:");
    System.out.println(mainInstance.format(12345.6789, "de"));
    System.out.println(mainInstance.format(12345.23, "en"));

    System.out.println("\nPlus:");
    String plus = mainInstance.plus("1.000000000000000000000000000000000000001", "5");
    System.out.println(plus);

    System.out.println("\nMinus:");
    String minus = mainInstance.minus("10.00000000000000000000000123", "15.0");
    System.out.println(minus);

    System.out.println("\nMultiply:");
    String mul = mainInstance.mul("11", "6");
    System.out.println(mul);

    System.out.println("\nDivide:");
    String division = mainInstance.div("100", "10");
    System.out.println(division);
  }
}
