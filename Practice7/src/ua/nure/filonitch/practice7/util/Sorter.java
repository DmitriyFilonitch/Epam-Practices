package ua.nure.filonitch.practice7.util;

import java.util.Collections;
import java.util.Comparator;
import ua.nure.filonitch.practice7.constants.Constants;
import ua.nure.filonitch.practice7.controller.DOMController;
import ua.nure.filonitch.practice7.entity.Card;
import ua.nure.filonitch.practice7.entity.Cards;

/**
 * Contains static methods for sorting.
 * 
 * @author D.Kolesnikov
 * 
 */
public class Sorter {

	// //////////////////////////////////////////////////////////
	// these are comparators
	// //////////////////////////////////////////////////////////

	/**
	 * Sorts questions by question text
	 */
	public static final Comparator<Card> SORT_CARDS_BY_THEMA = new Comparator<Card>() {
		@Override
		public int compare(Card o1, Card o2) {
			return o1.getThema().compareTo(o2.getThema());
		}
	};
	
	/**
	 * Sorts questions by answers number.
	 */
	public static final Comparator<Card> SORT_CARDS_BY_COUNTRY = new Comparator<Card>() {
		@Override
		public int compare(Card o1, Card o2) {
			return o1.getCountry().length() - o2.getCountry().length();
		}
	};

	/**
	 * Sorts answers.
	 */
	public static final Comparator<Card> SORT_CARDS_BY_YEAR = new Comparator<Card>() {
		@Override
		public int compare(Card o1, Card o2) {
			return o1.getYear().compareTo(o2.getYear());
		}
	};

	// //////////////////////////////////////////////////////////
	// these methods take Test object and sort it
	// with according comparator
	// //////////////////////////////////////////////////////////

	public static final void sortCardByThema(Cards cards) {
		Collections.sort(cards.getName(), SORT_CARDS_BY_THEMA);
	}

	public static final void sortCardByCountry(Cards cards) {
		Collections.sort(cards.getName(), SORT_CARDS_BY_COUNTRY);
	}

	public static final void sortCardByYear(Cards cards) {
		Collections.sort(cards.getName(), SORT_CARDS_BY_YEAR);
	}

	public static void main(String[] args) throws Exception {
		// Test.xml --> Test object
		DOMController domController = new DOMController(Constants.VALID_XML_FILE);
		domController.parse(false);
		Cards cards = domController.getCard();

		System.out.println("====================================");
		System.out.println(cards);
		System.out.println("====================================");

		System.out.println("====================================");
		Sorter.sortCardByThema(cards);
		System.out.println(cards);
		System.out.println("====================================");

		System.out.println("====================================");
		Sorter.sortCardByCountry(cards);
		System.out.println(cards);
		System.out.println("====================================");

		System.out.println("====================================");
		Sorter.sortCardByYear(cards);
		System.out.println(cards);
		System.out.println("====================================");

	}
}
