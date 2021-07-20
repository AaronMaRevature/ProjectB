package fixtures;

public class Fixture {

	private String name; 
	private String shortDescription;
	private String longDescription;
	
	public Fixture(String name2, String shortDescription2, String longDescription2) {
		this.setName(name2);
		this.setShortDescription(shortDescription2);
		this.setLongDescription(longDescription2);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	
	
	
	
	
	
	
	
	
	
}
