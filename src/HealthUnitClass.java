import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
            if(healthProfessional.getName().equals(professionalName) && healthProfessional.getCategory().contentEquals(professionalCat)){
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
            if(client.getName().contentEquals(clientName)){
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
            if(family.getFamilyName().contentEquals(familyName)){
                return true; 
                }
            }
            return false;
	}

	@Override
	public boolean hasFamily(String clientName) {
    	for(Client client : this.getClientList()) {
            if(client.getName().contentEquals(clientName)){
                if (client.getFamily() != null){
                    return true; 
                }     
            }
    	}	
        return false;
    }
	
	
	public int joinFamily(String clientName, String familyName) {
        for(Client client : this.getClientList()) {
            if (client.getName().contentEquals(clientName)){
                for (Family family : this.getFamilyList()){
                    if (family.getFamilyName().contentEquals(familyName)){
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


	@Override
	public void listarProTeste() {
		for (HealthProfessional healthProfessional : this.getProfessionalList()) {
			System.out.println(healthProfessional.getName() + healthProfessional.getCategory());
		}		

	
		
	}


	@Override
	public void listAllFamilies() {
        Collections.sort(familyList, 
                new Comparator<Family>(){
                    public int compare(Family f1, Family f2) {
                        return f1.getFamilyName().compareTo(f2.getFamilyName());
                    	}
                });
        System.out.println("Lista de Famílias ordenada(método anónimo):");
        this.getFamilyList().forEach((family) -> {
                System.out.println(family.getFamilyName());
            });
	}


	@Override
	public void showFamilyMember(String familyName) {
		// TODO Auto-generated method stub
        List<Client> clients = new ArrayList<Client>();
        for (Family family : this.getFamilyList()){
            if (family.getFamilyName().contentEquals(familyName)){
//            	System.out.println("Aqui entrou");
                for (Client client : this.getClientList()){
 //               	System.out.println("Aqui entrou2");
                    if (client.getFamily() == family){
                        clients.add(client);
 //                       System.out.println("Membro da familia encontrado");
                    }
                }      
            }
        }
        
        Collections.sort(clients, 
        		new Comparator<Client>() {
        			public int compare(Client c1, Client c2) {
        	        if(c1.getAgeGroup().equals(c2.getAgeGroup())){
        	            return c1.getName().compareTo(c2.getName());
        	        }   
        	        else {
        	            return c1.getAgeGroup().compareTo(c2.getAgeGroup());
        	        	}
        			}
        		});
        if (clients.isEmpty()) {
//        	System.out.println("Lista clients vazia!");
        	}
        else {
//        	System.out.println("Lista Ordenada");
        	for (Client client : clients){     	     	
            System.out.println(client.getAgeGroupName() + " " + client.getName());	
        	}
        }
	}


	@Override
	public void testShowAllClients() {
		for (Client client :  this.getClientList())
			if (client.getFamily() == null)
				System.out.println(client.getName());
			else {
				System.out.println(client.getName() + " " + client.getFamilyName());
			}
	}


	@Override
	public void listAllClients() {
	        Collections.sort(clientList, 
	        		new Comparator<Client>() {
	        		public int compare(Client c1, Client c2) {
	        			int NameCompare = c1.getName().compareTo(c2.getName()); 
	        		    int AgeCompare = c1.getAgeGroup().compareTo(c2.getAgeGroup()); 
	        		    // 2-level comparison using if-else block - 
	        		    if (AgeCompare == 0) { 
	        		    	return ((NameCompare == 0) ? AgeCompare : NameCompare); 
	        		  } else { 
	        		    	return AgeCompare; 
	        		            }  
	        		        } 
	        	 	}      			
	        );
	        for (Client client :  this.getClientList()){
	        String nome = client.getName();
	        if (this.hasFamily(nome)){
	            System.out.println(client.getFamilyName() + " " + client.getAgeGroup() + " " + client.getName());
	        	}
	        else{
	            System.out.println(client.getAgeGroup() + " " + client.getName());
	        	}
	        }
	    }

	
	
}

			
