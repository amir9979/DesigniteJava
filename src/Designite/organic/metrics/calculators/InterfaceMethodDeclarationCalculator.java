package Designite.organic.metrics.calculators;

import Designite.organic.ast.visitors.InterfaceMethodDeclarationCount;
import Designite.organic.metrics.MetricName;
import org.eclipse.jdt.core.dom.ASTNode;

public class InterfaceMethodDeclarationCalculator extends MetricValueCalculator {

	@Override
	protected Double computeValue(ASTNode target) {
		InterfaceMethodDeclarationCount visitor = new InterfaceMethodDeclarationCount();
		target.accept(visitor);
		return visitor.getInterfaceMethodsCount().doubleValue();
	}

	@Override
	public MetricName getMetricName() {
		return MetricName.InterfaceMethodDeclarationCount;
	}

	@Override
	public boolean shouldComputeAggregate() {
		return true;
	}
}
