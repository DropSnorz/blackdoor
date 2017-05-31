package com.dropsnorz.blackdoor.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.dropsnorz.blackdoor.components.JavaCodeArea;
import com.dropsnorz.blackdoor.components.ModalFrame;
import com.dropsnorz.blackdoor.model.CodeFragment;
import com.dropsnorz.blackdoor.model.FragmentsManager;
import com.dropsnorz.blackdoor.model.Game;
import com.dropsnorz.blackdoor.model.GameLevel;
import com.dropsnorz.blackdoor.model.LevelResolver;
import com.dropsnorz.blackdoor.utils.Animations;
import com.jfoenix.controls.JFXRippler;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class GameLevelController {


	private GameLevelController _this = this;
	protected GameController gameController;

	protected DropCodeFragmentController dropCodeFragmentController;
	protected FragmentContainerController fragmentContainerController; 
	protected ResultController resultController;
	protected FragmentsManager fragmentsManager;
	protected ConsoleController consoleController;

	private Pane root;

	@FXML
	Label LB_Com;
	@FXML
	Button BT_Course;
	@FXML
	Button BT_Submit;
	@FXML
	Pane PANE_CenterStack;
	@FXML
	Pane PANE_CodeArea;
	@FXML
	TabPane bottomTabPane;
	@FXML 
	Pane fragmentTabContent;
	@FXML 
	Pane consoleTabContent;


	JavaCodeArea topCodeArea;
	JavaCodeArea bottomCodeArea;

	private Game game;


	public GameLevelController(Game game, GameController gameController){

		generateUI();
		this.game = game;
		this.gameController = gameController;

		fragmentsManager = game.getFragmentsManager();

		dropCodeFragmentController = new DropCodeFragmentController(fragmentsManager);
		fragmentContainerController = new FragmentContainerController();
		consoleController = new ConsoleController();

		topCodeArea = new JavaCodeArea();
		topCodeArea.replaceText(0,0,"public class App { \n     public process() {");
		topCodeArea.setEditable(false);
		bottomCodeArea = new JavaCodeArea();
		bottomCodeArea.replaceText("    } \n }");
		bottomCodeArea.setEditable(false);

		PANE_CodeArea.getChildren().add(topCodeArea);
		PANE_CodeArea.getChildren().add(dropCodeFragmentController.getView());
		PANE_CodeArea.getChildren().add(bottomCodeArea);
		fragmentTabContent.getChildren().add(fragmentContainerController.getView());
		consoleTabContent.getChildren().add(consoleController.getView());

		fragmentContainerController.setCodeFragmentList(game.getFragmentsManager().getFragmentList());


		BT_Course.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				CourseController courseController = new CourseController("undefined");
			};
		});


		BT_Submit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.out.println("On click");
				processInputCode();

				//gameController.popModal(resultController.getView());

			};
		});


		updateUI();

		//Animations.labelTypingAnimation(LB_Com, "« Il y’a pas mal d’agitation ici. Nous sommes sur la piste d’un terroriste […] et avec toutes mes félicitations c’est toi qui es en charge de sa surveillance. L’équipe sur le terrain a installé un logiciel espion sur téléphone portable de la cible. Tu as aura donc un accès total à son terminal Android. »");
	}

	public void updateUI(){

		GameLevel currentLevel = game.getCurrentGameLevel();

		Animations.labelTypingAnimation(LB_Com, currentLevel.getIntroText());
		dropCodeFragmentController.removeAllCodeFragments();
		bottomTabPane.getSelectionModel().select(0);
		fragmentContainerController.setCodeFragmentList(currentLevel.getFragmentList());
	}
	
	public void nextLevel(){
		
		game.nextLevel();
		updateUI();
	}

	public void processInputCode(){
		ArrayList<CodeFragment> response = dropCodeFragmentController.getDroppedCodeFragmentList();

		for(CodeFragment fragment : response){
			System.out.println(fragment);
		}

		LevelResolver resolver = new LevelResolver(game.getCurrentGameLevel());

		bottomTabPane.getSelectionModel().select(1);
		consoleController.clear();

		if(resolver.resolve(response)){
			consoleController.onEndConsoleDisplay(new EventHandler<Event>(){

				@Override
				public void handle(Event event) {

					resultController = new ResultController(_this, game.getCurrentGameLevel());
					gameController.popModal(resultController.getView());
				}

			});

			consoleController.write("SUCCESS");

		}
		else{
			consoleController.onEndConsoleDisplay(new EventHandler<Event>(){

				@Override
				public void handle(Event event) {

				}

			});

			consoleController.write("ERROR");
		}
	}

	public void hideModal(){

		gameController.hideModal();

	}
	public Parent getView(){
		return root;
	}

	private void generateUI(){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dropsnorz/blackdoor/LevelView.fxml"));
			loader.setController(this);
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
