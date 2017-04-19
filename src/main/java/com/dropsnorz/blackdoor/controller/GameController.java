package com.dropsnorz.blackdoor.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.dropsnorz.blackdoor.components.ModalFrame;
import com.dropsnorz.blackdoor.utils.Animations;
import com.dropsnorz.blackdoor.view.GameView;

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
	protected GameIntroController introController;
	protected GameMenuController menuController;
	
	protected ModalFrame modalFrame;

	public GameController(){

		view = new GameView();
		
		introController = new GameIntroController();
		menuController = new GameMenuController(this);
		
		view.stackView(menuController.getView());
		view.stackView(introController.getView());

		introController.animateUI();
		modalFrame = new ModalFrame();
		
		
		Animations.fadeOut(introController.getView(), Duration.seconds(5));
		
	}
	
	public void playGame(){
		
		GameLevelController gameLevelController = new GameLevelController(this);
		view.stackView(gameLevelController.getView());
		
	}
	
	public void popModal(Node node){
		
		modalFrame.setContent(node);
		view.stackView(modalFrame);
	}
	
	public void hideModal(){
		
		view.unstackView(modalFrame);
	
	}

	public GameView getView(){
		return view;
	}
}



