
public class AppointmentClass implements Appointment {
	private Client client;
	private Service service;
	private HealthProfessional healthProfessional;
	
    public AppointmentClass(Client client, Service service, HealthProfessional healthProfessional) {
        this.client = client;
        this.service = service;
        this.healthProfessional = healthProfessional;
    }

	public String getClientName() {
		return this.client.getName();
	}
	
	
	public Service getService() {
		return this.service;
	}

	public HealthProfessional getHealthProfessional() {
		return this.healthProfessional;
	}

	@Override
	public Client getClient() {
		return this.client;
	}
   
}
