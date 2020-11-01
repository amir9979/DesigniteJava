package Designite.organic.metrics.calculators;

import Designite.organic.metrics.MetricName;
import org.eclipse.jdt.core.dom.ASTNode;

public class CouplingDispersionCalculator extends CouplingIntensityCalculator {

	@Override
	protected Double computeValue(ASTNode target) {
		Double cint = super.computeValue(target);
		if (cint == null || cint == 0) {
			return 0d;
		}
		Double differentClassses = new Double(super.methodCalls.keySet().size());
		return differentClassses/cint;
	}

	@Override
	public MetricName getMetricName() {
		return MetricName.CDISP;
	}

}
