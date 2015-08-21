import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

class employee{
  private Integer age;
  private String name;
  private String dept;
  
  public employee(String name,Integer age,String dept){
    this.name = name;
    this.age = age;
    this.dept = dept;
  }
  
  public  String getName(){
    return this.name;
  }
  public  Integer getAge(){
    return this.age;
  }
  public  String getDept(){
    return this.dept;
  }
  
//   public void setName(String name){
//     this.name = name;
//   }
  
//   public void setAge(Integer age){
//     this.age = age;
//   }
}
class map{
  public static void main(String args[]){
//     List<employee> employees = new ArrayList<employee>();
//     employees.add(new employee("Rajat",27));
//     employees.add(new employee("Ram",78));
//     employees.add(new employee("Purohit",65));
//     employees.add(new employee("Ravi",21));
//     Map<String, List<employee>> sum = employees.stream().collect(Collectors.groupingBy(employee::getDept,Collectors.summingInt(employee::getAge)));
    
      Map<String, Integer> m = new TreeMap<String, Integer>();
    
      // initialise Hashmap from command line arguments
      for(String a:args){
        Integer freq = m.get(a);
        m.put(a, (freq==null)? 1 : freq+1);
      }
    
      for(String k:m.keySet()){
        System.out.println(k);
      }
    
      for(Integer k:m.values()){
        System.out.println(k);
      }
    
      System.out.println("Distinct elements: "+m.size());
      System.out.println(m);
  }
}