package com.dropsnorz.blackdoor.controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

public class ResultController {
	
	Node root;
	
	public ResultController(){
		
		generateUI();
		
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
