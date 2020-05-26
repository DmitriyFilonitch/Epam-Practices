package ua.nure.filonitch.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {
	private Object[] arr = new Object[0];
	private int size;
	private int arsize;

	public QueueImpl() {
		arr = new Object[arsize];
		size = 0;
	}

	public static void main(String[] args) {
		Queue l = new QueueImpl();
		l.enqueue("D");
		l.enqueue("I");
		l.enqueue("M");
		l.enqueue("A");
		System.out.println(l.toString());
	}

	public void clear() {
		arr = new Object[arsize];
		size = 0;
	}

	public int size() {
		return this.size;
	}

	public class IteratorImpl implements Iterator<Object> {
		private int count;
		private int step;

		public boolean hasNext() {

			return QueueImpl.this.size > step;

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

	public void addSize() {
		if (arr.length == size) {
			Object[] newArr = new Object[arr.length + 1];
			for (int i = 0; i < arr.length; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
	}

	public void enqueue(Object element) {
		if (arr.length <= size) {
			addSize();
			arr[size++] = element;
		} else {
			arr[size++] = element;
		}
	}

	public Object dequeue() {
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

	private Object get(int index) {
		return arr[index];
	}

	public Object top() {
		return get(0);
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
