package com.dropsnorz.blackdoor.controller;

import com.dropsnorz.blackdoor.model.CodeFragment;
import com.dropsnorz.blackdoor.view.CodeFragmentView;

import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;

public class CodeFragmentController {
	
	CodeFragmentView view;
	CodeFragment codeFragment;
	
	public CodeFragmentController(CodeFragment codeFragment){
		
		view = new CodeFragmentView();
		view.LB_Text.setText(codeFragment.getText());
		
		CodeFragmentView source = view;
		view.setOnDragDetected(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent event) {
		        /* drag was detected, start a drag-and-drop gesture*/
		        /* allow any transfer mode */
		        Dragboard db = source.startDragAndDrop(TransferMode.ANY);
		        db.setDragView(new Text(view.LB_Text.getText()).snapshot(null, null));
		        /* Put a string on a dragboard */
		        ClipboardContent content = new ClipboardContent();
		        content.putString(source.LB_Text.getText());
		        
		        db.setContent(content);
		        
		        event.consume();
		    }
		});
	}
	
	public CodeFragmentView getView(){
		return view;
	}

}
