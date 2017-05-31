package com.dropsnorz.blackdoor.controller;

import java.io.IOException;

import com.dropsnorz.blackdoor.model.GameLevel;
import com.dropsnorz.blackdoor.utils.ResourceResolver;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class ResultController {
	
	protected Node root;
	
	protected GameLevelController gameLevelController;
	protected GameLevel gameLevel;
	
	@FXML
	Button BT_Continue;
	@FXML
	Button BT_Skip;
	@FXML
	WebView resultWebView;
	
	
	
	public ResultController(GameLevelController gameLevelController, GameLevel gameLevel){
		
		this.gameLevelController = gameLevelController;
		this.gameLevel = gameLevel;
		
		generateUI();
		
		 WebEngine webEngine = resultWebView.getEngine();
         //TODO load course by courseId
         webEngine.load(getClass().getResource(ResourceResolver.getLevelResultUri(gameLevel.getId())).toExternalForm());
         
		
		BT_Skip.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				gameLevelController.hideModal();

			};
		});
		
		BT_Continue.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				gameLevelController.hideModal();
				gameLevelController.nextLevel();

			};
		});
		
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

}
