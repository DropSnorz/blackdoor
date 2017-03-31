package com.dropsnorz.blackdoor.view;

import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class DropCodeFragmentView extends FlowPane{
	
	public DropCodeFragmentView(){
		super();
		
		this.setId("drop-code-area");
		this.setMinHeight(100);
		this.setPadding(new Insets(5, 0, 5, 0));
		this.setVgap(4);
		this.setHgap(4);
	}

}
