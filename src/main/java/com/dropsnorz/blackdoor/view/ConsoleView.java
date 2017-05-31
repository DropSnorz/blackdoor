package com.dropsnorz.blackdoor.view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ConsoleView extends VBox {
	
	public ConsoleView(){
		super();
	}
	
	public void appendText(String text){
		this.getChildren().add(new Label(text));
	}

}
