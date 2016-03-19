/**
* This demonstrates how to out JSON array in string format
*/
import java.util.ArrayList;
import java.util.List;
import org.json.*;

// just another object class
class Person{
	String name;
	int age;

	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
}

class jsonToString{
	public static void main(String args[]){
		List<Person> persons = new ArrayList<>();

		for(int i=0;i<10;i++){
			persons.add(new Person("Person "+i,20+i));
		}

		// initialize JSON Array
		JSONArray jsonArray = Json.createArrayBuilder();

		// add items
		for(Person person:persons){
			jsonArray.add(Json.createObjectBuilder()
				.add("name",person.name)
				.add("age",person.age)
				);
		}

		// create JSON Array
		jsonArray.build();

		System.out.println(jsonArray.toString());
	}
}