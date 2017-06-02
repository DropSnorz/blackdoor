package com.dropsnorz.blackdoor.components;

import com.dropsnorz.blackdoor.view.GameView;

import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Tutorial extends Pane {

	public Tutorial(){

	}

	public void displayToolTip(Node node, GameView root){

		
		Bounds boundsInScene = node.localToScene(node.getBoundsInLocal());
		
		Pane mainPane = new Pane();
		
		Pane shade = new Pane();
		shade.setMinSize(50, 50);
		
		double x = boundsInScene.getMinX() + (boundsInScene.getWidth() / 2);
		double y = boundsInScene.getMinY() + (boundsInScene.getHeight() / 2);
		
		double x_relative = x / root.getWidth();
		double y_relative = y / root.getHeight();
        
		RadialGradient shadePaint = new RadialGradient(
				0, 0, x_relative, y_relative, 1, true, CycleMethod.NO_CYCLE,
				new Stop(1, Color.BLACK),
				new Stop(0, Color.TRANSPARENT)
				);

		
		shade.setBackground(
				new Background(
						new BackgroundFill(
								shadePaint, null, new Insets(-10)
								)
						)
				);

		
		// blur helps reduce visible banding of the radial gradient.
		shade.setEffect(new BoxBlur(5, 5, 3));

        //final Circle glass = new Circle(100,100,100);        
		
        //root.setClip(shade);
        
		root.stackView(shade);
		
		

	}

}
