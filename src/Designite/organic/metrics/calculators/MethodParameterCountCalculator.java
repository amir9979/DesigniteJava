package Designite.organic.metrics.calculators;

import Designite.organic.metrics.MetricName;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class MethodParameterCountCalculator extends MetricValueCalculator {
	
	@Override
	protected Double computeValue(ASTNode target) {
		MethodDeclaration declaration = (MethodDeclaration)target;
		return new Double(declaration.parameters().size());
	}

	@Override
	public MetricName getMetricName() {
		return MetricName.ParameterCount;
	}
	
	@Override
	public boolean shouldComputeAggregate() {
		return true;
	}

}
