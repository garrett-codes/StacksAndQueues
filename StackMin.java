/*
have to 
*/

import java.util.*;

public class StackMin {

	// min property and array property
	private int min;
	private ArrayList<Integer> arr = new ArrayList<>();

	public StackMin(int value) {
		this.min = value;
		this.arr.add(value);
	}

	//push method
	public void push(int value) {
		this.arr.add(value);
		if (value < this.min) this.min = value;
	}

	// pop method for taking things off 
	public int pop() {
		if (this.arr.size() == 0) return -1;
		int popped = this.arr.remove(this.arr.size() - 1);
		if (popped == this.min) {
			this.min = searchForMin();
		}
		return popped;
	}

	private int searchForMin() {
		int smallest = Integer.MAX_VALUE;
		for (int curr : this.arr) {
			if (curr < smallest) {
				smallest = curr;
			}
		}
		return smallest;
	}


	public static void main(String[] args) {

	}
}