package Designite.organic.metrics.calculators;

import Designite.organic.ast.visitors.AccessorCounterVisitor;
import Designite.organic.ast.visitors.LinesOfCodeVisitor;
import Designite.organic.metrics.MetricName;
import Designite.organic.resources.Type;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class AccessorCountCalculator extends MetricValueCalculator {

	@Override
	protected Double computeValue(ASTNode target) {
		AccessorCounterVisitor visitor = new AccessorCounterVisitor();
		target.accept(visitor);
		return visitor.getNumberOfAccessors().doubleValue();
	}

	@Override
	public MetricName getMetricName() {
		return MetricName.AccessorCount;
	}
	
}
