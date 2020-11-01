package Designite.smells.models;

public class DesignCodeSmell extends CodeSmell {

	private String filePath;
	private String typeName;
	private String smellName;
	private int startingLine;
	private int endingLine;
	
	public DesignCodeSmell(String projectName
			, String filePath
			, String packageName
			, String typeName
			, String smellName
			, int startingLine
			, int endingLine) {
		super(projectName, packageName);
		this.filePath = filePath;
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
				+ "," + filePath
				+ "," + getPackageName()
				+ "," + typeName
				+ "," + smellName
				+ "," + startingLine
				+ "," + endingLine
				+ "\n";
	}

}
