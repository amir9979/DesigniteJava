package Designite.metrics;

import Designite.organic.collector.Smell;
import Designite.organic.resources.Type;

public class OrganicTypeSmellFacade {

    String projectName;
    String packageName;
    String typeName;
    String smellName;

    public OrganicTypeSmellFacade(String projectName, Type type, Smell smell) {
       this.projectName = projectName;
       this.packageName = type.getPackageName();
       this.typeName = type.getTypeName();
       this.smellName = smell.getName().name();
    }

    @Override
    public String toString() {
        return projectName
                + "," + packageName
                + "," + typeName
                + "," + smellName
                + "\n";
    }
}
