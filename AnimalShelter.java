/*
first-in, first-out animal shelter
can either adopt the "youngest" or specify whether they want a dog/cat and recieve
the youngest of that type
very primitive skeleton that just takes age in as cat or dog
*/

public class AnimalShelter {

	// two stacks one dog and one cat
	private SortStack dogs = new SortStack();
	private SortStack cats = new SortStack();

	// pops off oldest either cat or dog
	public void push(String type, int age) {
		if (type.toLowerCase().equals("cat")) {
			cats.push(age);
		}
		else if (type.toLowerCase().equals("dog")){
			dogs.push(age);
		}
		else {
			return;
		}
	}


	// pops whichever stack has the youngest
	public int pop() {
		// pops nothing if both empty
		if (dogs.isEmpty() && cats.isEmpty()) {
			return -1;
		}
		// pops the cat if dog is empty
		if (dogs.isEmpty()) {
			return cats.pop();
		}
		//pops the dog if cat is empty
		else if (cats.isEmpty()){
			return dogs.pop();
		}
		// compares the youngest to pop of cats and dogs if both empty
		else if (cats.peek() < dogs.peek()) {
			return cats.pop();
		}
		else return dogs.pop();
	}

	// pops based on what is specified
	public int pop(String type) {
		if (type.toLowerCase().equals("cat")) {
			return cats.pop();
		}
		else if (type.toLowerCase().equals("dog")){
			return dogs.pop();
		}
		else {
			return -1;
		}
	}



	public static void main(String[] args) {
		AnimalShelter shelter = new AnimalShelter();
		shelter.push("DOG", 10);
		shelter.push("CAT", 15);
		shelter.push("DOG", 7);
		shelter.push("CAT", 5);
		shelter.push("BUNNY", 2);
		System.out.println("dogs: " + shelter.dogs);
		System.out.println("cats: " + shelter.cats);
		shelter.pop("CAT");
		shelter.pop("CAT");
		System.out.println(shelter.pop());
		System.out.println("dogs: " + shelter.dogs);
		System.out.println("cats: " + shelter.cats);
	}
}