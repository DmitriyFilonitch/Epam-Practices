package ua.nure.filonitch.practice7.entity;

/**
 * Implements the Question entity.
 * 
 * @author D.Kolesnikov
 * 
 */

public class Card extends Cards {

	private String thema;

	public String getThema() {
		return thema;
	}

	public void setThema(String thema) {
		this.thema = thema;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getValuable() {
		return valuable;
	}

	public void setValuable(String valuable) {
		this.valuable = valuable;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeofcard() {
		return typeofcard;
	}

	public void setTypeofcard(String typeofcard) {
		this.typeofcard = typeofcard;
	}

	public String getIsbeingsent() {
		return isbeingsent;
	}

	public void setIsbeingsent(String isbeingsent) {
		this.isbeingsent = isbeingsent;
	}

	private String country;
	private String year;
	private String author;
	private String valuable;
	private String type;
	private String typeofcard;
	private String isbeingsent;

	public String toString() {
		return thema + System.lineSeparator() + country + System.lineSeparator() + year + System.lineSeparator()
				+ author + System.lineSeparator() + valuable + System.lineSeparator() + type + System.lineSeparator()
				+ typeofcard + System.lineSeparator() + isbeingsent + System.lineSeparator();
	}

}
