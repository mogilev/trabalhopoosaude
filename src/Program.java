import java.util.Scanner;

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
		else if(healthUnit.hasCategory(professionalCat) == false) {
			System.out.println("Categoria inexistente.");	
		}
		else {
		// ver como criar profissional int readerCode = healthUnit.createProfessional(professionalCat, professionalName);
			System.out.println("Profissional registado com sucesso.");
				}
		}
			    
	private static void commandRU(HealthUnit healthUnit, String[] commands) {
		String clientName = commands[1];
		String clientAgeGroup = commands[2];
		if(healthUnit.hasClient(clientName)) {
			System.out.println("Utente existente.");
					}
		else if(healthUnit.hasAgeGroup(clientAgeGroup) == false) {
			System.out.println("Faixa etária inexistente.");	
		}
		else {
			// ver como criar utente int readerCode = HealthUnit.createClient(clientName, clientAgeGroup);
			System.out.println("Utente registado com sucesso.");
				}
		}
	
	private static void commandRF(HealthUnit healthUnit, String[] commands) {
		String familyName = commands[1];
		if(healthUnit.familyExists(familyName)) {
			System.out.println("Família existente.");
					}
		else {
			// ver como criar int familyCode = library.createReader(familyName);
			System.out.println("Família registada com sucesso.");
				}
		}

	
	private static void commandAF(HealthUnit healthUnit, String[] commands) {
		String clientName = commands[1];
		String familyName = commands[2];
		if(healthUnit.hasClient(clientName) == false) {
			System.out.println("Utente inexistente.");
					}
		else if(healthUnit.familyExists(familyName) == false) {
			System.out.println("Família inexistente.");	
		}
		else if(healthUnit.hasFamily(clientName)) {
			System.out.println("Utente pertence a família.");	
		}
		else {
			// ver como associar cliente a família int readerCode = library.createProfessional(professionalCat, professionalName);
			System.out.println("Utente associado a família.");
				}
		}

	
	private static void commandDF(HealthUnit healthUnit, String[] commands) {
		String clientName = commands[1];
		if(healthUnit.hasClient(clientName) == false) {
			System.out.println("Utente inexistente.");
					}
		else if(healthUnit.hasFamily(clientName) == false) {
			System.out.println("Utente não pertence a família.");	
		}
		else {
			// ver como desassociar cliente a família(setfamilyname=0) int readerCode = library.createProfessional(professionalCat, professionalName);
			System.out.println("Utente desassociado a família.");
				}
		}	
	
	private static void commandLP(HealthUnit healthUnit) {
		// TODO 
	/* 
	 * usando o isEmpty
	 * System.out.println("Sem profissionais registados.");
	 */
		}

	private static void commandLU(HealthUnit healthUnit) {
		// TODO 
		/* 
		 * usando o isEmpty
		 * System.out.println("Sem utentes registados.");
		 */
		}
	
	private static void commandLF(HealthUnit healthUnit) {
		// TODO 
		/* 
		 * usando o isEmpty
		 * System.out.println("Sem famílias registadas.");
		 */
		}
	
	private static void commandMF(HealthUnit healthUnit, String[] commands) {
		String familyName = commands[1];
		if(healthUnit.familyExists(familyName) == false) {
			System.out.println("Família inexistente.");
		}
		// TODO 

		}
	
	private static void commandMC(HealthUnit healthUnit, Scanner scanner, String[] commands) {
		String clientName = commands[1];
		if(healthUnit.hasClient(clientName) == false) {
			System.out.println("Utente inexistente.");
		}
		// TODO 
/*		else {
			String[] parameters = scanner.nextLine().split(" ");
			String 
			} */
		}

		
	private static void commandCC(HealthUnit healthUnit, String[] commands) {
		String clientName = commands[1];
		if(healthUnit.hasClient(clientName) == false) {
			System.out.println("Utente inexistente.");
			}
		// TODO 
		/* else if(){
		 * 			System.out.println("Utente sem cuidados de saúde marcados.");}
		 * else{
		 * 			System.out.println("Cuidados de saúde desmarcados com sucesso.");}
		 * 
		 */ 
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
	
