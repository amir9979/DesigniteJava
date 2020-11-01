package Designite.organic.collector;

import Designite.organic.metrics.AggregateMetricValues;
import Designite.organic.metrics.MetricName;
import Designite.organic.resources.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * All methods having LOCs higher than the average of the system.
 * @author Diego Cedrim
 */
public class LongMethod extends SmellDetector {
	
	@Override
	public List<Smell> detect(Resource resource) {
		AggregateMetricValues aggregate = AggregateMetricValues.getInstance();
		Double methodLoc = resource.getMetricValue(MetricName.MLOC);
		Double avgMLOC = aggregate.getAverageValue(MetricName.MLOC);
		if (methodLoc > avgMLOC && methodLoc > 30) {
			StringBuilder builder = new StringBuilder();
			builder.append("MLOC > " + avgMLOC);
			
			Smell smell = super.createSmell(resource);
			smell.setReason(builder.toString());
			return Arrays.asList(smell);
		}
		return new ArrayList<>();
	}
	
	@Override
	protected SmellName getSmellName() {
		return SmellName.LongMethod;
	}

}
