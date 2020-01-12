import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Program implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		HealthUnit healthUnit = new HealthUnitClass();
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String input = scanner.nextLine();
			if(input.isBlank()) {
				scanner.close();
				System.exit(0);
			}
			String commands[] = input.split(" ");
			switch(commands[0]) {
			case "RP":
				commandRP(healthUnit, commands);
			    break;
			case "RU":
				commandRU(healthUnit, commands);
			    break;
			case "RF":
				commandRF(healthUnit, commands);
			    break;	
			case "AF":
				commandAF(healthUnit, commands);
			    break;
			case "DF":
				commandDF(healthUnit, commands);
			    break;
			case "LP":
				commandLP(healthUnit);
			    break;
			case "LU":
				commandLU(healthUnit);
			    break;
			case "LF":
				commandLF(healthUnit);
			    break;
			case "MF":
				commandMF(healthUnit, commands);
				break;
			case "MC":
				commandMC(healthUnit, scanner, commands);
			    break;
			case "CC":
				commandCC(healthUnit, commands);
			    break;
			case "LCU":
				commandLCU(healthUnit, commands);
			    break;
			case "LCF":
				commandLCF(healthUnit, commands);
				break;
			case "LSP":
				commandLSP(healthUnit, commands);
			    break;
			case "LMS":
				commandLMS(healthUnit, commands);
				break;
			case "G":
				commandG(healthUnit);
				break;
			case "L":
				commandL(healthUnit);
			    break;
			default:
				System.out.println("Instrução inválida");
			}
		}
	}
    
		   			    
	private static void commandRP(HealthUnit healthUnit, String[] commands) {
		String professionalCat = commands[1];
		String professionalName = commands[2];
		if(healthUnit.hasProfessional(professionalCat, professionalName)) {
			System.out.println("Profissional existente.");
					}
		else if (!healthUnit.categoryExists(professionalCat)){
			System.out.println("Categoria inexistente.");	
		}
		else {
			healthUnit.createProfessional(professionalCat, professionalName);
			System.out.println("Profissional registado com sucesso.");
				}
		}
			  	
	private static void commandRU(HealthUnit healthUnit, String[] commands) {
		String clientName = commands[1];
		String clientAgeGroup = commands[2];
		if(healthUnit.hasClient(clientName)) {
			System.out.println("Utente existente.");
				}
		else if(!healthUnit.ageGroupExists(clientAgeGroup)) {
			System.out.println("Faixa etária inexistente.");	
		}
		else {
			healthUnit.createClient(clientName, clientAgeGroup);
			System.out.println("Utente registado com sucesso.");
				}
		}
	
	private static void commandRF(HealthUnit healthUnit, String[] commands) {
		String familyName = commands[1];
		if(healthUnit.familyExists(familyName)) {
			System.out.println("Família existente.");
					}
		else {
			healthUnit.createFamily(familyName);
			System.out.println("Família registada com sucesso.");
				}
		}

	private static void commandAF(HealthUnit healthUnit, String[] commands) {
		String clientName = commands[1];
		String familyName = commands[2];
		if(!healthUnit.hasClient(clientName)) {
			System.out.println("Utente inexistente.");
			}
		else if(!healthUnit.familyExists(familyName)) {
			System.out.println("Família inexistente.");	
			}
		else if(healthUnit.hasFamily(clientName)) {
			System.out.println("Utente pertence a família.");	
			}
		else {
			healthUnit.joinFamily(clientName, familyName);
			System.out.println("Utente associado a família.");
			}
		}

	private static void commandDF(HealthUnit healthUnit, String[] commands) {
		String clientName = commands[1];
		if(healthUnit.hasClient(clientName) == false) {
			System.out.println("Utente inexistente.");
			}
		else if(!healthUnit.hasFamily(clientName)) {
			System.out.println("Utente não pertence a família.");	
			}
		else {
			healthUnit.leaveFamily(clientName);
			System.out.println("Utente desassociado a família.");
		}
	}	
		
	private static void commandLP(HealthUnit healthUnit) {
		if (healthUnit.getProfessionalList().isEmpty()) {
			System.out.println("Sem profissionais registados.");
			}
		else {
			healthUnit.listAllProfessionals();
		}
	}

	private static void commandLU(HealthUnit healthUnit) {
		if (healthUnit.getClientList().isEmpty()) {
			System.out.println("Sem utentes registados.");
		}
		else {
			healthUnit.listAllClients();
		}
	}
	
	
	private static void commandLF(HealthUnit healthUnit) { 
		if (healthUnit.getFamilyList().isEmpty()) {
			System.out.println("Sem famílias registadas.");
		}
		else {
			healthUnit.listAllFamilies();
		}
	}
		
	private static void commandMF(HealthUnit healthUnit, String[] commands) {
		String familyName = commands[1];
		if(healthUnit.familyExists(familyName) == false) {
			System.out.println("Família inexistente.");
		}
		else {
			healthUnit.showFamilyMember(familyName);
		} 			
	}
			
	private static void commandMC(HealthUnit healthUnit, Scanner scanner, String[] commands) {
		String clientName = commands[1];
		if(!healthUnit.hasClient(clientName)) {
			System.out.println("Utente inexistente.");
		} 
		else { 
				String[] parameters = scanner.nextLine().split(" ");			
					String service = parameters[0];
					if (!healthUnit.serviceExists(service)) {
						System.out.println("Serviço inexistente.");
						}
					else {
						String[] parameters1 = scanner.nextLine().split(" ");
						String category = parameters1[0];
						String nomeProfissional = parameters1[1];
						if (!healthUnit.categoryExists(category)) {
							System.out.println("Categoria inexistente.");
						}
						else if (!healthUnit.hasProfessional(category, nomeProfissional)) {
							System.out.println("Profissional de saúde inexistente.");
						}
						else {
							if (!healthUnit.serviceRulesCheck(service, category)) {
								System.out.println("Categoria inválida.");
							}
							else {
								healthUnit.createAppointment(clientName, service, nomeProfissional, category);
								System.out.println("Cuidados marcados com sucesso.");
							}
						}
					}
				}
			}
		
	private static void commandCC(HealthUnit healthUnit, String[] commands) {
		String clientName = commands[1];
		if(healthUnit.hasClient(clientName) == false) {
			System.out.println("Utente inexistente.");
			}
		else if(!healthUnit.clientHasAppointments(clientName)){
			System.out.println("Utente sem cuidados de saúde marcados."); }
		else{
			healthUnit.cancelAppointment(clientName);
			System.out.println("Cuidados de saúde desmarcados com sucesso.");
			}		  
		}
	
	private static void commandLCU(HealthUnit healthUnit, String[] commands) {
		String clientName = commands[1];
		if(!healthUnit.hasClient(clientName)) {
			System.out.println("Utente inexistente.");
			}
		else {
			if(!healthUnit.clientHasAppointments(clientName)) {
				System.out.println("Utente sem cuidados de saúde marcados.");
			}
			healthUnit.listClientAppointments(clientName);
		}
	}		
		
	private static void commandLCF(HealthUnit healthUnit, String[] commands) {
		String familyName = commands[1];
		if(!healthUnit.familyExists(familyName)) {
			System.out.println("Família inexistente.");
			}
		else {
			if (!healthUnit.familyHasAppointments(familyName)) {
				System.out.println("Família sem cuidados de saúde marcados.");
			}
			healthUnit.listFamilyAppointments(familyName);
		}
	}
	
	
	private static void commandLSP(HealthUnit healthUnit, String[] commands) {
		String professionalCat = commands[1];
		String professionalName = commands[2];		
		if(!healthUnit.hasProfessional(professionalCat, professionalName)) {
			System.out.println("Profissional de saúde inexistente.");
			}
		else {
			if (!healthUnit.professionalHasAppointments(professionalCat, professionalName)) {
				System.out.println("Profissional de saúde sem marcações.");
			}
			else {
			healthUnit.listProfessionalAppointments(professionalCat, professionalName);
			}
		}
	}
	
	private static void commandLMS(HealthUnit healthUnit, String[] commands) {
		String service = commands[1];
		if (!healthUnit.serviceExists(service)) {
			System.out.println("Serviço inexistente.");
			}
		else {
			if (!healthUnit.serviceHasAppointments(service)) {
				System.out.println("Serviço sem marcações.");
			}
			else {
				healthUnit.listServiceAppointments(service);
			}
		}
	}
		
	private static void commandG(HealthUnit healthUnit) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("file.save");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(healthUnit);
			objectOutputStream.close();
			fileOutputStream.close();
			System.out.println("Unidade de saúde gravada.");
		} catch(IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Ocorreu um erro na gravação");
			}
		}
	
	private static void commandL(HealthUnit healthUnit) {
		try {
			FileInputStream fileInputStream = new FileInputStream("file.save");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			healthUnit = (HealthUnit)objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
			System.out.println("Unidade de saúde carregada.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ocorreu um erro no carregamento.");
			return;
		}
	}


}	


