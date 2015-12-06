package Model.View;



import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class RootLayoutController {
	@FXML
	private VBox vbox;
	
	/**
	 * Se ejecuta despues de cargar el fxml
	 * 
	 */
	@FXML
	private void initialize() {
	
	}
	/**
	 * Devuelve el VBox de javafx en el se guardaran los label con
	 * los nombres de los videojuegos referentes al que has buscado
	 * @return vbox donde almacenar las label de los nombres de los juegos
	 */
	private VBox getVbox(){
		return vbox;
	}

}
