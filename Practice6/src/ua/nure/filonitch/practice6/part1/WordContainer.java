package ua.nure.filonitch.practice6.part1;

/*import java.util.ArrayList;
//import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordContainer {

	private List<Word> arr = new ArrayList<Word>();

	public List<Word> getArr() {
		return arr;
	}

	public void add(Word word) {
		for (Word w : arr) {
			if (w.getWord().equals(word.getWord())) {
				w.setFrequency(w.getFrequency() + 1);
				return;
			}
		}
		arr.add(word);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		Map<String, Integer> wordToCount = new TreeMap<>();
		for (String word : text.split(" ")) 
		{
		    wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
		}
		System.out.println(wordToCount);
		scanner.close();
	}
}*/
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class WordContainer extends TreeSet<Word> {

	private static final long serialVersionUID = 1L;

	public WordContainer(Comparator<? super Word> comparator) {
		super(comparator);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		WordContainer wc = new WordContainer(new Word.CompareWord());
		while (scanner.hasNext()) {
			String w = scanner.next();
			if ("stop".equals(w)) {
				scanner.close();
				break;
			}
			wc.add(new Word(w));
		}

		Iterator<Word> iterator = wc.frequencyIterator();
		while (iterator.hasNext()) {
			Word w = iterator.next();
			System.out.println(w.getWord() + " : " + w.getFrequency());
		}
	}

	@Override
	public boolean add(Word wrd) {
		if (!contains(wrd)) {
			super.add(wrd);
			return false;
		}
		Iterator<Word> iterator = iterator();
		while (iterator.hasNext()) {
			Word nextWord = iterator.next();
			if (comparator().compare(nextWord, wrd) == 0) {
				nextWord.setFrequency(nextWord.getFrequency() + 1);
				return true;
			}
		}
		return false;
	}

	public Iterator<Word> frequencyIterator() {
		TreeSet<Word> someWords = new TreeSet<>(new Word.CompareFrequency());
		for (Iterator<Word> itr = iterator(); itr.hasNext();) {
			Word next = itr.next();
			someWords.add(next);
		}
		return someWords.iterator();
	}
}
