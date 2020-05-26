package ua.nure.filonitch.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {
	private Object[] arr = new Object[0];
	private int size;
	private int arsize;

	public ArrayImpl() {
		arr = new Object[arsize];
		size = 0;
	}

	public static void main(String[] args) {
		Array l = new ArrayImpl();
		l.add("A");
	}

	public class IteratorImpl implements Iterator<Object> {
		private int step;
		private int count;

		public boolean hasNext() {

			return ArrayImpl.this.size > step;

		}

		public Object next() {
			if (step > arr.length) {
				throw new NoSuchElementException();
			} else {
				return arr[step++];
			}
		}

		@Override
		public void remove() {
			count++;
			int n = step - 1;
			size--;
			if (step < count) {
				throw new IllegalStateException();

			} else if (step < arr.length) {
				arr[n] = arr[n + 1];
			}

		}
	}

	public void clear() {
		arr = new Object[arsize];
		size = 0;
	}

	public int size() {
		return this.size;
	}

	public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	public void add(Object element) {
		if (arr.length == size) {
			addSize();
			arr[size++] = element;
		}
	}

	public void addSize() {
		if (arr.length == size) {
			Object[] newArr = new Object[arr.length + 1];
			for (int i = 0; i < arr.length; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
	}

	public void set(int index, Object element) {
		arr[index] = element;
	}

	public Object get(int index) {
		return arr[index];
	}

	public int indexOf(Object element) {
		int ind = 0;
		for (int i = 0; i < size; i++) {
			if (arr[i] == element) {
				ind = i;
				break;
			} else if (i == size - 1) {
				ind = -1;
			}
		}
		return ind;
	}

	public void remove(int index) {
		size--;
		for (int i = index; i < size; i++) {
			arr[i] = arr[i + 1];
		}
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[");
		for (int i = 0; i < size; i++) {
			str.append(arr[i]);
			if (i != size - 1) {
				str.append(", ");
			}
		}
		str.append("]");

		return str.toString();
	}

}
