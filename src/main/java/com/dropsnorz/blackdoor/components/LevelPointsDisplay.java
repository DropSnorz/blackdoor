package com.dropsnorz.blackdoor.components;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class LevelPointsDisplay extends VBox{

	protected Image filledIcon;
	protected Image emptyIcon;
	protected HBox pointsPane;
	protected Label headerLabel;
	
	public LevelPointsDisplay(){
		super();
		
		this.setSpacing(10);
		headerLabel = new Label("Cohérence du virus");
		this.getChildren().add(headerLabel);
		pointsPane = new HBox();
		pointsPane.setSpacing(17);
		
		
		filledIcon = new Image(getClass().getResourceAsStream("/com/dropsnorz/blackdoor/icons/diamond-fill-white-32.png"));	
		emptyIcon = new Image(getClass().getResourceAsStream("/com/dropsnorz/blackdoor/icons/diamond-empty-white-32.png"));	
		
		for(int i = 0; i < 3; i++){
			
			ImageView image = new ImageView(filledIcon);
			pointsPane.getChildren().add(image);
		}
		
		this.getChildren().add(pointsPane);
		
	}
	
	public void setPointsRate(float rate){
		pointsPane.getChildren().clear();
		if(rate <= 0){
			ImageView image = new ImageView(emptyIcon);
			pointsPane.getChildren().add(image);
		}
		ImageView image = new ImageView(emptyIcon);
		pointsPane.getChildren().add(image);
		
		if(rate > 0.33){
			pointsPane.getChildren().add(new ImageView(filledIcon));			
		}
		else{
			pointsPane.getChildren().add(new ImageView(emptyIcon));			

		}
		
		if(rate > 0.66){
			pointsPane.getChildren().add(new ImageView(filledIcon));			
		}
		else{
			pointsPane.getChildren().add(new ImageView(emptyIcon));			

		}
		
		
	}
	
}
