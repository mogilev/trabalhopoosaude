
public class ClientClass extends Person implements Client {
	private Family family;
	private AgeGroup ageGroup;
	

	public ClientClass(String name, AgeGroup ageGroup) {
		super(name);
		this.ageGroup = ageGroup;
	}

	public Family getFamily() {
		return this.family;
	}

    public Family setFamily(Family family) {
    	this.family = family;
        return this.family;
	}

	public String getAgeGroup() {
		return this.ageGroup.toString(); //verificar se assim conseguimos "ver" o enum associado ao objecto
	}


	
}
