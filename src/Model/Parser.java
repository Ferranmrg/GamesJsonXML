package Model;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {
	
	public void getListName(String GameName) {

		String urlString = "https://www.igdb.com/api/v1/games/search?q="+GameName;

		URL url;
		try {

			 url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Authorization", "Token token=\"7dZyUYvHCxVeTtDoJpMLB4uSyvhTBOeAVYTPdH-DLrc\"");

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder responseStrBuilder = new StringBuilder();
			String linea;
			while ((linea = in.readLine()) != null) {
			 responseStrBuilder.append(linea);	
			}
			String responseData = responseStrBuilder.toString();
			JSONParser jsonParser = new JSONParser();
			JSONObject root  = (JSONObject) jsonParser.parse(responseData);
	
			JSONArray posts = (JSONArray) root.get("games");
			
			for (int i = 0; i < posts.size(); i++) {
				JSONObject jsonPost = (JSONObject) posts.get(i);
				System.out.println(jsonPost.get("name"));
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

	}

}
