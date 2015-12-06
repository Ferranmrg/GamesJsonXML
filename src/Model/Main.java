package Model;

import java.io.IOException;

import Model.View.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage primaryStage;
	private AnchorPane rootLayout;

	private RootLayoutController rootController;
	
	
	/*
	 *se ejecuta al empezar y inicia el metodo initScene()
	 *@see initScene()
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("GamesJson");
		
		
		initScene();
				
	}
	
	/**
	 * Inicia la escena y crea el stage con el rootLayout cargado
	 * @see RootLayoutController
	 */
	public void initScene(){
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
        
        //pasar metodos de controler de esta clase
        // no funciona because reasons
        // this no esta cogiendo la clase bien (?)
        //rootController.setMain(null);

        primaryStage.show();
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Parser p = new Parser();
		p.getListName("Starcraft");
		launch(args);
	
	}
}

