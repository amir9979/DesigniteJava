package Designite.organic.collector;

import Designite.organic.metrics.MetricName;
import Designite.organic.resources.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class data should be private: A class having at least one public field.
 * @author Diego Cedrim
 */
public class ClassDataShouldBePrivate extends SmellDetector {
	
	@Override
	public List<Smell> detect(Resource resource) {
		Double publicFieldCount = resource.getMetricValue(MetricName.PublicFieldCount);
		if (publicFieldCount != null && publicFieldCount >= 1) {
			StringBuilder builder = new StringBuilder();
			builder.append("PUBLIC_FIELD_COUNT = " + publicFieldCount);
			
			Smell smell = super.createSmell(resource);
			smell.setReason(builder.toString());
			return Arrays.asList(smell);
		}
		return new ArrayList<>();
	}
	
	@Override
	protected SmellName getSmellName() {
		return SmellName.ClassDataShouldBePrivate;
	}

}
