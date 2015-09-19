package ch4;

import java.util.*;

public class GraphOrder {
	public List<Project> nodes = new ArrayList<Project>();
	public HashMap<String, Project> map = new HashMap<String, Project>();
	public List<Project> getNodes() {return nodes;}
	
	// Find certain node by name 
	public Project getOrCreateNode(String name) {
		if (!map.containsKey(name)) {
			Project node = new Project(name);
			nodes.add(node);
			map.put(name, node);
		}
		return map.get(name);
	}
	
	// Add certain edge to the graph 
	public void addEdge(String startName, String endName) {
		Project start = getOrCreateNode(startName);
		Project end = getOrCreateNode(endName);
		start.addNeighbor(end);
	}
	// Create nodes and add edges 
	public static GraphOrder createGraph(String[] projects, String[][] depend) {
		GraphOrder graph = new GraphOrder();
		for (String project : projects) {
			graph.getOrCreateNode(project);
		}
		
		for (String[] dependency: depend) {
			String start = dependency[0]; // start
			String end = dependency[1]; // end 
			graph.addEdge(start, end);
		}
		return graph;
	}

}
