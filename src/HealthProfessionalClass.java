
public class HealthProfessionalClass extends Person implements HealthProfessional{
	private Category category;

	public HealthProfessionalClass(Category category, String name) {
		super(name);
		this.category = category;
	}

	public String getCategoryName() {
        return this.category.toString();
	}
	
	public Category getCategory() {
        return this.category;
	}
	
}
