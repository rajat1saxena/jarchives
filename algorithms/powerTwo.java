class powerTwo{
	public static void main(String args[]){
		int number = Integer.parseInt(args[0]);

		if((number & (number-1))==0){
			System.out.println(number+" is power of 2");
		}else{
			System.out.println(number+" is not power of 2");
		}
	}
}