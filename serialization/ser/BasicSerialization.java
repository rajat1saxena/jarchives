/**
* This program demonstrates how to write an object's state to a file.
*
* This program will throw 'NotSerializableException' due to Address class
* not being a serializable class (it does not implement Serializable inter-
* face).
*/
package ser;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

class BasicSerialization {
	/* 
	 * Writes(Serializes) object information to a file
	 * Customized writeObject method for serialization.
	*/
	private static void writeObject (ObjectOutputStream os, Person p) throws
		IOException {
		// Write individual bits to the file
		os.writeObject(p.getName());
		os.writeInt(p.getAge());
		os.writeObject(p.getAddress());
	}

	// Driver method
	public static void main (String args[]) throws IOException,
		FileNotFoundException {
		FileOutputStream underlyingStream = new FileOutputStream("./person.ser");
		ObjectOutputStream serializer = new ObjectOutputStream(underlyingStream);
		// Uncomment below line for default serialization behaviour
		// serializer.writeObject(new Person("Rajat", "56-a mathura", 28));

		// Serialize the object using customized writeObject
		writeObject(serializer, new Person("Rajat", 
								new Address("34-t mathura"), 
								28)
		);
	}
}
