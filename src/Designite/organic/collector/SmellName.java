package Designite.organic.collector;

public enum SmellName {
	ClassDataShouldBePrivate("Class Data Should Be Private"),
	ComplexClass("Complex Class"),
	FeatureEnvy("Feature Envy"),
	GodClass("God Class"),
	LazyClass("Lazy Class"),
	LongMethod("Long Method"),
	LongParameterList("Long Parameter List"),
	MessageChain("Message Chain"),
	RefusedBequest("Refused Bequest"),
	SpeculativeGenerality("Speculative Generality"),
	SpaghettiCode("Spaghetti Code"),
	DispersedCoupling("Dispersed Coupling"),
	IntensiveCoupling("Intensive Coupling"),
	BrainClass("Brain Class"),
	ShotgunSurgery("Shotgun Surgery"),
	BrainMethod("Brain Method"),
	DataClass("Data Class"),
	LargeClass("Large Class"),
    SwissArmyKnife("Swiss Army Knife"),
	AntiSingleton("Anti Singleton");

	private String name;

	SmellName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
