package com.dropsnorz.blackdoor.level.view;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class DropCodeFragmentView extends VBox{
	
	protected ArrayList<FlowPane> flowPaneList;
	
	public DropCodeFragmentView(){
		super();
		
		flowPaneList = new ArrayList<FlowPane>();
		
		int i;
		for(i=0; i < 5; i++){
			FlowPane currentFlowPane = new FlowPane();
			currentFlowPane.setVgap(4);
			currentFlowPane.setHgap(4);
			currentFlowPane.setMinHeight(28);
			currentFlowPane.getStyleClass().add("code-row");
			this.getChildren().add(currentFlowPane);
			flowPaneList.add(currentFlowPane);
		}
		
		this.setId("drop-code-area");
		this.setMinHeight(165);
		this.setSpacing(5);
		this.setPadding(new Insets(5, 0, 5, 70));
		
	}
	
	public ArrayList<FlowPane>getRowList(){
		return flowPaneList;
	}

}
