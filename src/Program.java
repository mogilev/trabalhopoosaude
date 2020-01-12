import java.util.Scanner;
import java.util.Collections;
import java.util.List;

public class Program {
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
			case "LSP":
				commandLSP(healthUnit, commands);
			    break;
			case "LMS":
				commandLMS(healthUnit, commands);
			case "G":
				commandG(healthUnit);
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
/*ver se funca int cliente = */healthUnit.createClient(clientName, clientAgeGroup);
			System.out.println("Utente registado com sucesso.");
				}
		}
	
	private static void commandRF(HealthUnit healthUnit, String[] commands) {
		String familyName = commands[1];
		if(healthUnit.familyExists(familyName)) {
			System.out.println("Família existente.");
					}
		else {/* 
ver se funca int familyCode =*/ healthUnit.createFamily(familyName);
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
			System.out.println("Sem profissionais registados");
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
			System.out.println("Sem famílias registadas");
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
	//		healthUnit.testShowAllClients();
		} 			
	}
	
		
	private static void commandMC(HealthUnit healthUnit, Scanner scanner, String[] commands) {
		String clientName = commands[1];
		if(!healthUnit.hasClient(clientName)) {
			System.out.println("Utente inexistente.");
		} 
		else { //TODO
//			boolean precConsulta = false; //ver se é por aqui
//			boolean precCirurgia = false; //ver se é por aqui
//			while(scanner.hasNextLine()) {
//				String input = scanner.nextLine();
				String[] parameters = scanner.nextLine().split(" ");
	//			if(!input.isBlank()) {
					
					String service = parameters[0];
					if (!healthUnit.serviceExists(service)) {
						System.out.println("Serviço inexistente.");
						}
					else {
						System.out.println("Serviço existente.");
						String[] parameters1 = scanner.nextLine().split(" ");
						String category = parameters1[0]; //antes era "categoria", confirmar se continua a funcionar
						String nomeProfissional = parameters1[1];
						if (!healthUnit.categoryExists(category)) {
							System.out.println("Categoria inexistente.");
						}
						else if (!healthUnit.hasProfessional(category, nomeProfissional)) {
							System.out.println("Profissional de saúde inexistente.");
//						}
					}
						else {
							System.out.println("Profissional de saúde existente.");
							if (!healthUnit.serviceRulesCheck(service, category)) {
								System.out.println("Categoria inválida.");
							}
							else {
								System.out.println("Categoria válida.");
								
							}
						}
//						String[] parameters1 = scanner.nextLine().split(" ");
//						String categoria = parameters1[0];
//						String nomeProfissional = parameters1[1];
//						if (!healthUnit.categoryExists(categoria)) {
//							System.out.println("Categoria inexistente.");
//						}
//						else if (!healthUnit.hasProfessional(categoria, nomeProfissional)) {
//							System.out.println("Profissional de saúde inexistente.");
//						}
//						else {
							// confirmar se o profissional pode realizar o acto 
							// System.out.println("Categoria inválida.");
//						if (service == "Consulta" || service == "Enfermagem") {	
							//marcar consulta aqui
//							precConsulta = true;
//						}
//						else { //cirurgia, onde é necessário verificar precedência
//							if (precConsulta == true) {
							// marcar cirurgia aqui
//								precCirurgia = true;
//							}
//						}}
//					}}
				
			//necessário confirmar as precedências
			 } 
				//}
	}}


		
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
		if(healthUnit.hasClient(clientName) == false) {
			System.out.println("Utente inexistente.");
			}
		// TODO 
		/* else if(){
		 * 			System.out.println("Utente sem cuidados de saúde marcados.");}
		 * else{
		 * 	}
		 * 
		 */ 
			}		
	
	private static void commandLCF(HealthUnit healthUnit, String[] commands) {
		String familyName = commands[1];
		if(healthUnit.familyExists(familyName) == false) {
			System.out.println("Família inexistente.");
			}
		// TODO 
		/* else if(){
		 * 			System.out.println("Família sem cuidados de saúde marcados.");}
		 * else{
		 * 	}
		 * 
		 */ 
			}
	
	private static void commandLSP(HealthUnit healthUnit, String[] commands) {
		String professionalCat = commands[1];
		String professionalName = commands[2];		
		if(healthUnit.hasProfessional(professionalCat, professionalName) == false) {
			System.out.println("Profissional de saúde inexistente.");
			}
		// TODO 
		/* else if(){
		 * 			System.out.println("Profissional de saúde sem marcações.");}
		 * else{
		 * 	}
		 * 
		 */ 
			}
	
	private static void commandLMS(HealthUnit healthUnit, String[] commands) {
		// TODO 
		/* if(){
		 * 		System.out.println("Serviço inexistente");}
		 * else if(){
		 * 			System.out.println("Serviço sem marcações");}
		 * else{
		 * 	}
		 * 
		 */ 
			}
		
	private static void commandG(HealthUnit healthUnit) {
		
		// TODO 

			}
	
	private static void commandL(HealthUnit healthUnit) {
		// TODO 
	}
}	
	
