public interface HealthUnit {

	boolean hasProfessional(String professionalCat, String professionalName); // Verifica se já existe profissional com determinado nome e cateoria profissional
	
	boolean hasCategory(String professionalCat); // Verifica se existe determinada categoria profissional
	
	void createProfessional(String professionalCat, String professionalName); // Adiciona novo profissional
	
	boolean hasClient(String clientName); // Verifica se já existe esse cliente pelo seu nome
	
	boolean hasAgeGroup(String clientAgeGroup); // Verifica se existe determinada faixa etária
	
	boolean familyExists(String familyName); // Verifica se existe determinada família
	
	boolean hasFamily(String clientName); // Verifica se determinado cliente tem família associada
	
	
	
	
	
	
	
}
