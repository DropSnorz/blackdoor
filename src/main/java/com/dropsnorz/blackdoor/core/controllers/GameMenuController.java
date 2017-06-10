package com.dropsnorz.blackdoor.core.controllers;

import java.io.IOException;

import com.dropsnorz.blackdoor.utils.Animations;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class GameMenuController {
	
	private Parent root;
	private GameController gameController;
	
	@FXML
	private Button BT_Play;
	
	public GameMenuController(GameController gameController){
		this.gameController = gameController;
		generateUI();
		
		BT_Play.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				gameController.playGame();
			};
		});
		
		
	}	
	
	public Parent getView(){
		return root;
	}
	
	private void generateUI(){
	    try {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dropsnorz/blackdoor/MenuView.fxml"));
	    	loader.setController(this);
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
