/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19032473, Aug 14, 2020 3:32:10 PM
 */

/**
 * @author 19032473
 *
 */
public class Bike {
	private String id;
	private String name;
	private int unit ;
	
	public Bike(String id, String name, int unit) {
		this.id = id;
		this.name = name;
		this.unit = unit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}
	public String toString() {
		
		// Write your codes here
	        return String.format("%-10s %-30s %-10d", getId(),
	                getName(), getUnit());
	    }
	
	
}
