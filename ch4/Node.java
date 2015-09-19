package ch4;

class Node {
    private Node adjacent[];
    public int adjacentCount;
    private String vertex;
    public Node[] getAdjacent() {return adjacent;}
    public String getVertex() {return vertex;}
    final int ADJCOUNT = 40;
    
    public Node(String vertex, int adjacentLength) {
        this.vertex = vertex;                
        adjacentCount = 0;        
        adjacent = new Node[adjacentLength];
    }
    
    public void addAdjacent(Node x) {
        if (adjacentCount < ADJCOUNT) {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
            return;
        }
        System.out.print("Cannot add");
    }

}
