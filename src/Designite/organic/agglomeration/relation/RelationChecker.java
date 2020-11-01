package Designite.organic.agglomeration.relation;

import Designite.organic.agglomeration.SmellyNode;
import Designite.organic.resources.Method;
import Designite.organic.resources.Type;

import java.util.List;

public abstract class RelationChecker {

	public abstract boolean isRelated(SmellyNode u, SmellyNode v);
	
	protected boolean areBothMethods(SmellyNode u, SmellyNode v) {
		return u.getResource() instanceof Method && v.getResource() instanceof Method;
	}
	
	protected boolean areBothClasses(SmellyNode u, SmellyNode v) {
		return u.getResource() instanceof Type && v.getResource() instanceof Type;
	}
	
	protected boolean intersects(List<?> uList, List<?> vList) {
		for (Object obj : uList) {
			if (vList.contains(obj)) {
				return true;
			}
		}
		return false;
	}
	
	public String getName() {
		return this.getClass().getName();
	}
}
