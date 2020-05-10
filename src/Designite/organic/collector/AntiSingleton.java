package Designite.organic.collector;

import Designite.organic.metrics.MetricName;
import Designite.organic.metrics.Thresholds;
import Designite.organic.resources.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A data class refers to a class that contains only fields and crude methods 
 * for accessing them (getters and setters). These are simply containers for data 
 * used by other classes. These classes do not contain any additional functionality 
 * and cannot independently operate on the data that they own.
 * @author Diego Cedrim
 */
public class AntiSingleton extends SmellDetector {
	
	@Override
	public List<Smell> detect(Resource resource) {
		final Double globalVariableLimit = 1d;

		Double isSingletonValue = resource.getMetricValue(MetricName.IsSingleton);
		Double publicFieldCount = resource.getMetricValue(MetricName.PublicFieldCount);
		Double accessorsCount = resource.getMetricValue(MetricName.AccessorCount);

		boolean isSingleton = isSingletonValue == 1;
		boolean hasMoreThanOneGlobalVariable = publicFieldCount + accessorsCount > globalVariableLimit;


		if (isSingleton && hasMoreThanOneGlobalVariable) {
			StringBuilder builder = new StringBuilder();
			builder.append("IsSingleton");
			builder.append("NumPublicFields: " + publicFieldCount);

			Smell smell = super.createSmell(resource);
			smell.setReason(builder.toString());
			return Arrays.asList(smell);
		}
		return new ArrayList<>();
	}
	
	@Override
	protected SmellName getSmellName() {
		return SmellName.AntiSingleton;
	}

}
