package Model;

public interface FileXMLInterface {
	/**
	 * @author Javier
	 * @param game
	 * Add the game to favorites
	 */
	public void createXML(Game game);
	/**
	 * @author Javier
	 * @return
	 * Read Favorites and return a string with the info
	 */
	public String readXML() ;
}
