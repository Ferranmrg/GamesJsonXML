package Model;

import java.util.ArrayList;

public interface ParserInterface {
	/**
	 * 
	 * @author All team, Pair Programming
	 * @param GameName
	 *            03/12/2015.
	 *            get a list with all the results that contains the
	 *            given name
	 */
	public void getListName(String GameName);
	
	/**
	 * 
	 * @author Ferran
	 * @param gameId
	 * @return
	 * 
	 * Return the info of the selected game in the list
	 */
	public ArrayList<String> getGame(long gameId);
}
