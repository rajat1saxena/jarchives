/*
* Program to demonstrate split() method
*/
class split{
	public static void main(String args[]){
		String fileName = "ThisLife.mp3";
		String[] fileNameToken = fileName.split("\\."); // split() method consider dot as a regular exp. 
		System.out.println(fileNameToken[0]);
	}
}
