package Designite.organic.agglomeration.relation;

import Designite.organic.agglomeration.SmellyNode;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeRelationChecker extends RelationChecker {
	
	private List<RelationChecker> checkers;
	
	public CompositeRelationChecker() {
		this.checkers = new ArrayList<>();
	}
	
	public void addChecker(RelationChecker checker) {
		this.checkers.add(checker);
	}
	
	@Override
	public boolean isRelated(SmellyNode u, SmellyNode v) {
		for (RelationChecker checker : checkers) {
			if (checker.isRelated(u, v)) {
				return true;
			}
		}
		return false;
	}
	
	public List<String> getRelationsBetween(SmellyNode u, SmellyNode v) {
		if (areBothClasses(u, v) || areBothMethods(u, v)) {
			List<String> relations = new ArrayList<>();
			for (RelationChecker checker : checkers) {
				if (checker.isRelated(u, v)) {
					relations.add(checker.getName());
				}
			}
			return relations;
		}
		return new ArrayList<>();
	}
}
