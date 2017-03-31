package com.dropsnorz.blackdoor.controller;

import com.dropsnorz.blackdoor.view.DropCodeFragmentView;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class DropCodeFragmentController {
	
	DropCodeFragmentView view;
	
	public DropCodeFragmentController(){
		
		view = new DropCodeFragmentView();
		
		DropCodeFragmentView target = view;
		
		view.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        /* data is dragged over the target */
		        /* accept it only if it is not dragged from the same node 
		         * and if it has a string data */
		        if (event.getGestureSource() != target &&
		                event.getDragboard().hasString()) {
		            /* allow for both copying and moving, whatever user chooses */
		            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		        }
		        
		        event.consume();
		    }
		});
		
		view.setOnDragDropped(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
	        	System.out.println("Drop event released !");
		        /* data dropped */
		        /* if there is a string data on dragboard, read it and use it */
		        Dragboard db = event.getDragboard();
		        boolean success = false;
		        if (db.hasString()) {
		        	System.out.println("Dropped fragment !");
		        	target.getChildren().add(new Label(db.getString()));
		         
		        	success = true;
		        }
		        /* let the source know whether the string was successfully 
		         * transferred and used */
		        event.setDropCompleted(success);
		        
		        event.consume();
		     }
		});
		
	}
	
	public DropCodeFragmentView getView(){
		return view;
	}

}
