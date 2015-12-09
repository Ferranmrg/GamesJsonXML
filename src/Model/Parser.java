package Model;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Parser {
	Main main;

	public Parser(Main main) {
		this.main = main;
	}
	/**
	 * 
	 * @param GameName
	 * @return A list with the games that contains the given game name
	 * 
	 * Method to generate the list of games
	 */
	public ArrayList<Game> getListName(String GameName) {

		String urlString = "https://www.igdb.com/api/v1/games/search?q=" + GameName;
		ArrayList<Game> al = null;
		URL url;
		try {

			url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Authorization",
					"Token token=\"7dZyUYvHCxVeTtDoJpMLB4uSyvhTBOeAVYTPdH-DLrc\"");

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder responseStrBuilder = new StringBuilder();
			String linea;
			while ((linea = in.readLine()) != null) {
				responseStrBuilder.append(linea);
			}
			String responseData = responseStrBuilder.toString();
			JSONParser jsonParser = new JSONParser();
			JSONObject root = (JSONObject) jsonParser.parse(responseData);

			JSONArray posts = (JSONArray) root.get("games");
			
			// ----Values we get to show------
			al = new ArrayList<Game>();
			for (int i = 0; i < posts.size(); i++) {
				JSONObject jsonPost = (JSONObject) posts.get(i);
				// Put them into a new Game object
				Game game = new Game();
				game.setName((String) jsonPost.get("name"));
				game.setId((long) jsonPost.get("id"));
				// add to the list for the return
				al.add(game);
			// ---------------------------------
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

	public ArrayList<String> getGame(long gameId) {
		String urlString = "https://www.igdb.com/api/v1/games/" + gameId;
		ArrayList<String> al = null;
		URL url;
		try {

			url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Authorization",
					"Token token=\"7dZyUYvHCxVeTtDoJpMLB4uSyvhTBOeAVYTPdH-DLrc\"");

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder responseStrBuilder = new StringBuilder();
			String linea;
			while ((linea = in.readLine()) != null) {
				responseStrBuilder.append(linea);
			}
			String responseData = responseStrBuilder.toString();
			JSONParser jsonParser = new JSONParser();
			JSONObject root = (JSONObject) jsonParser.parse(responseData);
			JSONObject game = (JSONObject) root.get("game");
			
		
			
			al = new ArrayList<String>();
			
			// ---Values we get to show-----
			al.add((String) game.get("name"));
			al.add((String) game.get("release_date"));
			al.add((String) game.get("summary"));
			
			JSONArray genres = (JSONArray) game.get("genres");
			for (int i = 0; i < genres.size(); i++) {
				JSONObject gen = (JSONObject) genres.get(i);
				al.add((String) gen.get("name"));
			}
			//-----------------------------

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.err.println("Valor no encontrado");

		}
		return al;
	}
}
