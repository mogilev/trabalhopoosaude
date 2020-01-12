import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public interface HealthUnit {

	boolean hasProfessional(String professionalCat, String professionalName); // Verifica se já existe profissional com determinado nome e categoria profissional
	
	boolean categoryExists(String professionalCat); // Verifica se existe determinada categoria profissional
	
	int createProfessional(String professionalCat, String professionalName); // Adiciona novo profissional
	
	int createClient(String clientName, String clientAgeGroup); // Adiciona novo utente
	
	int createFamily(String familyName); // Adiciona nova família
	
	boolean hasClient(String clientName); // Verifica se já existe esse cliente pelo seu nome
	
	boolean ageGroupExists(String clientAgeGroup); // Verifica se existe determinada faixa etária
	
	boolean familyExists(String familyName); // Verifica se existe determinada família
	
	boolean hasFamily(String clientName); // Verifica se determinado cliente tem família associada
	
	int joinFamily(String clientName, String familyName); // Associa um utente a uma família
	
	int leaveFamily(String clientName); // Retira a associação de um utente a família
	
    void showProfessionals();
    
    boolean serviceExists(String serviceName); // Verifica se existe determinado serviço médico
	
    boolean clientHasAppointments (String clientName);
    
    boolean familyHasAppointments (String clientName);
    
    boolean professionalHasAppointments (String professionalCat, String professionalName);
    
    boolean serviceRulesCheck(String service, String category);
    
    int createAppointment(String clientName,String serviceName,String healthProfessionalName, String healthProfessionalCategory );

    int cancelAppointment(String clientName);
    
    void listAllFamilies();
    
    void listAllClients();
    
    void listAllProfessionals();
    
    void listClientAppointments(String clientName);
    
	void listFamilyAppointments(String familyName);
	
	void listProfessionalAppointments(String professionalCat, String professionalName);
    
    void showFamilyMember(String familyName);
    
    void testShowAllClients(); //verificar se é necessário
    
    
    
	// Manuseamento das listas:
	
	// Profissionais:

	List<HealthProfessional> getProfessionalList();
	
	// Clientes:
	
	List<Client> getClientList();
	
	
	// Consultas:
	
	List<Appointment> getAppointmentList();
	
	
	// Famílias:
	
	List<Family> getFamilyList();
	
	
	// Serializable
	

	
}
