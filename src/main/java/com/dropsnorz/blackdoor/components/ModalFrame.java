package com.dropsnorz.blackdoor.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ModalFrame extends BorderPane {
	
	HBox mainNode = new HBox();
	
	public ModalFrame(){
		
		this.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0, 0.8), CornerRadii.EMPTY, Insets.EMPTY)));
		
		mainNode.getChildren().add(new Label("test"));
		mainNode.setAlignment(Pos.CENTER);
		this.setCenter(mainNode);
	}
	
	public void setContent(Node node){
		mainNode.getChildren().add(node);
	}

}
