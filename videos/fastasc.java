/**
* Example for https://vimeo.com/131394615
*/
import java.util.*;

class test{
	public static void main(String args[]){
		int a[] = new int[5];
		a[0] = 2;
		a[2] = 4;

		multiply(a);

		System.out.println(a);
	}

	// multiplies the array by 5
	public static multiply(int a[]) {
		for(int i=0;i<a.length;i++) {
			a[i] = a[i]*5;
		}
	}
}