package com.dropsnorz.blackdoor;

import com.dropsnorz.blackdoor.controller.GameController;
import com.dropsnorz.blackdoor.controller.GameIntroController;
import com.dropsnorz.blackdoor.controller.GameMenuController;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application 
{

	/**
	 * En javafx start() lance l'application
	 *
	 * On cree le SceneGraph de l'application ici
	 * @see http://docs.oracle.com/javafx/2/scenegraph/jfxpub-scenegraph.htm
	 * 
	 */
	@Override
	public void start(Stage stage) throws Exception 
	{
		// Nom de la fenetre
		stage.setTitle("BlackDoor");
		stage.setResizable(true);
		
		GameController gameController = new GameController();
	    
		Scene scene = new Scene( gameController.getView(), 1000, 600 );
		String css = App.class.getResource("/resources/style.css").toExternalForm();
		String javaCss = App.class.getResource("/resources/java-keyword.css").toExternalForm();

		scene.getStylesheets().clear();
		scene.getStylesheets().add(css);
		scene.getStylesheets().add(javaCss);


		stage.setScene( scene );
		stage.show();
		
	}

	public static void main(String[] args) 
	{
		Application.launch(args);
	}
}
