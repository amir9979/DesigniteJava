package Designite.organic.metrics.calculators;

import Designite.organic.metrics.MetricName;
import Designite.organic.resources.Method;
import Designite.organic.resources.Type;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.internal.core.util.ExceptionAttribute;

import java.lang.reflect.Modifier;

public class IsClassSingleton extends MetricValueCalculator {
	
	@Override
	protected Double computeValue(ASTNode target) {
		TypeDeclaration type = (TypeDeclaration)target;
		boolean isConstructorPrivate = false;
		boolean staticMethodReturnsTypeObject = false;
		for(MethodDeclaration method : type.getMethods()) {
				if (method.isConstructor() && Modifier.isPrivate(method.getModifiers())) {
					isConstructorPrivate = true;
				} else if (Modifier.isStatic(method.getModifiers())) {
					ITypeBinding x = type.resolveBinding();
					if (x == null){
						continue;
					}
				if (method.getReturnType2().resolveBinding().getName().equals(x.getName())) {
					staticMethodReturnsTypeObject = true;
					}
				}
		}

		if (isConstructorPrivate && staticMethodReturnsTypeObject){
			return 1d;
		} else {
			return 0d;
		}
	}



	@Override
	public MetricName getMetricName() {
		return MetricName.IsSingleton;
	}

}
