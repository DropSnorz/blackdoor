package com.dropsnorz.blackdoor.tutorial.controller;

import com.dropsnorz.blackdoor.tutorial.model.TutorialStep;
import com.dropsnorz.blackdoor.tutorial.view.TutorialStepView;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class TutorialStepController {
	
	protected TutorialStepView view;
	protected TutorialControler tutorialControler;
	
	public TutorialStepController(TutorialStep step, Pane parent, TutorialControler tutorialControler){
		
		this.tutorialControler = tutorialControler;
		view = new TutorialStepView(step.getTargetNode(), parent.getWidth(), parent.getHeight() );
	
		view.addLabel(step.getMessage(), step.getOffsetX(), step.getOffsetY());
		view.setOnMouseClicked(new EventHandler<MouseEvent> (){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Click, calling next step");
				tutorialControler.nextStep();
			}
			
		});
	
	}
	
	public Pane getView(){
		return view;
	}

}
