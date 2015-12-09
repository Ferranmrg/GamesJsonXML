package Model;

/**
 * 
 * @author Pedro
 * 
 *         Game object, just contains the name and id
 *
 */
public class Game {
	private String name;
	private long id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}
}
