package Designite.SourceModel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;

public class MethodInvVisitor extends ASTVisitor {
	List<MethodInvocation> calledMethods = new ArrayList<MethodInvocation>();
	private MethodDeclaration methodDeclaration;

	public MethodInvVisitor(MethodDeclaration methodDeclaration) {
		super();
		this.methodDeclaration = methodDeclaration;
	}
	
	public MethodInvVisitor() {
		
	}

	@Override
	public boolean visit(MethodInvocation method) {
		calledMethods.add(method);
		IMethodBinding imethod = method.resolveMethodBinding();
//		System.out.println(method);
		return super.visit(method);
	}
	
	//
	public boolean visit(SuperMethodInvocation method){
//		System.out.println(method.getName());
		return super.visit(method);
	}

	public List<MethodInvocation> getCalledMethods() {
		return calledMethods;
	}
}