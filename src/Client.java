
public interface Client {
	
	String getName();
	
	String getAgeGroupName();
	
	AgeGroup getAgeGroup();
	
	Family getFamily();
	
    String getFamilyName();
	
	Family setFamily(Family family);
	 
}
