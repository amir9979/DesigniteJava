package Designite.organic.collector;

import Designite.organic.metrics.AggregateMetricValues;
import Designite.organic.metrics.MetricName;
import Designite.organic.resources.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * All classes having LOCs lower than the first quartile of the distribution of LOCs for all system’s classes.
 * @author Diego Cedrim
 */
public class LazyClass extends SmellDetector {
	
	@Override
	public List<Smell> detect(Resource resource) {
		AggregateMetricValues aggregate = AggregateMetricValues.getInstance();
		Double classLOC = resource.getMetricValue(MetricName.CLOC);
		Double clocFirstQuartile = aggregate.getFirstQuartileValue(MetricName.CLOC);
		if (classLOC < clocFirstQuartile) {
			StringBuilder builder = new StringBuilder();
			builder.append("CLOC < " + clocFirstQuartile);
			
			Smell smell = super.createSmell(resource);
			smell.setReason(builder.toString());
			return Arrays.asList(smell);
		}
		return new ArrayList<>();
	}
	
	@Override
	protected SmellName getSmellName() {
		return SmellName.LazyClass;
	}

}
