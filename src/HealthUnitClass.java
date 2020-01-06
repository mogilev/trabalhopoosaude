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
    	for(Client client : this.getClientList()) {
            if(client.getName()== clientName){
                if (client.getFamily() != null){
                    return true; 
                }     
            }
    	}	
        return false;
    }
	
	
	public int joinFamily(String clientName, String familyName) {
        for(Client client : this.getClientList()) {
            if (client.getName() == clientName){
                for (Family family : this.getFamilyList()){
                    if (family.getFamilyName() == familyName){
                        client.setFamily(family); 
                    }
                }
            }
        }
        return 0;
	}

	
    public int leaveFamily(String clientName){
        for(Client client : this.getClientList()) {
            if (client.getName() == clientName){
                client.setFamily(null); 
            }
        } 
        return 0;
    }
	
    
    public void showProfessionals(){
        for (HealthProfessional healthProfessional : this.getProfessionalList()){
            System.out.println(healthProfessional.getName() + " " + healthProfessional.getCategory()); 
        }
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


	@Override
	public boolean serviceExists(String serviceName) {
        for (Category category : Category.values()) {
            if (category.name().equals(serviceName)) {
                return true;
                }
            }
        return false;
    }


	@Override
	public boolean clientHasAppointments(String clientName) {
	    	for(Appointment appointment : this.getAppointmentList()) {
	            if(appointment.getClientName() == clientName){
	                    return true; 
	                }     
	            }
	    	return false;
	    }


	@Override
	public int createAppointment(String clientName, String serviceName, String healthProfessionalName, String healthProfessionalCategory ) {
		// TODO Auto-generated method stub
		for (Client client : this.clientList) {
			if (client.getName() == clientName) {				
				for (HealthProfessional healthProfessional : this.healthProfessionalList) {
					if(healthProfessional.getName() == healthProfessionalName && healthProfessional.getCategory() == healthProfessionalCategory) {
						Service service = Service.valueOf(serviceName);
						Appointment appointment = (Appointment) new AppointmentClass(client, service, healthProfessional);
						appointmentList.add((Appointment) appointment);			
						}
					}
				}
			}
		return 0;
		}
	

	@Override
	public int cancelAppointment(String clientName) {
		for (Appointment appointment : this.getAppointmentList()) {
			if (appointment.getClientName() == clientName)
				this.appointmentList.remove(appointment);
		}		
		return 0;
	}

	

	
		
}