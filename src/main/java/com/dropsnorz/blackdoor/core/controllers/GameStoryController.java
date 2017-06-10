package com.dropsnorz.blackdoor.core.controllers;

import com.dropsnorz.blackdoor.core.view.GameStoryView;
import com.dropsnorz.blackdoor.utils.Animations;
import com.dropsnorz.blackdoor.utils.TimerUtils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GameStoryController {
	
	protected GameStoryView view;
	protected GameController gameController;
	
	public GameStoryController(GameController gameController){
		
		view = new GameStoryView();
		
		view.BT_Next.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				view.progressIndicator.setVisible(true);
				
				TimerUtils.scheduleUIAction(2, new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent event) {
						gameController.startLevel();
						
					}
					
				});
			};
		});
		
		String storyContent = "Vous êtes un brillant hacker au service de votre gouvernement depuis quelques mois. Vous recevez toutes vos directives de Gunter1. Vous ne l’avez jamais rencontré mais il connait vraisemblablement beaucoup de choses sur vous";
		storyContent += "\n\n\n";
		storyContent += "*******Nouveau Message*******\n";
		storyContent += "Gunter01: « Il y’a pas mal d’agitation ici. Nous sommes sur la piste d’un terroriste actif et avec toutes mes félicitations c’est toi qui es en charge de sa surveillance. L’équipe sur le terrain a installé un logiciel espion sur téléphone portable de la cible. Tu as aura donc un accès total à son terminal Android. Le temps est compté et tu sais que dans une affaire comme celle-ci ce sont des vies qui sont en jeu. D’après l’équipe technique, tu dois simplement écrire le code informatique, nous on se charge de le transférer sur le terminal de la cible. A partir de là c’est à toi du jouer. Ton environnement de travail devrait apparaitre d’une minute à l’autre.»";
		
		Animations.labelTypingAnimation(view.text, storyContent, Duration.seconds(7));
		
		
	}
	
	public Pane getView(){
		return view;
	}

}
