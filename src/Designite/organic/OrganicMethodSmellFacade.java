package Designite.organic;

import Designite.organic.collector.Smell;
import Designite.organic.resources.Method;
import Designite.organic.resources.Type;

public class OrganicMethodSmellFacade {

    String projectName;
    String packageName;
    String typeName;
    String methodName;
    String smellName;
    int startingLine;
    int endingLine;

    public OrganicMethodSmellFacade(String projectName, Type type, Method method, Smell smell) {
       this.projectName = projectName;
       this.packageName = type.getPackageName();
       this.typeName = type.getTypeName();
       this.methodName = method.getMethodName();
       this.smellName = smell.getName().toString();
       this.startingLine = smell.getStartingLine();
       this.endingLine = smell.getEndingLine();
    }

    @Override
    public String toString() {
        return projectName
                + "," + packageName
                + "," + typeName
                + "," + methodName
                + "," + smellName
                + "," + startingLine
                + "," + endingLine
                + "\n";
    }
}
