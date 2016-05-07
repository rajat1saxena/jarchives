package topcoder;

/*
* Url: https://community.topcoder.com/stat?c=problem_statement&pm=2998&rd=5857
*/
import java.util.*;
import java.io.*;

class Node{
	int x,y;
	boolean fill;

	public Node(int x, int y){
		this.x = x;
		this.y = y;
		this.fill = false;
	}
}

public class grafixMask{
	private final static int WIDTH = 600;
	private final static int HEIGHT = 400;
	private static Node[][] node;
	private final static BufferedReader reader;
	private final static BufferedWriter writer;

	static{
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
		// init bitmap
		node = new Node[WIDTH][HEIGHT];
		for(int i=0;i<WIDTH;i++){
			for(int j=0;j<HEIGHT;j++){
				// set fill to false
				node[i][j] = new Node(i,j);
			}
		}
	}

	public static int[] sortedAreas(String[] rectangles){

		// do the breath first search to fill the connected area
		Stack<Node> stack = new Stack<Node>();
		stack.push(node[0][0]);

		while(stack.empty()==false){
			//pop the element
			Node n = stack.pop();

			// check that node is not visited before
			
		}

		return new int[1];
	}

	public static void main(String args[]) throws IOException{
		// Get total line numbers
		System.out.println("Enter number of lines:");
		int lines;
		try{
			lines = Integer.parseInt(reader.readLine());
			String[] rectangles = new String[lines];
			for(int i=0;i<lines;i++){
				rectangles[i] = reader.readLine();
			}

			// call sortedAreas
			int[] areas = sortedAreas(rectangles);
		}catch(Exception e){
			System.out.println("Invalid number");
		}

	}
}