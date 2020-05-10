package Designite.SourceModel;

public class SourceItemInfo {
	
	private String projectName;
	private String packageName;
	private String typeName;
	private String methodName;
	private int startingLineNumber;
	private int endingLineNumber;
	
	public SourceItemInfo(String projectName
			, String packageName) {
		this.projectName = projectName;
		this.packageName = packageName;
	}
	
	public SourceItemInfo(String projectName
			, String packageName
			, String typeName
			, int startingLineNumber
			, int endingLineNumber) {
		this(projectName, packageName);
		this.typeName = typeName;
		this.startingLineNumber = startingLineNumber;
		this.endingLineNumber = endingLineNumber;
	}
	
	public SourceItemInfo(String projectName
			, String packageName
			, String typeName
			, String methodName
			, int startingLineNumber
			, int endingLineNumber) {
		this(projectName, packageName, typeName, startingLineNumber, endingLineNumber);
		this.methodName = methodName;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getPackageName() {
		return packageName;
	}

	public String getTypeName() {
		return typeName;
	}

	public String getMethodName() {
		return methodName;
	}
	
	public int getStartingLineNumber() {
		return startingLineNumber;
	}

	public int getEndingLineNumber() {
		return endingLineNumber;
	}
}
