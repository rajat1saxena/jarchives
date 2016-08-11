/**
* This program demonstrates how to deserialize an object's state, stored
* in a file. This program is a reversal of an other program 
* BasicSerialization.
*/
package ser;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class BasicDeserialization {
	public static void main (String args[]) throws FileNotFoundException, 
			IOException {
		// Person's class bytecode needs to be accessible to this program
		Person me = null;

		FileInputStream underlyingStream = new FileInputStream(
					"./person.ser"
					);
		ObjectInputStream reader = new ObjectInputStream(underlyingStream);
		
		// read the person object in
		try{
			me = (Person) reader.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(me);		
	}
}
