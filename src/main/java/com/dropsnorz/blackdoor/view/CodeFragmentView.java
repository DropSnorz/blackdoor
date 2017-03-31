package com.dropsnorz.blackdoor.view;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

public class CodeFragmentView extends Pane{
	
	public Label LB_Text;
	
	public CodeFragmentView(){
		
		super();
		LB_Text = new Label ("some code here");
		this.getChildren().add(LB_Text);
		
		CodeFragmentView source = this;
		
		
		
	}
	
	

	

}
