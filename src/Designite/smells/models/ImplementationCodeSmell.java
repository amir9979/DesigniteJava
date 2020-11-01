package Designite.smells.models;

public class ImplementationCodeSmell extends CodeSmell {

	private String filePath;
	private String typeName;
	private String methodName;
	private String smellName;
	private int startingLine;
	private int endingLine;
	
	public ImplementationCodeSmell(String projectName
			, String filePath
			, String packageName
			, String typeName
			, String methodName
			, String smellName
			, int startingLine
			, int endingLine) {
		super(projectName, packageName);
		this.filePath = filePath;
		this.typeName = typeName;
		this.methodName = methodName;
		this.smellName = smellName;
		this.startingLine = startingLine;
		this.endingLine = endingLine;
	}

	public String getTypeName() {
		return typeName;
	}

	public String getMethodName() {
		return methodName;
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
				+ "," + methodName
				+ "," + smellName
				+ "," + startingLine
				+ "," + endingLine
				+ "\n";
	}
	
}
