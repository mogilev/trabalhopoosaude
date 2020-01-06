
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

   
}
