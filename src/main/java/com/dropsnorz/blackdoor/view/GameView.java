package com.dropsnorz.blackdoor.view;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class GameView extends AnchorPane {
	
	Pane gamePane;
	
	public GameView(){
		super();
		gamePane = new StackPane();
		
	}
	
	public void stackView(Node node){
		setTopAnchor(node, 0.0);
		setBottomAnchor(node, 0.0);
		setLeftAnchor(node, 0.2);
		setRightAnchor(node, 0.2);	
		this.getChildren().add(node);
		
	}
	

}
