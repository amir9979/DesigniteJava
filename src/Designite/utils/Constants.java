package Designite.utils;

import java.io.File;

public class Constants {
	
	/*public static final String PATH_OF_THRESHOLDS = System.getProperty("user.dir") 
			+ File.separator
			+ "thresholds.txt";*/
	
	//public static String CSV_DIRECTORY_PATH = System.getProperty("user.dir") 
	//		+ File.separator
	//			+ "default_csv";
	
	public static final String TYPE_METRICS_PATH_SUFFIX = "typeMetrics.csv";
	public static final String METHOD_METRICS_PATH_SUFFIX = "methodMetrics.csv";
	public static final String DESIGN_CODE_SMELLS_PATH_SUFFIX = "designCodeSmells.csv";
	public static final String IMPLEMENTATION_CODE_SMELLS_PATH_SUFFIX = "implementationCodeSmells.csv";
	public static final String ORGANIC_TYPE_CODE_SMELLS_PATH_SUFFIX = "organicTypeCodeSmells.csv";
	public static final String ORGANIC_METHOD_CODE_SMELLS_PATH_SUFFIX = "organicMethodCodeSmells.csv";

	public static final String TYPE_METRICS_HEADER = "Project Name"
			+ ",File Path"
			+ ",Package Name"
			+ ",Type Name"
			+ ",NOF"
			+ ",NOPF"
			+ ",NOM"
			+ ",NOPM"
			+ ",LOC"
			+ ",WMC"
			+ ",NC"
			+ ",DIT"
			+ ",LCOM"
			+ ",FANIN"
			+ ",FANOUT"
			+ "\n";
	
	public static final String METHOD_METRICS_HEADER = "Project Name"
			+ ",File Path"
			+ ",Package Name"
			+ ",Type Name"
			+ ",MethodName"
			+ ",LOC"
			+ ",CC"
			+ ",PC"
			+ "\n";
	
	public static final String DESIGN_CODE_SMELLS_HEADER = "Project Name"
			+ ",File Path"
			+ ",Package Name"
			+ ",Type Name"
			+ ",Code Smell"
			+ ",Starting Line"
			+ ",Ending Line"
			+ "\n";
	
	public static final String IMPLEMENTATION_CODE_SMELLS_HEADER = "Project Name"
			+ ",File Path"
			+ ",Package Name"
			+ ",Type Name"
			+ ",Method Name"
			+ ",Code Smell"
			+ ",Starting Line"
			+ ",Ending Line"
			+ "\n";

	public static final String ORGANIC_TYPE_CODE_SMELLS_HEADER  = "Project Name"
			+ ",File Path"
			+ ",Package Name"
			+ ",Type Name"
			+ ",Code Smell"
			+ ",Starting Line"
			+ ",Ending Line"
			+ "\n";

	public static final String ORGANIC_METHOD_CODE_SMELLS_HEADER = "Project Name"
			+ ",File Path"
			+ ",Package Name"
			+ ",Type Name"
			+ ",Method Name"
			+ ",Code Smell"
			+ ",Starting Line"
			+ ",Ending Line"
			+ "\n";

	public static final boolean DEBUG = false;
}
