package Designite.organic.collector;

public class ClassLevelSmellDetector extends CompositeSmellDetector {
	
	public ClassLevelSmellDetector() {
		super.addDetector(new GodClass());
		super.addDetector(new ClassDataShouldBePrivate());
		super.addDetector(new ComplexClass());
		super.addDetector(new LazyClass());
		super.addDetector(new RefusedBequest());
		super.addDetector(new SpaghettiCode());
		super.addDetector(new SpeculativeGenerality());
		super.addDetector(new DataClass());
		super.addDetector(new BrainClass());
		super.addDetector(new LargeClass());
		super.addDetector(new SwissArmyKnife());
		super.addDetector(new AntiSingleton());
	}

	@Override
	protected SmellName getSmellName() {
		return null;
	}

}
