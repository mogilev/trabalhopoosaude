
public class ClientClass extends Person implements Client {
	private FamilyClass family;
	private String ageGroup;
	

	public ClientClass(String name, String ageGroup) {
		super(name);
		this.ageGroup = ageGroup;
	}

	public FamilyClass getFamily() {
		return family;
	}

	public void setFamily(FamilyClass family) {
		this.family = family;
	}

	public String getAgeGroup() {
		return ageGroup;
	}


	
}
