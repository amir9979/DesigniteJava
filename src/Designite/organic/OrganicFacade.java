package Designite.organic;

import Designite.organic.collector.ClassLevelSmellDetector;
import Designite.organic.collector.MethodLevelSmellDetector;
import Designite.organic.collector.Smell;
import Designite.organic.metrics.MethodMetricValueCollector;
import Designite.organic.metrics.TypeMetricValueCollector;
import Designite.organic.resources.*;
import Designite.utils.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class OrganicFacade {

    public OrganicFacade(String projectName, List<String> sourcePaths) {
        this.projectName = projectName;
        loadAllTypes(sourcePaths);
    }

    private String projectName;


    private List<Type> allTypes;
    private List<Method> allMethods;
    private Map<Type, List<OrganicTypeSmellFacade>> organicTypeMapping = new HashMap<>();
    private Map<Type, Map<Method, List<OrganicMethodSmellFacade>>> organicMethodMapping = new HashMap<>();

    public void extractOrganicSmells() {
        collectTypeMetrics();
        detectSmells();
    }

    public List<OrganicTypeSmellFacade> getTypeSmells(Type type) {
        return organicTypeMapping.get(type);
    }

    public List<OrganicMethodSmellFacade> getMethodSmells(Type type, Method method) {
        return organicMethodMapping.get(type).get(method);
    }

    public List<Type> getTypes() {
        return allTypes;
    }

    private void loadAllTypes(List<String> sourcePaths) {

        allTypes = new ArrayList<>();
        JavaFilesFinder sourceLoader = new JavaFilesFinder(sourcePaths);
        try {
            SourceFilesLoader compUnitLoader = new SourceFilesLoader(sourceLoader);
            List<SourceFile> sourceFiles = compUnitLoader.getLoadedSourceFiles();

            for (SourceFile sourceFile : sourceFiles) {
                for (Type type : sourceFile.getTypes()) {
                    allTypes.add(type);
                }
            }
        } catch (IOException e) {
            Logger.log("Application couldn't find the source code file in the specified path.");
            System.exit(1);
            Logger.log("Quitting..");
        }
    }

    private void collectTypeMetrics() {
        for (Type type : allTypes) {
            TypeMetricValueCollector typeCollector = new TypeMetricValueCollector();
            typeCollector.collect(type);
            this.collectMethodMetrics(type);
        }
    }

    private void collectMethodMetrics(Type type) {
        for (Method method: type.getMethods()) {
            MethodMetricValueCollector methodCollector = new MethodMetricValueCollector(type.getNodeAsTypeDeclaration());
            methodCollector.collect(method);
        }
    }

    private void detectSmells() {
        for (Type type : allTypes) {
            // It is important for some detectors that method-level smells are collected first
            for (Method method: type.getMethods()) {
                MethodLevelSmellDetector methodSmellDetector = new MethodLevelSmellDetector();
                List<Smell> smells = methodSmellDetector.detect(method);
                method.addAllSmells(smells);
            }
            // some class-level detectors use method-level smells in their algorithms
            ClassLevelSmellDetector classSmellDetector = new ClassLevelSmellDetector();
            List<Smell> smells = classSmellDetector.detect(type);
            type.addAllSmells(smells);
            try {
                getSmells(type);
            } catch (Exception e) {

            }
        }
    }

    private void getSmells(Type type) {
        List<OrganicTypeSmellFacade> typeSmellsFacade = new ArrayList<>();
        for (Smell smell : type.getSmells()) {
           OrganicTypeSmellFacade facade = new OrganicTypeSmellFacade(projectName, type, smell);
           typeSmellsFacade.add(facade);
        }
        System.out.println(type);
        organicTypeMapping.put(type, typeSmellsFacade);

        Map<Method, List<OrganicMethodSmellFacade>> methodSmellsMap = new HashMap<>();
        for (Method method : type.getMethods()) {
            List<OrganicMethodSmellFacade> methodSmellsFacade = new ArrayList<>();
            for (Smell smell : method.getSmells()) {
                OrganicMethodSmellFacade facade = new OrganicMethodSmellFacade (projectName, type, method, smell);
                methodSmellsFacade.add(facade);
            }
            methodSmellsMap.put(method, methodSmellsFacade);
        }
        organicMethodMapping.put(type, methodSmellsMap);

    }

}
