package ch3;

import java.util.LinkedList;

public class AnimalQueue {
	/**
	 *  Referred to the method on book 
	 *  Method: keep different queeu for different objects 
	 *  and pop , push according to the instnce type 
	 */
	/**
	 * Time : O(1)
	 * Space : O( N)
	 */
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;
	
    public int size(){return dogs.size() + cats.size();} 
	
	public Dog dequeueDogs() {return dogs.poll();}
	public Dog peekDogs() {return dogs.peek();}
	public Cat dequeueCats() {return cats.poll();}
	public Cat peekCats() {return cats.peek();}
	
	public void enqueue(Animal ani) {  // push according to type
		ani.setOrder(order);
		order++;
		if(ani instanceof Dog) {
			dogs.addLast((Dog) ani);
		}else if(ani instanceof Cat) {
			cats.addLast((Cat) ani);
		}
	}
	
	public Animal dequeueAny() { // dequeue according to type
		if(dogs.size() == 0) return dequeueCats();
		else if(cats.size() == 0) return dequeueDogs();
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		
		if(dog.isOlderThan(cat)) return dogs.poll();
		else return cats.poll();
	}
	
	public Animal peek() {  // get the first one according to type
		if(dogs.size() == 0) return cats.peek();
		else if(cats.size() == 0) return dogs.peek();
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		
		if(dog.isOlderThan(cat)) return dog;
		else return cat;
	}
	
	
}
