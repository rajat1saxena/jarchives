// Skeletal implementation or AbstractInterface
// A demonstration

/**
* This interface provides essential methods for operating any phone
*/

interface Phone{
	void call(String number);
	void sms(String number);
	boolean sendLocation();
	boolean sendPhoto();
}

/**
* This class provides a skeletal implementation of Phone interface to minimize
* effort required to implement this interface backed by generic logging in case
* of a call or text
*/
abstract class AbstractPhone implements Phone{
	/**
	 * Logs calling details to the Phone log.
	 *
	 * Phone manufacturers should override this method to include their 
	 * company's branding. A generic output will be produced otherwise.
	 */
	@Override public void call(String number) {
		System.out.println("Calling " + number);
	}

	/**
	 * Logs sms details to the Phone log.
	 */
	// we don't want overrides to override this method
	@Override public final void sms(String number) { 
		System.out.println("Sending text to " + number);
	}

	// other two method implementations are left to the subclass
}

/**
* Concrete implementation of AbstractPhone abstract class for Motorola phones.
*/
// We don't want someone to create a subclass of this class, so we marked it 
// 'final'
final class MotorolaPhone extends AbstractPhone {
	@Override public void call(String number) {
		System.out.println("Motorola call: " + number);
	}

	@Override public boolean sendPhoto() {
		System.out.println("Motorola photo sent");
		return true;
	}

	@Override public boolean sendLocation() {
		System.out.println("Motorola location sent");
		return true;
	}
}

class item18 {
	public static void main(String[] args) {
		// We will create an anonymous concrete implementation of AbstractPhone
		// for Samsung phones
		Phone samsung = new AbstractPhone() {
			@Override public void call(String number) {
				System.out.println("Samsung call: " + number);
			}

			@Override public boolean sendPhoto() {
				System.out.println("Samsung photo sent");
				return true;
			}

			@Override public boolean sendLocation() {
				System.out.println("Samsung location sent");
				return true;
			}
		};

		// use a samsung phone
		samsung.call("+91-80000000");
		samsung.sendLocation();
	}
}