package Designite.organic.metrics.calculators;

import Designite.organic.ast.visitors.LinesOfCodeVisitor;
import Designite.organic.metrics.MetricName;
import org.eclipse.jdt.core.dom.ASTNode;

public class ClassLOCCalculator extends MetricValueCalculator {
	
	@Override
	protected Double computeValue(ASTNode target) {
		LinesOfCodeVisitor visitor = new LinesOfCodeVisitor();
		target.accept(visitor);
		return visitor.getLoc().doubleValue();
	}

	@Override
	public MetricName getMetricName() {
		return MetricName.CLOC;
	}
	
	@Override
	public boolean shouldComputeAggregate() {
		return true;
	}

}
