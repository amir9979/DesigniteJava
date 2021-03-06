package Designite.organic.collector;

import Designite.organic.metrics.MetricName;
import Designite.organic.resources.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * All classes overriding more than half of the methods inherited by a superclass
 * @author Diego Cedrim
 */
public class RefusedBequest extends SmellDetector {
	
	@Override
	public List<Smell> detect(Resource resource) {
		Double overrideRatio = resource.getMetricValue(MetricName.OverrideRatio);
		if (overrideRatio != null && overrideRatio > 0.5) {
			StringBuilder builder = new StringBuilder();
			builder.append("OVERRIDE_RATIO = " + overrideRatio);
			
			Smell smell = super.createSmell(resource);
			smell.setReason(builder.toString());
			return Arrays.asList(smell);
		}
		return new ArrayList<>();
	}
	
	@Override
	protected SmellName getSmellName() {
		return SmellName.RefusedBequest;
	}

}
