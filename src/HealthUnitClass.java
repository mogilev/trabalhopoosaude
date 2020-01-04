import java.util.ArrayList;
import java.util.List;

public class HealthUnitClass implements HealthUnit {
	private List<Client> clientList;
	private List<HealthProfessional> healthProfessionalList;
	private List<Appointment> appointmentList;
	private List<Family> familyList;
	
	
	public HealthUnitClass() {
		this.clientList = new ArrayList<Client>();
		this.healthProfessionalList = new ArrayList<HealthProfessional>();
		this.appointmentList = new ArrayList<Appointment>();
		this.familyList = new ArrayList<Family>();
	}
	

	@Override
	public boolean hasProfessional(String professionalCat, String professionalName) {
		for(HealthProfessional healthProfessional : this.getProfessionalList()) {
            if(healthProfessional.getName() == professionalName && healthProfessional.getCategory() == professionalCat){
                return true; 
                }
            }
            return false;
	}

	@Override
	public boolean categoryExists(String professionalCat) {
		for (Category category : Category.values()) {
        	if (category.name().equals(professionalCat)) {
                return true;
	}	}
            return false;}

	
	public int createProfessional(String professionalCat, String professionalName) {
		Category category = Category.valueOf(professionalCat);
        HealthProfessional healthProfessional = (HealthProfessional) new HealthProfessionalClass(category, professionalName);
        healthProfessionalList.add((HealthProfessional) healthProfessional);
		return 0;
	}

	@Override
	public boolean hasClient(String clientName) {
        for(Client client : this.getClientList()) {
            if(client.getName() == clientName){
            return true; 
            }
        }
        return false;
	}

	@Override
	public boolean ageGroupExists(String clientAgeGroup) {
        for (AgeGroup ageGroup : AgeGroup.values()) {
            if (ageGroup.name().equals(clientAgeGroup)) {
                return true;
            	}
        	}
        return false;
    } 

	@Override
	public boolean familyExists(String familyName) {
		for(Family family : this.getFamilyList()) {
            if(family.getFamilyName() == familyName){
                return true; 
                }
            }
            return false;
	}

	@Override
	public boolean hasFamily(String clientName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int createClient(String clientName, String clientAgeGroup) {
        AgeGroup ageGroup = AgeGroup.valueOf(clientAgeGroup);
        Client client = (Client) new ClientClass(clientName, ageGroup);
        clientList.add((Client) client);
        return 0;
	}

	@Override
	public int createFamily(String familyName) {
		Family family = (Family) new FamilyClass(familyName);
		familyList.add(family);
		return 0;
	}


	@Override
	public List<HealthProfessional> getProfessionalList() {
		return this.healthProfessionalList;
	}


	@Override
	public List<Client> getClientList() {
		return this.clientList;
	}


	@Override
	public List<Appointment> getAppointmentList() {
		return this.appointmentList;
	}


	@Override
	public List<Family> getFamilyList() {
		return this.familyList;
	}

		
}