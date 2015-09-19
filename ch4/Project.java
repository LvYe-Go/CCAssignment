package ch4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Project {
		public enum State {COMPLETE, PARTIAL, BLANK}; // record the state of visited node 
		private List<Project> children = new ArrayList<Project>();
		private HashMap<String, Project> map = new HashMap<String, Project>();
		private String name;
		private State state = State.BLANK;
		public Project(String n) {name = n;}
		public String getName() {return name;}
		public State getState() { return state;}
		public void setState(State st) {state = st;}
		public List<Project> getChildren() {return children;}
		
		public void addNeighbor(Project node) {
			if (!map.containsKey(node.getName())) 
				children.add(node);
		}
}
