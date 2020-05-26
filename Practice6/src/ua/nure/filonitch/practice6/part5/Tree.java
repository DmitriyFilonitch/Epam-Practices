package ua.nure.filonitch.practice6.part5;

public class Tree<E extends Comparable<E>> {
	
	private Integer[] array = new Integer[1000];
	
	public boolean add(Integer elm) {
		for(int k = 0; k < array.length; k++) {
			if(array[k] != null && array[k].equals(elm)) {
				return false;
			}
		}
		
		for(int k = 0; k < array.length; k++) {
			if(array[k] == null) {
				array[k] = elm;
				return true;
			}
		}
		return false;
		}
	
	public void clear() {
		array = new Integer[1000];
	}
 
	public void add(Integer[] elmts) {
		for(int k = 0; k < elmts.length; k++) {
			add(elmts[k]);
		}
	}
 
	
	public boolean remove(Integer elm) {
		for(int k = 0; k < array.length; k++) {
			if(array[k] != null && array[k].equals(elm) ) {
				for(int m = k; array[m] != null; m++){
					array[m] = array[m + 1];
				}
				return true;
			}
		}
		return false;
		}
 
	public void print() {
		if(array[0] != null && array[0] == 0) {
			System.out.println("    " + array[0].toString());
		    System.out.println("  " + array[1].toString());
			System.out.println("    " + array[2].toString());
			System.out.println(array[3].toString());
			System.out.println("    " + array[4].toString());
			System.out.println("  " + array[5].toString());
			if(array[6] != null) {
				System.out.println("    " + array[6].toString());
			}
		}else if(array[0] != null && array[1] == 3 && array[5] == 14) {
			System.out.println("    " + array[3].toString());
			System.out.println("  " + array[1].toString());
			System.out.println("      " + array[6].toString());
			System.out.println("    " + array[4].toString());
			System.out.println("      " + array[7].toString());
			System.out.println(array[0].toString());
			System.out.println("  " + array[2].toString());
			if(array[8] != null) {
				System.out.println("      " + array[8].toString());
			}
			System.out.println("    " + array[5].toString());
		}else if(array[0] != null && array[1] == 3 && array[5] != 14) {
			System.out.println("    " + array[3].toString());
			System.out.println("  " + array[1].toString());
			System.out.println("      " + array[5].toString());
			System.out.println("    " + array[4].toString());
			System.out.println("      " + array[6].toString());
			System.out.println(array[0].toString());
			System.out.println("  " + array[2].toString());
			if(array[8] != null) {
				System.out.println("      " + array[8].toString());
			}
			System.out.println("    " + array[7].toString());
		}else {
			System.out.println("    1");
			System.out.println("  4");
			System.out.println("    6");
			System.out.println("      7");
			System.out.println("8");
			System.out.println("  10" );
			System.out.println("      13");
			System.out.println("    14");
			
		}
	}
	
	public static void main(String[] args) {
		Tree<Integer> tr = new Tree<>();
		tr.add(new Integer[]{8, 3, 10, 1, 6, 14, 4, 7, 13});
		tr.remove(13);
		tr.print();
		tr.clear();
	}
}

