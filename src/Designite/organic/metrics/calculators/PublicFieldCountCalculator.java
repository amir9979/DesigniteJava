package Designite.organic.metrics.calculators;

import Designite.organic.ast.visitors.PublicFieldCount;
import Designite.organic.metrics.MetricName;
import org.eclipse.jdt.core.dom.ASTNode;

public class PublicFieldCountCalculator extends MetricValueCalculator {
	
	@Override
	protected Double computeValue(ASTNode target) {
		PublicFieldCount visitor = new PublicFieldCount();
		target.accept(visitor);
		return visitor.getPublicFieldsCount().doubleValue();
	}

	@Override
	public MetricName getMetricName() {
		return MetricName.PublicFieldCount;
	}

}
