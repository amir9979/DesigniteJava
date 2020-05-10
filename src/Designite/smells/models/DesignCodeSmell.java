package Designite.smells.models;

public class DesignCodeSmell extends CodeSmell {
	
	private String typeName;
	private String smellName;
	private int startingLine;
	private int endingLine;
	
	public DesignCodeSmell(String projectName
			, String packageName
			, String typeName
			, String smellName
			, int startingLine
			, int endingLine) {
		super(projectName, packageName);
		this.typeName = typeName;
		this.smellName = smellName;
		this.startingLine = startingLine;
		this.endingLine = endingLine;
	}

	public String getTypeName() {
		return typeName;
	}

	public String getSmellName() {
		return smellName;
	}
	
	@Override
	public String toString() {
		return getProjectName()
				+ "," + getPackageName()
				+ "," + typeName
				+ "," + smellName
				+ "," + startingLine
				+ "," + endingLine
				+ "\n";
	}

}
