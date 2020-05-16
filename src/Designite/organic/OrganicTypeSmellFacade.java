package Designite.organic;

import Designite.organic.collector.Smell;
import Designite.organic.resources.Type;

public class OrganicTypeSmellFacade {

    String projectName;
    String filePath;
    String packageName;
    String typeName;
    String smellName;
    int startingLine;
    int endingLine;

    public OrganicTypeSmellFacade(String projectName, Type type, Smell smell) {
       this.projectName = projectName;
       this.filePath = type.getSourceFile().getFile().getPath();
       this.packageName = type.getPackageName();
       this.typeName = type.getTypeName();
       this.smellName = smell.getName().toString();
       this.startingLine = smell.getStartingLine();
       this.endingLine = smell.getEndingLine();
    }

    @Override
    public String toString() {
        return projectName
                + "," + filePath
                + "," + packageName
                + "," + typeName
                + "," + smellName
                + "," + startingLine
                + "," + endingLine
                + "\n";
    }
}
