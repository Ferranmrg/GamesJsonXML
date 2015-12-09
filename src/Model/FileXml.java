package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class FileXml {
	XStream xstream = new XStream(new DomDriver());

	public void createXML(Game game) {
		xstream.alias("Juego", Game.class);
		try {
			ArrayList<Game> listaFav = (ArrayList) xstream.fromXML(new FileInputStream("res/Favoritos.xml"));
			
			// See if the game already in the list
			ArrayList<String> names = new ArrayList<String>();
			for(Game g : listaFav){
				names.add(g.getName());
			}
			// ------------------------------------
			
			if (names.contains(game.getName())) {
				System.out.println("Game already in the list");
			} else {
				listaFav.add(game);
				System.out.println("New Game add to Favorites");
			}
			xstream.toXML(listaFav, new FileOutputStream("res/Favoritos.xml"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String readXML() {
		xstream.alias("Juego", Game.class);
		Main main = new Main();
		Parser p = new Parser(main);
		StringBuilder stb = new StringBuilder();
		String resul = "";
		try {
			ArrayList<Game> listaFav = (ArrayList) xstream.fromXML(new FileInputStream("res/Favoritos.xml"));
			for (Game g : listaFav) {
				for(String s : p.getGame(g.getId())){
					stb.append(s+"\n");
				}
			}
			resul = stb.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resul;
	}
}
