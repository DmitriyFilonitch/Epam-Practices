package ua.nure.filonitch.practice6.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {

	private int k;
	private int l;
	private boolean reverse;

	Range(int k, int l) {
		this(k, l, false);
	}

	Range(int m, int n, boolean reverse) {
		this.reverse = !reverse;
		this.k = m;
		this.l = n;
	}

	public void output() {
		Iterator<Integer> itr = iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next());
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		if (reverse) {
			return new RangeIteratorReverse();
		}
		return new RangeIterator();
	}

	private class RangeIteratorReverse implements Iterator<Integer> {
		private int pntr;

		RangeIteratorReverse() {
			pntr = k - 1;
		}

		@Override
		public boolean hasNext() {
			return pntr < l;
		}

		@Override
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return ++pntr;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class RangeIterator implements Iterator<Integer> {
		private int pntr;

		RangeIterator() {
			pntr = l + 1;
		}

		@Override
		public boolean hasNext() {
			return pntr > k;
		}

		@Override
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return --pntr;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}