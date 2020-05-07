package Designite.organic.metrics.calculators;

import Designite.organic.ast.visitors.MaximumNestingLevelVisitor;
import Designite.organic.metrics.MetricName;
import org.eclipse.jdt.core.dom.ASTNode;

/**
 * Computes the max nesting level of a method
 * @author Diego Cedrim
 */
public class MaxNestingCalculator extends MetricValueCalculator {

	@Override
	protected Double computeValue(ASTNode target) {
		MaximumNestingLevelVisitor visitor = new MaximumNestingLevelVisitor();
		target.accept(visitor);
		return visitor.getMNL();
	}

	@Override
	public MetricName getMetricName() {
		return MetricName.MaxNesting;
	}

}
