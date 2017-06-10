package com.dropsnorz.blackdoor.core.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.dropsnorz.blackdoor.components.ModalFrame;
import com.dropsnorz.blackdoor.core.model.Game;
import com.dropsnorz.blackdoor.core.view.GameView;
import com.dropsnorz.blackdoor.level.controllers.GameLevelController;
import com.dropsnorz.blackdoor.utils.Animations;
import com.dropsnorz.blackdoor.utils.TimerUtils;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Controleur principal de l'application
 *
 */
public class GameController{

	protected GameView view;
	protected Game game;

	protected GameIntroController introController;
	protected GameMenuController menuController;
	protected GameLevelController gameLevelController;
	
	
	protected ModalFrame modalFrame;
	
	public GameController(){

		view = new GameView();
		game = new Game();

		introController = new GameIntroController();
		menuController = new GameMenuController(this);
		
		
		view.stackView(menuController.getView());
		view.stackView(introController.getView());

		introController.animateUI();
		modalFrame = new ModalFrame();
				
		Animations.fadeOut(introController.getView(), Duration.seconds(5));
		
	}
	
	public void playGame(){
		
		GameStoryController storyController = new GameStoryController(this);
		view.stackView(storyController.getView());
		
		view.unstackView(introController.getView());
		view.unstackView(menuController.getView());
		

	}
	
	public void startLevel(){
		
		gameLevelController = new GameLevelController(game,this);
		view.stackView(gameLevelController.getView());
		
		
		TimerUtils.scheduleUIAction(2, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				gameLevelController.startTutorial();
				
			}
			
		});
	}
	
	public void endGame(){
		
		GameEndController endController = new GameEndController(this);
		view.stackView(endController.getView());
		view.unstackView(gameLevelController.getView());
		
		

	}
	
	public void backToMenu(){
		
		view.stackView(menuController.getView());
	}
	
	public void popModal(Node node){
		
		modalFrame.setContent(node);
		view.stackView(modalFrame);
	}
	
	public void hideModal(){
		
		view.unstackView(modalFrame);
	
	}
	
	public Game getGame(){
		return game;
	}

	public GameView getView(){
		return view;
	}
}



