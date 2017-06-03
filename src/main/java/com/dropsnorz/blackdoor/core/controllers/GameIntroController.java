package com.dropsnorz.blackdoor.core.controllers;

import java.io.IOException;

import com.dropsnorz.blackdoor.utils.Animations;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameIntroController {
	
	private Parent root;
	
	@FXML
	private Label LB_Loading;
	
	public GameIntroController(){
		generateUI();
	}
	
	public void animateUI(){
		Animations.labelTypingAnimation(LB_Loading, "loading...");

	}
	
	public Parent getView(){
		return root;
	}
	
	private void generateUI(){
	    try {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dropsnorz/blackdoor/IntroView.fxml"));
	    	loader.setController(this);
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
