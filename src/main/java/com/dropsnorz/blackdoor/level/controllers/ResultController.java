package com.dropsnorz.blackdoor.level.controllers;

import java.io.IOException;

import com.dropsnorz.blackdoor.core.model.Game;
import com.dropsnorz.blackdoor.level.model.Dialog;
import com.dropsnorz.blackdoor.level.model.GameLevel;
import com.dropsnorz.blackdoor.utils.ResourceResolver;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class ResultController {

	protected Node root;

	protected GameLevelController gameLevelController;
	protected Game game;
	protected GameLevel gameLevel;

	@FXML
	VBox dialogPane;
	@FXML
	WebView resultWebView;



	public ResultController(GameLevelController gameLevelController, Game game){

		this.gameLevelController = gameLevelController;
		this.game = game;
		this.gameLevel = game.getCurrentGameLevel();

		generateUI();

		WebEngine webEngine = resultWebView.getEngine();
		//TODO load course by courseId
		webEngine.load(getClass().getResource(ResourceResolver.getLevelResultUri(gameLevel.getResult())).toExternalForm());


		Button BT_Skip = (Button) generateDialogButton();
		BT_Skip.setText("Ne rien faire !");

		dialogPane.getChildren().add(BT_Skip);


		BT_Skip.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				gameLevelController.hideModal();

			};
		});


		for(Dialog dialog : gameLevel.getDialogs()){
			Button button = (Button) generateDialogButton();

			button.setText(dialog.getText());

			dialogPane.getChildren().add(button);


			button.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					game.getKeywordManager().spawnKeywords(dialog);

					if(!gameLevel.getId().equals("level9-gps") && !gameLevel.getId().equals("level9-message")){

						gameLevelController.hideModal();
						gameLevelController.nextLevel();
					}
					
					else{
						
						gameLevelController.hideModal();
						gameLevelController.endGame();
					}


				};

			});

		}

	}

	public Node getView(){
		return root;
	}

	private void generateUI(){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dropsnorz/blackdoor/ResultView.fxml"));
			loader.setController(this);
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Node generateDialogButton(){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dropsnorz/blackdoor/DialogView.fxml"));
			loader.setController(this);
			return loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
