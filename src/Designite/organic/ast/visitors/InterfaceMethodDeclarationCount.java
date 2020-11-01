package Designite.organic.ast.visitors;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Modifier;

public class InterfaceMethodDeclarationCount extends ASTVisitor {

	private Integer methodsCount;

	public InterfaceMethodDeclarationCount() {
		this.methodsCount = 0;
	}

	public Integer getInterfaceMethodsCount() {
		return methodsCount;
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		if (node.resolveBinding() == null)
			return false;

		if(node.resolveBinding().getDeclaringClass().isInterface()) {
			this.methodsCount++;
		}
		return false;
	}

}
