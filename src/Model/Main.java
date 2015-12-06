package Model;

import java.io.IOException;

import Controller.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private AnchorPane rootLayout;

	private Parser p;
	private RootLayoutController rootController;
	private VBox vbox;
	private TextField txtGame;

	/*
	 * se ejecuta al empezar y inicia el metodo initScene()
	 * 
	 * @see initScene()
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("GamesJson");

		initScene();

	}

	/**
	 * Inicia la escena y crea el stage con el rootLayout cargado
	 * 
	 * @see RootLayoutController
	 */
	public void initScene() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("View/rootLayout.fxml"));
		loader.setController(rootController);
		try {
			rootLayout = (AnchorPane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scene scene = new Scene(rootLayout);

		primaryStage.setScene(scene);
		rootController = loader.getController();
		RootLayoutController controller = loader.getController();
		controller.setMain(this);

		primaryStage.show();

	}

	public VBox getVBox() {
		return this.vbox;
	}

	public String getTxtValue() {
		return this.txtGame.getText();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
