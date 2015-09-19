package ch3;


public class Stack {
	   // Some part has referred the book on this class
        private int capacity;
        public Node top;
        public Node bottom;
        public int size = 0;
        
        public Stack(int capacity) { this.capacity = capacity; }
        public boolean isFull() {  return capacity == size; }
        public boolean isEmpty() { return size == 0; }
        
        public void join(Node above, Node below) { // combine the two stack 
            if (below != null) below.above = above;
            if (above != null) above.below = below;
        }
        
        public boolean push(int v) {
            if (size >= capacity) return false;
            size++;
            Node n = new Node(v);
            if (size == 1) bottom = n; // if just has onlly one element 
            join(n, top);  
            top = n;
            return true;
        }
        
        public int pop() {
            Node t = top;
            top = top.below;
            size--; // update the count 
            return t.value;
        }
        
        public int removeBottom() {
            Node b = bottom;
            bottom = bottom.above;
            if (bottom != null) 
            	bottom.below = null;
            size--;
            return b.value;
        }
}