package Designite.organic.agglomeration.relation;

import Designite.organic.agglomeration.SmellyNode;
import Designite.organic.resources.ParenthoodRegistry;
import Designite.organic.resources.Type;

public class ClassExtensionChecker extends RelationChecker {
	
	@Override
	public boolean isRelated(SmellyNode u, SmellyNode v) {
		if (!super.areBothClasses(u, v)) {
			return false;
		}
		ParenthoodRegistry registry = ParenthoodRegistry.getInstance();
		Type uType = (Type)u.getResource();
		Type vType = (Type)v.getResource();
		return registry.isDescendant(uType, vType) || registry.isDescendant(vType, uType);
	}

}
