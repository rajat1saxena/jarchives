enum Person{
  RAM (23,"SHARMA"),
  PUSHPA (19,"KUMARI"),
  PIYUSH (44,"SHASTRI");
  
  int age;
  String lastName;
  
  Person(int age,String lastName){
    this.age = age;
    this.lastName = lastName;
  }
  
  String getLastName(){
    return lastName;
  }
  
  int getAge(){
    return age;
  }
  
  public static void main(String args[]){
    System.out.println("RAM'S lastname: "+RAM.getLastName());
  }
}