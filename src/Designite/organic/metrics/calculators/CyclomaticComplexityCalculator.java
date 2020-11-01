package Designite.organic.metrics.calculators;

import Designite.organic.ast.visitors.CyclomaticComplexityVisitor;
import Designite.organic.metrics.MetricName;
import org.eclipse.jdt.core.dom.ASTNode;

public class CyclomaticComplexityCalculator extends MetricValueCalculator {
	
	@Override
	protected Double computeValue(ASTNode target) {
		CyclomaticComplexityVisitor visitor = new CyclomaticComplexityVisitor();
		target.accept(visitor);
		return visitor.getCyclomaticComplexity().doubleValue();
	}

	@Override
	public MetricName getMetricName() {
		return MetricName.CC;
	}
	
	@Override
	public boolean shouldComputeAggregate() {
		return true;
	}

}
