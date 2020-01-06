
public class HealthProfessionalClass extends Person implements HealthProfessional{
	private Category category;

	public HealthProfessionalClass(Category category, String name) {
		super(name);
		this.category = category;
	}

	public String getCategory() {
        return this.category.toString();
	}
	
	
}
