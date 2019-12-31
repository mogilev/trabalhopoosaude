
public class ClientClass extends Person implements Client {
	private FamilyClass family;
	private AgeGroup ageGroup;
	

	public ClientClass(String name, AgeGroup ageGroup) {
		super(name);
		this.ageGroup = ageGroup;
		this.name = name;
	}

	public FamilyClass getFamily() {
		return family;
	}

	public void setFamily(FamilyClass family) {
		this.family = family;
	}

	public String getAgeGroup() {
		return this.ageGroup.name(); //verificar se assim conseguimos "ver" o enum associado ao objecto
	}


	
}
