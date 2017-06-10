package com.dropsnorz.blackdoor.level.controllers;

import java.util.ArrayList;
import java.util.List;

import com.dropsnorz.blackdoor.core.model.Game;
import com.dropsnorz.blackdoor.level.model.CodeFragment;
import com.dropsnorz.blackdoor.level.model.FragmentsManager;
import com.dropsnorz.blackdoor.level.view.DropCodeFragmentView;
import com.dropsnorz.blackdoor.level.view.InlineCodeView;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class DropCodeFragmentController {

	DropCodeFragmentView view;
	DropCodeFragmentController _this = this;
	
	FragmentsManager fragmentsManager;	

	public DropCodeFragmentController(FragmentsManager fragmentsManager){

		view = new DropCodeFragmentView();
		this.fragmentsManager = fragmentsManager;
		
		for(Pane row : view.getRowList()){
			row.setOnDragDropped(new RowDragDroppedEventHandler(row));
			
			row.setOnDragOver(new EventHandler<DragEvent>(){
				@Override
				public void handle(DragEvent arg0) {
					row.setBackground(new Background(new BackgroundFill(Color.rgb(55, 55, 55), CornerRadii.EMPTY, Insets.EMPTY)));
				}
				
			});
			
			row.setOnDragExited(new EventHandler<DragEvent>(){
				@Override
				public void handle(DragEvent arg0) {
					row.setBackground(new Background(new BackgroundFill(Color.rgb(33, 33, 33), CornerRadii.EMPTY, Insets.EMPTY)));
				}
				
			});
		}

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

		
	}
	
	public void removeAllCodeFragments(){
		for(Pane row : view.getRowList()){
			row.getChildren().clear();
		}
	}
	
	public void removeCodeFragment(Node node){
		
		for(Pane row : view.getRowList()){
			row.getChildren().remove(node);
		}
	}

	public ArrayList<CodeFragment> getDroppedCodeFragmentList(){
		
		ArrayList<CodeFragment> list = new ArrayList<CodeFragment>();
		
		for(Pane row : view.getRowList()){
			for(Node node : row.getChildren()){
				if (node instanceof InlineCodeView){
					InlineCodeView inlineCodeView = (InlineCodeView) node;
					CodeFragment fragment = fragmentsManager.getFragmentById(inlineCodeView.getFragmentId());
					list.add(fragment);
				}
			}
		}
		return list;
	}
	public DropCodeFragmentView getView(){
		return view;
	}


	public class RowDragDroppedEventHandler implements EventHandler<DragEvent>{

		private Pane target;
		public RowDragDroppedEventHandler(Pane target){
			this.target = target;
		}

		@Override
		public void handle(DragEvent event) {

			/* data dropped */
			/* if there is a string data on dragboard, read it and use it */
			Dragboard db = event.getDragboard();
			boolean success = false;
			if (db.hasString()) {
				CodeFragment fragment = fragmentsManager.getFragmentById(db.getString());
				
				InlineCodeController inlineCodeController = new InlineCodeController(fragment, _this);
				InlineCodeView codeView = inlineCodeController.getView();
				codeView.setOnDragDropped(new InlineCodeDragDroppedEventHandler(codeView));				

				target.getChildren().add(codeView);


				success = true;
			}
			/* let the source know whether the string was successfully 
			 * transferred and used */
			event.setDropCompleted(success);

			event.consume();

		}
	}


	public class InlineCodeDragDroppedEventHandler implements EventHandler<DragEvent>{

		private Node target;
		
		InlineCodeDragDroppedEventHandler(Node target){
			this.target = target;
		}
		@Override
		public void handle(DragEvent event) {

			//Node target = ((Node) event.getTarget()).getParent().getParent();
			
			/* data dropped */
			/* if there is a string data on dragboard, read it and use it */
			Dragboard db = event.getDragboard();
			boolean success = false;
			if (db.hasString()) {
				CodeFragment fragment = fragmentsManager.getFragmentById(db.getString());
				InlineCodeController inlineCodeController = new InlineCodeController(fragment, _this);
				InlineCodeView codeView = inlineCodeController.getView();
				codeView.setOnDragDropped(new InlineCodeDragDroppedEventHandler(codeView));				
				
				Pane parent = (Pane) target.getParent();
				
				int targetIndex = parent.getChildren().indexOf(target);
				List<Node> nodes = new ArrayList<Node>(parent.getChildren());
				System.out.println(nodes.size());
				nodes.add(targetIndex, codeView);
				
				parent.getChildren().clear();
                parent.getChildren().addAll(nodes);
                
				success = true;
			}
			/* let the source know whether the string was successfully 
			 * transferred and used */
			event.setDropCompleted(success);

			event.consume();

		}
	}

}
