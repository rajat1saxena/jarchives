public class tobinary{
	public static String findDigitsInBinary(int a) {
	    String output = "";
	    while(a>1){
	        // prefix remainder to output
	        output = (a % 2)+output;
          a = (int)(a / 2);
	    }
	    output = 1+output;
	    
	    return output;
	}
  
  public static void main(String args[]){
    System.out.println(findDigitsInBinary(6));
  }
}
