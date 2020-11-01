package Designite.organic.metrics.calculators;

import Designite.organic.ast.visitors.MaxCallChainVisitor;
import Designite.organic.metrics.MetricName;
import org.eclipse.jdt.core.dom.ASTNode;

public class MaxCallChainCalculator extends MetricValueCalculator {
	
	@Override
	protected Double computeValue(ASTNode target) {
		MaxCallChainVisitor visitor = new MaxCallChainVisitor();
		target.accept(visitor);
		return visitor.getMaxCallChain().doubleValue();
	}

	@Override
	public MetricName getMetricName() {
		return MetricName.MaxCallChain;
	}

}
