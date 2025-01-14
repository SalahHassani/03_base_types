package base;

import com.nix.jtc.basetypes.BaseTypesUtil;

import java.math.BigDecimal;
import java.text.*;
import java.util.Arrays;
import java.util.Locale;

public class BaseTypesUtilImpl implements BaseTypesUtil {
  @Override
  public String toggleScientificNotation(String s) {

    if (s == null || s.isEmpty()) {
      return "";
    }

    int findE = s.toUpperCase().indexOf('E');
    if(findE == -1) {
      double dec = Double.parseDouble(s);
      DecimalFormat decimalFormat = new DecimalFormat("0.################E0");
      return decimalFormat.format(dec);
    }
    else {
      double dec = Double.parseDouble(s);
      return "" + dec;
    }
  }

  @Override
  public int[] sort(int[] ints) {
    if (ints == null) {
      return null;
    }
    int[] copiedArray = Arrays.copyOf(ints, ints.length);
    Arrays.sort(copiedArray);
    return copiedArray;
  }

  @Override
  public float arithmeticMean(int[] ints) {
    int sum = 0;
    if (ints == null || ints.length == 0) {
      return Float.NaN;
    }

    for(int num : ints){
      sum += num;
    }
    return (float) sum / ints.length;
  }

  @Override
  public String format(double v, String s) {
    Locale locale = new Locale(s);
    NumberFormat formatter = NumberFormat.getInstance(locale);
    return formatter.format(v);
  }

  @Override
  public String plus(String s, String s1) {
    return executeMathOperation(s, s1, "+");
  }

  @Override
  public String minus(String s, String s1) {
    return executeMathOperation(s, s1, "-");
  }

  @Override
  public String mul(String s, String s1) {
    return executeMathOperation(s, s1, "*");
  }

  @Override
  public String div(String s, String s1) {
    return executeMathOperation(s, s1, "/");
  }

  public void print(int[] ints) {
    for(int num : ints) {
      System.out.print(num + "\t");
    }
    System.out.println();
  }

  private String executeMathOperation(String s, String s1, String sign) {
    BigDecimal bigDecimal1 = new BigDecimal(s);
    BigDecimal bigDecimal2 = new BigDecimal(s1);

    switch (sign) {
      case "+":
        return bigDecimal1.add(bigDecimal2).toString();
      case "-":
        return bigDecimal1.subtract(bigDecimal2).toString();
      case "*":
        return bigDecimal1.multiply(bigDecimal2).toString();
      case "/":
        if(bigDecimal2.equals(BigDecimal.ZERO)) {
          return "Infinity";
        }
        return bigDecimal1.divide(bigDecimal2).toString();
      default:
        throw new RuntimeException("Invalid sign: " + sign);
    }
  }
}
