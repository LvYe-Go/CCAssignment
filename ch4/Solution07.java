package ch4;

import java.util.List;
import java.util.Stack;

public class Solution07 {
	// Change the problem to directed graph
	// We iterate to find the start which can go through the all nodes 
	// Time O (P + D)  P => projects , D => depend 
	public static boolean search(Project project, Stack<Project> stack) {
		
		if (project.getState() == Project.State.PARTIAL) {
			return false; 
		}
		
		if (project.getState() == Project.State.BLANK) { // If the node has not been visited 
			project.setState(Project.State.PARTIAL);
			List<Project> children = project.getChildren(); // Get the child nodes 
			for (Project child : children) { // Iterate 
				if (!search(child, stack)) {
					return false;
				}
			}
			project.setState(Project.State.COMPLETE); // mark the nodes has been visited 
			stack.push(project);  // put into queue
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] projects = {"a", "b", "c", "d", "e", "f"};
		String[][] depend = {{"d", "a"},{"b", "f"},{"d", "b"},{"a", "f"},{"c", "d"}};
		// create the graph first 
		String[]createGraph = CreateGraph(projects, depend); 
		if (createGraph == null) { // create fails
			System.out.println("Circular Happens");
		} else {
			for (String s : createGraph) {
				System.out.println(s);
			}
		}
	}
	
	// Function to create a graph
	public static String[] CreateGraph(String[] projects, String[][] depend) {
		GraphOrder graph = GraphOrder.createGraph(projects, depend);
		Stack<Project> stack = new Stack<Project>();
		for (Project project : graph.getNodes()) {
			if (project.getState() == Project.State.BLANK) {
				if (!search(project, stack)) { // If one of them can not search all , return fail
					return null;
				}
			}
		}
		if (stack == null) return null; // corner case 
		String[] graphStr= new String[stack.size()]; 
		for(int i = 0; i < graphStr.length; i++) {
			graphStr[i] = stack.pop().getName();  // give it by name 
		}
		return graphStr;
	}
	

}
