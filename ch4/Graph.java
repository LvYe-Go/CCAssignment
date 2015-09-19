package ch4;

public class Graph {
	private Node vertices[];
	public int count;
	final int ADJCOUNT = 40; 
	final int NODECOUNT = 6; 
	public Node[] getNodes() {return vertices;}
	
	public Graph() {
		vertices = new Node[NODECOUNT];
		count = 0;
	}
	
	 public void addNode(Node x) {
         if (count < ADJCOUNT) {
             vertices[count] = x;
             count++;
         } else {
             System.out.print("Graph full");
         }
	}
}
