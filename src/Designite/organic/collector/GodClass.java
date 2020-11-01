package Designite.organic.collector;

import Designite.organic.metrics.AggregateMetricValues;
import Designite.organic.metrics.MetricName;
import Designite.organic.resources.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * All classes having (i) cohesion lower than the average of the system AND (ii) LOCs > 500
 * @author Diego Cedrim
 */
public class GodClass extends SmellDetector {
	
	@Override
	public List<Smell> detect(Resource resource) {
		AggregateMetricValues aggregate = AggregateMetricValues.getInstance();
		Double classLOC = resource.getMetricValue(MetricName.CLOC);
		Double classTCC = resource.getMetricValue(MetricName.TCC);
		Double tccAvg = aggregate.getAverageValue(MetricName.TCC);
		if (classLOC > 500 && classTCC < tccAvg) {
			StringBuilder builder = new StringBuilder();
			builder.append("CLOC > " + 500);
			builder.append(", TCC < " + tccAvg);
			
			Smell smell = super.createSmell(resource);
			smell.setReason(builder.toString());
			return Arrays.asList(smell);
		}
		return new ArrayList<>();
	}
	
	@Override
	protected SmellName getSmellName() {
		return SmellName.GodClass;
	}

}
