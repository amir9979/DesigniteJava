package Designite.organic.agglomeration;

import Designite.organic.agglomeration.relation.SyntacticalRelationChecker;
import Designite.organic.resources.Method;
import Designite.organic.resources.Resource;
import Designite.organic.resources.Type;
import Designite.organic.util.ConsoleProgressMonitor;

import java.util.ArrayList;
import java.util.List;

public class SmellyGraphBuilder {

	private SmellyGraph graph;

	private List<Resource> resources;

	public SmellyGraphBuilder() {
		this.resources = new ArrayList<>();
		this.graph = new SmellyGraph();
	}

	public void addResource(Resource resource) {
		this.resources.add(resource);
	}
	
	public void addTypeAndItsMethods(Type type) {
		this.resources.add(type);
		for (Method method : type.getMethods()) {
			this.resources.add(method);
		}
	}
	
	public void addTypeAndItsMethods(List<Type> types) {
		for (Type type : types) {
			this.addTypeAndItsMethods(type);
		}
	}

	private void buildNodes() {
		for (Resource resource : this.resources) {
			if (resource.isSmelly()) {
				graph.addNode(new SmellyNode(resource));
			}
		}
	}
	
	private void buildEdges() {
		SyntacticalRelationChecker checker = new SyntacticalRelationChecker();
		List<SmellyNode> nodes = new ArrayList<>(this.graph.getNodes());
		
		int n = nodes.size();
		ConsoleProgressMonitor monitor = new ConsoleProgressMonitor();
		monitor.beginTask("Building smelly graph edges", (1 + (n - 1))*n/2);
		for (int i = 0; i < nodes.size(); i++) {
			SmellyNode u = nodes.get(i);
			for (int j = i + 1; j < nodes.size(); j++) {
				monitor.worked(1);
				SmellyNode v = nodes.get(j);
				List<String> relations = checker.getRelationsBetween(u, v);
				if (!relations.isEmpty()) {
					this.graph.addEdge(u, v, relations);
				}
			}
		}
	}

	public SmellyGraph build() {
		this.buildNodes();
		this.buildEdges();
		return graph;
	}
}
