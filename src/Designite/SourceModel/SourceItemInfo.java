package Designite.SourceModel;

public class SourceItemInfo {
	private String projectName;
	private String filePath;
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
			, String filePath
			, String packageName
			, String typeName
			, int startingLineNumber
			, int endingLineNumber) {
		this(projectName, packageName);
		this.typeName = typeName;
		this.filePath = filePath;
		this.startingLineNumber = startingLineNumber;
		this.endingLineNumber = endingLineNumber;
	}
	
	public SourceItemInfo(String projectName
			, String filePath
			, String packageName
			, String typeName
			, String methodName
			, int startingLineNumber
			, int endingLineNumber) {
		this(projectName, filePath, packageName, typeName, startingLineNumber, endingLineNumber);
		this.methodName = methodName;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getFilePath() {
		return filePath;
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
