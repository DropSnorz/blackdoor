package com.dropsnorz.blackdoor.tutorial.view;

import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;

public class TutorialStepView extends Pane {
	
	double centerX;
	double centerY;

	public TutorialStepView(Node node, double width, double height){
		super();

		Bounds bounds = node.localToScene(node.getBoundsInLocal());
		
		//Pane shade = new Pane();
		this.setMinHeight(height);
		this.setMinWidth(width);

		double x = bounds.getMinX() + (bounds.getWidth() / 2);
		double y = bounds.getMinY() + (bounds.getHeight() / 2);

		centerX = x;
		centerY = y;
		
		
		double x_relative = x / width;
		double y_relative = y / height;
		

		RadialGradient shadePaint = new RadialGradient(
				0,0, x_relative, y_relative, 0.3, true, CycleMethod.NO_CYCLE,
				new Stop(1, Color.rgb(0, 0, 0, 0.85)),
				new Stop(0, Color.TRANSPARENT)
				);


		this.setBackground(
				new Background(
						new BackgroundFill(
								shadePaint, null, new Insets(-10)
								)
						)
				);


	}
	
	public void addLabel(String text, double offsetX, double offsetY){
		
		Label label= new Label(text);
		label.getStyleClass().add("tutorial-label");
		
		label.setLayoutX(centerX + offsetX);
		label.setLayoutY(centerY + offsetY);
		
		this.getChildren().add(label);
	}
}
