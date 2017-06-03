package com.dropsnorz.blackdoor.level.controllers;

import com.dropsnorz.blackdoor.level.model.CodeFragment;
import com.dropsnorz.blackdoor.level.view.InlineCodeView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class InlineCodeController {
	
	public InlineCodeView view;
	DropCodeFragmentController dropCodeFragmentController;
	
	public InlineCodeController(CodeFragment fragment, DropCodeFragmentController dropCodeFragmentController){
		
		this.dropCodeFragmentController = dropCodeFragmentController;
		view = new InlineCodeView(fragment.getId(), fragment.getText());
		
		view.BT_Delete.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        dropCodeFragmentController.removeCodeFragment(view);
		    }
		});
		
		
	}
	
	public InlineCodeView getView(){
		return view;
	}

}
