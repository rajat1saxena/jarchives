/**
* Representative of Item 33: Use EnumMap instead of ordinal indexing.
*
* EnumMap basically helps in creating maps if mapping keys are strictly
* from enums.
*
* TODO: Understand the other example as well which is provided in this
* item.
*/
import java.util.Set;
import java.util.EnumMap;
import java.util.Map;
import java.util.HashSet;

final class Item33 {
	private static class Herb {
		private static enum Type {
			ANNUAL, PERENNIAL, BIENNIAL;
		}
	
		private final String name;
		private final Type type;

		public Herb(String name, Type type) {
			this.name = name;
			this.type = type;
		} 

		@Override public String toString() {
			return this.name + ":" + this.type;
		}
	}

	public static void main(String args[]){
		// Create a garden using many herbs;
		Set<Herb> garden = new HashSet<Herb>();
		garden.add(new Herb("Rishik", Herb.Type.ANNUAL));
		garden.add(new Herb("Hehe", Herb.Type.BIENNIAL));
		garden.add(new Herb("Rishik 2", Herb.Type.ANNUAL));
		garden.add(new Herb("Yong", Herb.Type.PERENNIAL));
		garden.add(new Herb("Figg", Herb.Type.BIENNIAL));
		garden.add(new Herb("Yik", Herb.Type.ANNUAL));
		garden.add(new Herb("Mitu", Herb.Type.PERENNIAL));

		// Organise herbs in a garden by Herb.Type
		Map<Herb.Type, Set<Herb>> gardenByHerbTypes =
			new EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);
		// Initialize the map
		for(Herb.Type t : Herb.Type.values()) 
			gardenByHerbTypes.put(t, new HashSet<Herb>());
		// Add herbs to individual types
		for(Herb h : garden) {
			gardenByHerbTypes.get(h.type).add(h);
		}

		// Print only PERENNIAL herbs
		for(Herb h : gardenByHerbTypes.get(Herb.Type.PERENNIAL))
			System.out.println(h); // toString() will be called automatically
   	}
}
