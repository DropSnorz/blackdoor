package com.dropsnorz.blackdoor.tutorial.controller;

import java.util.ArrayList;

import com.dropsnorz.blackdoor.controller.GameController;
import com.dropsnorz.blackdoor.tutorial.model.TutorialListener;
import com.dropsnorz.blackdoor.tutorial.model.TutorialStep;
import com.dropsnorz.blackdoor.tutorial.view.TutorialView;

import javafx.scene.layout.Pane;

public class TutorialControler {
	
	protected TutorialView view;
	
	protected ArrayList<TutorialStep> stepList;
	protected int currentPosition = 0;
	protected GameController gameControler;
	
	protected TutorialListener onTutorialEndListener;
	
	public TutorialControler(GameController gameControler){
		this.gameControler = gameControler;
		
		view = new TutorialView();
		stepList = new ArrayList<TutorialStep>();
		currentPosition = 0;
	}
	
	public void startTutorial(){
		
		currentPosition = 0;
		TutorialStep step = stepList.get(currentPosition);
		
		TutorialStepController controler = new TutorialStepController(step, gameControler.getView(), this);
		view.getChildren().add(controler.getView());
				
	}
	
	public void addStep(TutorialStep step){
		stepList.add(step);
	}
	
	public void nextStep(){
		currentPosition = currentPosition + 1;
		
		if(currentPosition < stepList.size()){
			TutorialStep step = stepList.get(currentPosition);
			
			TutorialStepController controler = new TutorialStepController(step, view, this);
			view.getChildren().clear();
			view.getChildren().add(controler.getView());

		}
		else{
			onTutorialEndListener.handle();
		}

		
	}
	
	public void setTutorialEndListener(TutorialListener listener){
		this.onTutorialEndListener = listener;
	}
	
	
	public Pane getView(){
		return view;
	}


}
