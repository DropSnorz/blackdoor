package com.dropsnorz.blackdoor.core.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class GameEndView extends BorderPane{


	public HBox mainPane;
	public Label text;
	public Button BT_Next;


	public GameEndView(){

		super();

		this.getStyleClass().add("back-pane");
		mainPane = new HBox();

		mainPane.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));


		mainPane.getChildren().add(new Label());
		mainPane.setAlignment(Pos.CENTER);
		mainPane.setMaxWidth(400);
		this.setCenter(mainPane);

		text = new Label();
		text.setWrapText(true);
		mainPane.getChildren().add(text);

		HBox bottomPane = new HBox();
		bottomPane.setAlignment(Pos.CENTER_RIGHT);
		bottomPane.setPadding(new Insets(20));
		bottomPane.setSpacing(5);

		BT_Next = new Button("Suivant");
		BT_Next.getStyleClass().add("ui-button");
		bottomPane.getChildren().add(BT_Next);

		this.setBottom(bottomPane);

	}

}
