/**
* Address
*
* This represent a valid address. Note that this class is not serializable.
*/
package ser;

final class Address {
	private String name;

	public Address(String name) { this.name = name; }
	
	// accessor
	public String getName() { return this.name; }

	@Override public String toString() { return this.name; }
}
