import java.text.DecimalFormat;

class decimalformat{
  static void customFormat(String pattern, double value){
    DecimalFormat decForm = new DecimalFormat(pattern);
    System.out.format("Output of %f:  %s%n",value,decForm.format(value));
  }
  public static void main(String args[]){
    customFormat("###,###.##",36000.46);
    customFormat("$###,###",36000.46);
    customFormat("$#",36000.46);
    // padding with 0
    customFormat("0000000000000.000000000000",36000.46);
  }
}