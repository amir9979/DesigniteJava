package Designite.organic.collector;

import Designite.organic.metrics.MetricName;
import Designite.organic.metrics.Thresholds;
import Designite.organic.resources.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Intensive Coupling occurs when a method is tied to many other operations in the system, 
 * whereby these provider operations are dispersed only into one or a few classes.
 * 
 * @author Diego Cedrim
 */
public class IntensiveCoupling extends SmellDetector {
	
	@Override
	public List<Smell> detect(Resource resource) {
		Double cint = resource.getMetricValue(MetricName.CINT);
		Double cdisp = resource.getMetricValue(MetricName.CDISP);
		Double maxNesting = resource.getMetricValue(MetricName.MaxNesting);
		
		boolean callsManyDispersedInFew = cint > Thresholds.SHORT_MEMORY_CAP && cdisp < Thresholds.HALF;
		boolean callsMoreThanFewInVeryFewClasses = cint > Thresholds.FEW && cdisp < Thresholds.ONE_QUARTER;
		if (callsManyDispersedInFew || callsMoreThanFewInVeryFewClasses) {
			if (maxNesting > Thresholds.SHALLOW) {
				StringBuilder builder = new StringBuilder();
				builder.append("CINT = " + cint);
				builder.append(", CDISP = " + cdisp);
				builder.append(", CC > " + Thresholds.SHALLOW);
				
				Smell smell = super.createSmell(resource);
				smell.setReason(builder.toString());
				return Arrays.asList(smell);
			}
		}
		
		return new ArrayList<>();
	}
	
	@Override
	protected SmellName getSmellName() {
		return SmellName.IntensiveCoupling;
	}

}
