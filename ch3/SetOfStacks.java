package ch3;

import java.util.*;

/* *
 * Referred the method form Book 3.3 
 * Mathod:  When Pop from one stack , we need to move the element from current Stack
 * to the end
 * */

	// Time : operating like general stack
	// Sapce: O(N)
    public class SetOfStacks {
	    List<Stack> stacks = new ArrayList<Stack>();
	    public int capacity;
	    
	    public void push(int v) {
	        Stack lastStack = getlastStack();
	        if (lastStack != null && !lastStack.isFull()) { // add to lastStack
	                lastStack.push(v);
	        } else { // must create new stack
	            Stack stack = new Stack(capacity);  
	            stack.push(v);
	            stacks.add(stack);
	        }
	    }
	    
	    public int pop() {
	        Stack lastStack = getlastStack();
	        int v = lastStack.pop();  // pop from the last one 
	        if (lastStack.size == 0) 
	        	stacks.remove(stacks.size() - 1); // remove the lastStack one 
	        return v;
	    }
	    
	    public int popAt(int index) {
	         return leftShift(index, true); // move the following elements to left 
	    }
	    
	    public int leftShift(int index, boolean removeTop) {
	            Stack stack = stacks.get(index);
	            int nodes;
	            if (removeTop) nodes = stack.pop();
	            else nodes = stack.removeBottom();
	            if (stack.isEmpty()) { 
	                stacks.remove(index);
	            } else if (stacks.size() > index + 1) {
	                int v = leftShift(index + 1, false); // move to left from index + 1
	                stack.push(v);
	            }
	            return nodes;
	    }
	    
	    public boolean isEmpty() {
	            Stack lastStack = getlastStack();  // check whether the lastStack is empty or not 
	            return lastStack == null || lastStack.isEmpty();
	    }
	    
	    public SetOfStacks(int capacity) { this.capacity = capacity; } // set the capacity 
	    
	    public Stack getlastStack() { // get the last Stack 
	        if (stacks.size() == 0) return null; // corner case 
	        return stacks.get(stacks.size() - 1);
	    }
	    
}