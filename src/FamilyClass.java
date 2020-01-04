
public class FamilyClass implements Family {
	String nome;

	public FamilyClass(String nome) {
		this.nome = nome;
	}

	@Override
	public String getFamilyName() {
		return this.nome;
	}
	
}
