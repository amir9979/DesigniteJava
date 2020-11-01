package Designite.organic.metrics;

import Designite.organic.metrics.calculators.*;

public class TypeMetricValueCollector extends MetricValueCollector {

	public TypeMetricValueCollector() {
		addCalculator(new TCCMetricValueCalculator());
		addCalculator(new PublicFieldCountCalculator());
		addCalculator(new ClassLOCCalculator());
		addCalculator(new OverrideRatioCalculator());
		addCalculator(new IsClassAbstract());
		addCalculator(new NOAMCalculator());
		addCalculator(new WMCCalculator());
		addCalculator(new WOCCalculator());
		addCalculator(new LCOM2Calculator());
		addCalculator(new LCOM3Calculator());
		addCalculator(new InterfaceMethodDeclarationCalculator());
		addCalculator(new IsClassSingleton());
		addCalculator(new AccessorCountCalculator());
	}
	
	
}
