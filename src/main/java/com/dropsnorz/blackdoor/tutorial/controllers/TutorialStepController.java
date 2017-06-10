package com.dropsnorz.blackdoor.tutorial.controllers;

import com.dropsnorz.blackdoor.tutorial.model.TutorialStep;
import com.dropsnorz.blackdoor.tutorial.view.TutorialStepView;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class TutorialStepController {
	
	protected TutorialStepView view;
	protected TutorialController tutorialControler;
	
	public TutorialStepController(TutorialStep step, Pane parent, TutorialController tutorialControler){
		
		this.tutorialControler = tutorialControler;
		view = new TutorialStepView(step.getTargetNode(), parent.getWidth(), parent.getHeight() );
	
		view.addLabel(step.getMessage(), step.getOffsetX(), step.getOffsetY());
		view.setOnMouseClicked(new EventHandler<MouseEvent> (){

			@Override
			public void handle(MouseEvent event) {

				tutorialControler.nextStep();
			}
			
		});
	
	}
	
	public Pane getView(){
		return view;
	}

}
