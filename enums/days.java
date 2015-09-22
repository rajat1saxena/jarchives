enum Day{
  SUNDAY,monday,TUESday,wednesday,THURSDAY,FRIDAY,SATURDAY
}

public class days{
  Day day;
  
  public days(Day day){
    this.day = day;
  }
  
  public static void main(String args[]){
    days thisOne = new days(Day.TUESday);
    System.out.println("Day is: "+thisOne.day);
    
    //iterate over enums
    for(Day d : Day.values()){
      System.out.println("Value is: "+d);
    }
  }
}