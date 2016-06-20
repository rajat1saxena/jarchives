/**
* Representative of Item 31: Use instance fields instead of ordinals.
*/
final class Item31 {
	/**
	* Inner enum to present musical notes. 
	*/
	private static enum Ensemble {
		SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
		SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
		NONET(9), DECTET(10), TRIPLE_QUARTET(12);
		
		// instance field to represent number of musicians.
		private final int numberOfMusicians;
		
		// Constructor
		Ensemble(int numberOfMusicians) { 
			this.numberOfMusicians = numberOfMusicians;
		}
		
		/**
		* Returns number of musicians in an ensemble.
		* @return number of musicians in an ensemble.
		*/
		public int numberOfMusicians() { return this.numberOfMusicians; }
	}

	public static void main(String args[]) {
		// Print number of musicians in each ensemble
		for(Ensemble en: Ensemble.values()) {
			System.out.printf("%d musicians in a %s%n",
				en.numberOfMusicians(), en.name()
			);
		}
	}
}
