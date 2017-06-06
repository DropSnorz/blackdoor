package com.dropsnorz.blackdoor.level.controllers;

import com.dropsnorz.blackdoor.level.model.CodeFragment;
import com.dropsnorz.blackdoor.level.model.CodeFragmentType;
import com.dropsnorz.blackdoor.level.view.CodeFragmentView;

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

		this.codeFragment = codeFragment;
		view = new CodeFragmentView();
		view.LB_Text.setText(codeFragment.getText());

		if(codeFragment.getType() == CodeFragmentType.TYPE_OPERATOR){
			view.getStyleClass().add("code-fragment-operator");
		}
		if(codeFragment.getType() == CodeFragmentType.TYPE_VARIABLE){
			view.getStyleClass().add("code-fragment-variable");

		}

		CodeFragmentView source = view;
		view.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				/* drag was detected, start a drag-and-drop gesture*/
				/* allow any transfer mode */
				Dragboard db = source.startDragAndDrop(TransferMode.ANY);
				db.setDragView(view.snapshot(null, null));
				/* Put a string on a dragboard */
				ClipboardContent content = new ClipboardContent();
				content.putString(codeFragment.getId());

				db.setContent(content);

				event.consume();
			}
		});
	}

	public CodeFragmentView getView(){
		return view;
	}

}
