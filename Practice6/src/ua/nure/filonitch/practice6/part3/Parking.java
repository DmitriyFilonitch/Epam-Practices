package ua.nure.filonitch.practice6.part3;

import java.util.LinkedList;
import java.util.List;

public class Parking {

	private List<Integer> park;
    private int count;
	
	Parking(int count){
		this.count = count;
		park = new LinkedList<>();
		for (int k = 0; k < count; k++) {
			park.add(0);
        }
	}
	
	public void statusOfParking(){
		park = new LinkedList<>();
		for (int k = 0; k < count; k++) {
			park.add(0);
        }
	}
	
	public void print() {
		for(int k = 0; k < count; k++) {
			System.out.print(park.get(k));
		}
		System.out.println();
	}
	
	boolean arrive(int m) {
		if(m >= count) {
			throw new IllegalArgumentException();
		}
		int a = m;
		for(int t = 0; t < count * 10; t++) {
		if(a == count) {
			a = 0;
		}
		if(park.get(a) != 1) {
			park.set(a, 1);
			return true;
		}
		a++;
		if(a == m) {
			break;
		}
		}
		return false;
	}
    
	
	boolean depart(int k) {
		if(k >= count) {
			throw new IllegalArgumentException();
		}else if(park.get(k) == 1) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Parking parking = new Parking(10);
		parking.statusOfParking();
		parking.print();
		parking.arrive(1);
		parking.arrive(2);
		parking.print();
		parking.arrive(1);
		parking.print();
		parking.arrive(1);
		parking.print();
		System.out.println(parking.depart(1));
		System.out.println(parking.depart(6));
	}
	
}
