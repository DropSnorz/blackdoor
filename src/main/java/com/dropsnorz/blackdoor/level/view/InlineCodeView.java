package com.dropsnorz.blackdoor.level.view;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class InlineCodeView extends StackPane {
	
	public Label LB_Code;
	public HBox editPane;
	public Button BT_Delete;
	
	public String fragmentId;
	
	public InlineCodeView(String fragmentId, String content){
		super();
		
		this.fragmentId = fragmentId;
		StackPane _this = this;
		LB_Code = new Label(content);
		this.getChildren().add(LB_Code);
		
		editPane = new HBox();
		editPane.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 0.2), CornerRadii.EMPTY, Insets.EMPTY)));
		
		BT_Delete = new Button();
		Image deleteImage = new Image(getClass().getResourceAsStream("/com/dropsnorz/blackdoor/icons/delete-gray-16.png"));	
		ImageView deleteImageView = new ImageView(deleteImage);
		Image deleteOverImage = new Image(getClass().getResourceAsStream("/com/dropsnorz/blackdoor/icons/delete-red-16.png"));	
		ImageView deleteOverImageView = new ImageView(deleteOverImage);

		BT_Delete.graphicProperty().bind(
			    Bindings.when(
			    		BT_Delete.hoverProperty()
			    )
			        .then(deleteOverImageView)
			        .otherwise(deleteImageView)
			);
		
		BT_Delete.getStyleClass().add("invisible-button");
		editPane.getChildren().add(BT_Delete);
		editPane.setAlignment(Pos.CENTER);
		
		editPane.visibleProperty().bind(
				Bindings.when(_this.hoverProperty())
				.then(true).otherwise(false));
		this.getChildren().add(editPane);
	}
	
	public String getFragmentId(){
		return fragmentId;
	}
}
