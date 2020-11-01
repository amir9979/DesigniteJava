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
public class SwissArmyKnife extends SmellDetector {
	
	@Override
	public List<Smell> detect(Resource resource) {
		Double veryHighInterfaceMethodDeclarationCount = Thresholds.getVeryHighThreshold(MetricName.InterfaceMethodDeclarationCount);
		
		Double interfaceMethodDeclarationCount = resource.getMetricValue(MetricName.InterfaceMethodDeclarationCount);
		
		boolean veryHighInterfaceMethodCount = interfaceMethodDeclarationCount > veryHighInterfaceMethodDeclarationCount;

		if (veryHighInterfaceMethodCount) {
			StringBuilder builder = new StringBuilder();
			builder.append("InterfaceMethodDeclarationCount = " + interfaceMethodDeclarationCount);

			Smell smell = super.createSmell(resource);
			smell.setReason(builder.toString());
			return Arrays.asList(smell);
		}
		return new ArrayList<>();
	}
	
	@Override
	protected SmellName getSmellName() {
		return SmellName.SwissArmyKnife;
	}

}
