package com.dropsnorz.blackdoor.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class CourseController {
	
	private Parent root;

	@FXML
	WebView webView;
	
	public CourseController(String courseId){
		generateUI();
		
		 Stage stage = new Stage();
         stage.setTitle("Documentation");
         stage.setScene(new Scene(root, 320, 500));
         stage.show();
         
         WebEngine webEngine = webView.getEngine();
         //TODO load course by courseId
         webEngine.load(getClass().getResource("/com/dropsnorz/blackdoor/web/courses/index.html").toExternalForm());
         
		
	}
	
	public Parent getView(){
		return root;
	}
	
	private void generateUI(){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dropsnorz/blackdoor/CourseView.fxml"));
			loader.setController(this);
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
