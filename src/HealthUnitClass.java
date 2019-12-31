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
	}
	

	@Override
	public boolean hasProfessional(String professionalCat, String professionalName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasCategory(String professionalCat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createProfessional(Category professionalCat, String professionalName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasClient(String clientName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasAgeGroup(String clientAgeGroup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean familyExists(String familyName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasFamily(String clientName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createClient(String clientName, AgeGroup clientAgeGroup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createFamily(String familyName) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<HealthProfessional> getProfessionalList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Client> getClientList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Appointment> getAppointmentList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Family> getFamilyList() {
		// TODO Auto-generated method stub
		return null;
	}

		
}