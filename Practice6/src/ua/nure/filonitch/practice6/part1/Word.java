package ua.nure.filonitch.practice6.part1;

import java.io.Serializable;
import java.util.Comparator;

public class Word {

	private String name;
	private int frequency;

	Word(String value) {
		this.name = value;
		frequency = 1;
	}

	String getWord() {
		return name;
	}

	public void setWord(String value) {
		this.name = value;
	}

	int getFrequency() {
		return frequency; 
	}

	void setFrequency(int frequency) {
		this.frequency = frequency;
	}
 
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Word w = (Word) o;

		return frequency == w.frequency && name.equals(w.name);
	}
	@Override
	  public int hashCode() {
		return frequency;
	    
	  }
 
	static class CompareWord implements Comparator<Word>, Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public int compare(Word o1, Word o2) {
			return o1.getWord().compareTo(o2.getWord());
		}
	}

	static class CompareFrequency implements Comparator<Word>, Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public int compare(Word o, Word o1) {
			int comp = -o.getFrequency() + o1.getFrequency();
			if (comp == 0) {
				return new CompareWord().compare(o, o1);
			}
			return comp;
		}
	}
}