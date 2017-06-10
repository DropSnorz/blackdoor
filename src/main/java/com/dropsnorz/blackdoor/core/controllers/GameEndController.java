package com.dropsnorz.blackdoor.core.controllers;

import com.dropsnorz.blackdoor.core.model.Game;
import com.dropsnorz.blackdoor.core.view.GameEndView;
import com.dropsnorz.blackdoor.utils.Animations;
import com.dropsnorz.blackdoor.utils.TimerUtils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GameEndController {

	protected GameEndView view;
	protected GameController gameController;

	public GameEndController(GameController gameController){

		this.gameController = gameController;
		view = new GameEndView();

		Game game = gameController.getGame();

		view.BT_Next.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {


				gameController.backToMenu();

			};
		});

		String content;

		if(game.getKeywords().contains("USER_GAVE_REAL_POSITION")){
			content = "Grace aux informations communiquées à gunter la cible a été éliminée. Vous avez contribué à maintenir l’ordre dans votre nation. Félicitation.";
		}
		else if(game.getKeywords().contains("USER_GAVE_FAKE_POSITION")){
			content = "Grace à vous Norah a pu prendre la fuite. Vous lui avez probablement sauvé la vie. \n Quelques mois plus tard, une rébellion contre le gouvernement en place éclatera dans votre pays après la révélation d’une vaste opération d’espionnage et d’intimidations. ";
		}
		else if(game.getKeywords().contains("USER_SEND_MESSAGE")){
			content = "Grace à vous Norah a pu prendre la fuite. Vous n’avez pas eu autant de chance… Les hommes de Gunter vous ont rattrapé avant que vous n’ayez eu le temps de quitter votre immeuble. Par chance Mme Hudson, la concierge, sortait son Yorkshire à ce moment-là ce qui a eu pour effet de ralentir les hommes à vos trousses vous évitant ainsi un façe à façe dont l’issue aurait pu vous être fatale. Vous êtes parvenu à vous réfugier sur l’ile de Panao, à des kilomètres de votre terre natale. \nQuelques mois plus tard, une rébellion contre le gouvernement en place éclatera dans votre pays après la révélation d’une vaste opération d’espionnage et d’intimidations. ";
		}
		else{
			content= "Les hommes de Gunter vous ont rattrapé avant que vous n’ayez eu le temps de quitter votre immeuble. Par chance Mme Hudson, la concierge, sortait son Yorkshire à ce moment-là ce qui a eu pour effet de ralentir les hommes à vos trousses vous évitant ainsi un façe à façe dont l’issue aurait pu vous être fatale. Vous êtes parvenu à vous réfugier sur l’ile de Panao, à des kilomètres de votre terre natale.";
		}

		Animations.labelTypingAnimation(view.text, content, Duration.seconds(5));


	}



	public Pane getView(){
		return view;
	}

}
