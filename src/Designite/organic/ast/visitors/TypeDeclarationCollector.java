package Designite.organic.ast.visitors;

import org.eclipse.jdt.core.dom.TypeDeclaration;

public class TypeDeclarationCollector extends CollectorVisitor<TypeDeclaration> {
	
	@Override
	public boolean visit(TypeDeclaration node) {
		super.addCollectedNode(node);
		return true;
	}
}
