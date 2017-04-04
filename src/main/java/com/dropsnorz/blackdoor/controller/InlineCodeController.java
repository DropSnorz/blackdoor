package com.dropsnorz.blackdoor.controller;

import com.dropsnorz.blackdoor.view.InlineCodeView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class InlineCodeController {
	
	public InlineCodeView view;
	DropCodeFragmentController dropCodeFragmentController;
	
	public InlineCodeController(String text, DropCodeFragmentController dropCodeFragmentController){
		
		this.dropCodeFragmentController = dropCodeFragmentController;
		view = new InlineCodeView(text);
		
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
