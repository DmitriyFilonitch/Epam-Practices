package ua.nure.filonitch.practice7.constants;

/**
 * Holds entities declared in XSD document.
 * 
 * @author D.Kolesnikov
 *
 */

public enum XML {
	// elements names
	CARDS("Cards"), CARD("Card"), THEMA("Thema"), COUNTRY("Country"), YEAR("Year"), AUTHOR("Author"),
	VALUABLE("Valuable"), TYPE("Type"), TYPEOFCARD("TypeOfCard"), ISBEINGSENT("IsBeingSent");

	private String value;

	XML(String value) {
		this.value = value;
	}

	/**
	 * Determines if a name is equal to the string value wrapped by this enum
	 * element.<br/>
	 * If a SAX/StAX parser make all names of elements and attributes interned you
	 * can use
	 * 
	 * <pre>
	 * return value == name;
	 * </pre>
	 * 
	 * instead
	 * 
	 * <pre>
	 * return value.equals(name);
	 * </pre>
	 * 
	 * @param name string to compare with value.
	 * @return value.equals(name)
	 */
	public boolean equalsTo(String name) {
		return value.equals(name);
	}

	public String value() {
		return value;
	}
}
