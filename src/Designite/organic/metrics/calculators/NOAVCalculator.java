package Designite.organic.metrics.calculators;

import Designite.organic.ast.visitors.FieldAccessCollector;
import Designite.organic.metrics.MetricName;
import org.eclipse.jdt.core.dom.ASTNode;

/**
 * Considers that the target node is a method declaration.
 * It computes how many attributes the method accesses
 * @author Diego Cedrim
 */
public class NOAVCalculator extends MetricValueCalculator {

	@Override
	protected Double computeValue(ASTNode target) {
		FieldAccessCollector fieldAccessesVisitor = new FieldAccessCollector();
		target.accept(fieldAccessesVisitor);
		Integer nodesCollected = fieldAccessesVisitor.getNodesCollected().size(); 
		return nodesCollected.doubleValue();
	}

	@Override
	public MetricName getMetricName() {
		return MetricName.NOAV;
	}

}
