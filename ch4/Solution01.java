package ch4;

import java.util.HashSet;
import java.util.LinkedList;


 /**
  * 
  * @author jingyu
  * Given a directed graph, design an alogrithm to find out whether
  * there is a route between two nodes 
  *
  */// Created Test case  
   //  My method:  Create the graph and search from one of the node using BFS , if cna counter 
   // 				another node 
   //  Time : O(N) [Iterate all nodes]
   //  Space: O(N*N) Using matrix to restore 
 
   
public class Solution01 {

	  public static void main(String[] args)
      {
		      // Create the graph. 
              Graph g = createNewGraph();
              
              // Put the start and end point 
              Node[] n = g.getNodes();
              Node start = n[2];
              Node end = n[5];
              
              // Print out the graph
              System.out.println(bfs(g, start, end));
      }
      
      public static Graph createNewGraph()
      {
              Graph g = new Graph();        
              Node[] temp = new Node[6];
              
             // Create the nodes for the graph 
              temp[0] = new Node("a", 3);
              temp[1] = new Node("b", 6);
              temp[2] = new Node("c", 0);
              temp[3] = new Node("d", 1);
              temp[4] = new Node("e", 1);
              temp[5] = new Node("f", 0);
              
            // Add to the edges
              temp[0].addAdjacent(temp[1]);
              temp[0].addAdjacent(temp[2]);
              temp[0].addAdjacent(temp[3]);
              temp[3].addAdjacent(temp[4]);
              temp[4].addAdjacent(temp[5]);
              
              for (int i = 0; i < 6; i++) {
                      g.addNode(temp[i]);
              }
              return g;
      }
      
      public static boolean bfs(Graph g, Node start, Node end) {
	      LinkedList<Node> queue = new LinkedList<Node>(); // Using queue to store the nodes 
	      HashSet<Node> set = new HashSet<Node>(); // Usign set to restore the nodes has 
	      // been visted or not 
	      
	      queue.add(start);  // Put the first node in 
	      
	      while(!queue.isEmpty()) {
	    	  Node cur = queue.poll();   // Pop up the first one 
	            if (cur != null) { 
	                    for (Node v : cur.getAdjacent()) { // Iterate the child 
	                        if (!set.contains(v)) {
	                            if (v == end) {
	                                return true;
	                            } else {
	                                set.add(v);  // Mark it as visted
	                                queue.add(v);
	                            }
	                        }
	                    }
	                    set.remove(cur); // If not found, traceback 
	            }
	        }
	        return false;
	      }
     }
