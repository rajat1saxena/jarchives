/**
* Example for https://vimeo.com/131394615
*/
import java.util.*;

class fastasc{
	public static void main(String args[]){
		int a[] = new int[5];
		a[0] = 2;
		a[2] = 4;

		multiply(a);

		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}

	// multiplies the array by 5
	public static void multiply(int a[]) {
		for(int i=0;i<a.length;i++) {
			a[i] = a[i]*5;
		}
	}
}