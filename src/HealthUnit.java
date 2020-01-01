import java.util.List;

public interface HealthUnit {

	boolean hasProfessional(Category professionalCat, String professionalName); // Verifica se já existe profissional com determinado nome e cateoria profissional
	
	boolean hasCategory(String professionalCat); // Verifica se existe determinada categoria profissional
	
	int createProfessional(Category professionalCat, String professionalName); // Adiciona novo profissional
	
	int createClient(String clientName, AgeGroup clientAgeGroup); // Adiciona novo utente
	
	int createFamily(String familyName); // Adiciona nova família
	
	boolean hasClient(String clientName); // Verifica se já existe esse cliente pelo seu nome
	
	boolean hasAgeGroup(String clientAgeGroup); // Verifica se existe determinada faixa etária
	
	boolean familyExists(String familyName); // Verifica se existe determinada família
	
	boolean hasFamily(String clientName); // Verifica se determinado cliente tem família associada
	
	
	// Manuseamento das listas:
	
	// Profissionais:

	List<HealthProfessional> getProfessionalList();
	
	
	// Clientes:
	
	List<Client> getClientList();
	
	
	// Consultas:
	
	List<Appointment> getAppointmentList();
	
	
	// Famílias:
	
	List<Family> getFamilyList();
	
	
}
