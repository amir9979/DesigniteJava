package Designite.organic.ast.visitors;

import Designite.organic.resources.Method;
import org.eclipse.jdt.core.dom.*;

public class AccessorCounterVisitor extends ASTVisitor {

	private Integer numberOfAccessors;

	public Integer getNumberOfAccessors() {
		return numberOfAccessors;
	}

	public AccessorCounterVisitor() {
		this.numberOfAccessors = 0;
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		if (node.getName().toString().contains("get"))
			this.numberOfAccessors++;
		return true;
	}
}

