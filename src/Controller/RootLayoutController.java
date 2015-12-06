package Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

import Model.Game;
import Model.Main;
import Model.Parser;

public class RootLayoutController {
	@FXML
	private VBox vbox;
	private String gameName;
	private Parser parser;
	private Main main;
	@FXML
	private TextField txtGame;

	/**
	 * Se ejecuta despues de cargar el fxml
	 * 
	 */
	@FXML
	private void initialize() {

	}

	@FXML
	public void handleSearch() {
		main = new Main();
		this.gameName = txtGame.getText();
		gameName = gameName.replace(" ", "-");
		parser = new Parser(this.main);
		vbox.getChildren().remove(0, vbox.getChildren().size());
		ArrayList<Game> al = parser.getListName(gameName);
		for (int i = 0; i < al.size(); i++) {
			addGame(al.get(i));
		}
	}

	@FXML
	public void setMain(Main main) {
		this.main = main;

	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}

	public void addGame(Game game) {

		Label nombre = new Label();
		nombre.setText(game.getName());
		parser = new Parser(this.main);
		nombre.setOnMouseClicked(new EventHandler<MouseEvent>() {
			/**
			 * Method to Label OnClick
			 */
			@Override
			public void handle(MouseEvent e) {
				ArrayList<String> getGame = parser.getGame(game.getId());
				vbox.getChildren().remove(0, vbox.getChildren().size());
				for (int i = 0; i < getGame.size(); i++) {
					Label l = new Label();
					l.setText(getGame.get(i));
					l.setWrapText(true);
					vbox.getChildren().add(l);
				}
				// vbox.getChildren().add(nombre);

				Button button = new Button("Add to favorites");

				/**
				 * Button OnClick Event
				 */
				button.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						System.out.println("PUTA");

					}

				});
				vbox.getChildren().add(button);
			}
		});
		vbox.getChildren().add(nombre);
	}
}