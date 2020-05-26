package ua.nure.filonitch.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {

	private int size;
	private int arrSize;
	private Object[] arr = new Object[arrSize];

	public static void main(String[] args) {
		Stack s = new StackImpl();
		s.push("A");
		s.push("B");
		s.push("C");
		System.out.println(s.toString());
	}

	public class IteratorImpl implements Iterator<Object> {
		private int count;
		private int step;

		public boolean hasNext() {

			return StackImpl.this.size > step;

		}

		@Override
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

	public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	public void clear() {
		arr = new Object[arrSize];
		size = 0;

	}

	public int size() {

		return this.size;
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

	public void push(Object element) {
		Object[] newArr = new Object[size + 1];
		newArr[0] = element;
		for (int i = 0, j = 1; i < size; i++, j++) {
			newArr[j] = arr[i];
		}
		addSize();
		arr = newArr;
		size++;
	}

	public Object pop() {
		Object top = get(0);
		removeByIndex(0);
		return top;
	}

	private void removeByIndex(int index) {
		size--;
		for (int i = index; i < size; i++) {
			arr[i] = arr[i + 1];
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		for (int i = size - 1; i >= 0; i--) {
			sb.append(arr[i]);
			if (i != 0) {
				sb.append(",");
				sb.append(" ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public Object top() {
		return get(0);
	}

	private Object get(int index) {
		return arr[index];
	}

}
