class substring{
  public static void main(String args[]){
    // split over " "
    try{
      String input = args[0];
      String part1 = input.substring(0,input.indexOf(" ")); // " " will be exclusive
      String part2 = input.substring(input.indexOf(" ")+1); // everything after " "
      System.out.println(part2+" "+part1);
    }catch(ArrayIndexOutOfBoundsException a){
      System.out.println("Provide an argument");
    }
    catch(Exception e){
      System.out.println("\" \" is not found");
    }
  }
}