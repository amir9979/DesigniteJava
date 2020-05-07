package Designite.organic.metrics;

import Designite.organic.metrics.calculators.*;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class MethodMetricValueCollector extends MetricValueCollector {

	public MethodMetricValueCollector(TypeDeclaration declaringClass) {
		addCalculator(new MethodLOCCalculator());
		addCalculator(new CyclomaticComplexityCalculator());
		addCalculator(new MethodParameterCountCalculator());
		addCalculator(new MaxCallChainCalculator());
		addCalculator(new CouplingDispersionCalculator());
		addCalculator(new CouplingIntensityCalculator());
		addCalculator(new NOAVCalculator());
		addCalculator(new ChangingClassesCalculator());
		addCalculator(new MaxNestingCalculator());
		addCalculator(new ChangingMethodsCalculator());
	}
	
	
}
