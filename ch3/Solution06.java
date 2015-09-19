package ch3;

public class Solution06 {

    /*Referred the method from Book 3.6 */
	
	// Push, Pop, Peek according to the type of the instance 
	//Time: O(1)
	//Space: O(N)
    public static void main(String[] args) {
            AnimalQueue animals = new AnimalQueue();
            animals.enqueue(new Cat("1"));
            animals.enqueue(new Cat("2"));
            animals.enqueue(new Dog("3"));
            animals.enqueue(new Dog("4"));
            
            System.out.println("Dequeue \n");        
            System.out.println(animals.dequeueAny().name());        
            System.out.println(animals.dequeueAny().name());              
            
            System.out.println("Enqueue finished\n");        
            animals.enqueue(new Dog("3"));
            animals.enqueue(new Cat("4"));
            
            System.out.println("Res \n");      
            while (animals.size() != 0) {
                    System.out.println(animals.dequeueAny().name());        
            }
    }
}
