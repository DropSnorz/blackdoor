package com.dropsnorz.blackdoor.view;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class InlineCodeView extends Pane {
	
	public Label LB_Code;
	public InlineCodeView(String content){
		super();
		
		LB_Code = new Label(content);
		this.getChildren().add(LB_Code);
		
	}

}
