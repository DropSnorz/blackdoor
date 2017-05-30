package com.dropsnorz.blackdoor.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class ResultController {
	
	Node root;
	
	GameLevelController gameLevelController;
	
	@FXML
	Button BT_Continue;
	@FXML
	Button BT_Skip;
	
	
	
	public ResultController(GameLevelController gameLevelController){
		
		this.gameLevelController = gameLevelController;
		
		generateUI();
		
		BT_Skip.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				gameLevelController.hideModal();

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
