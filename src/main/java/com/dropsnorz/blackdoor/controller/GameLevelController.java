package com.dropsnorz.blackdoor.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.dropsnorz.blackdoor.components.JavaCodeArea;
import com.dropsnorz.blackdoor.components.ModalFrame;
import com.dropsnorz.blackdoor.model.CodeFragment;
import com.dropsnorz.blackdoor.utils.Animations;
import com.jfoenix.controls.JFXRippler;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class GameLevelController {


	protected GameController gameController;

	protected DropCodeFragmentController dropCodeFragmentController;
	protected FragmentContainerController fragmentContainerController; 
	protected ResultController resultController;

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
	Pane fragmentTabContent;
	

	private double oldHeight = 0;
	private Text textHolder = new Text();
	JavaCodeArea topCodeArea;
	JavaCodeArea bottomCodeArea;


	public GameLevelController(GameController gameController){

		generateUI();
		this.gameController = gameController;

		dropCodeFragmentController = new DropCodeFragmentController();
		fragmentContainerController = new FragmentContainerController();
		resultController = new ResultController(this);

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


		ArrayList<CodeFragment> codeFragmentList = new ArrayList<CodeFragment>();
		codeFragmentList.add(new CodeFragment("this_getContext","this.getContext()"));
		codeFragmentList.add(new CodeFragment("dot_getCapacitor","getCapacitor()"));
		codeFragmentList.add(new CodeFragment("update",".update()"));

		fragmentContainerController.setCodeFragmentList(codeFragmentList);


		BT_Course.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				CourseController courseController = new CourseController("undefined");
			};
		});


		BT_Submit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.out.println("On click");
				processInputCode();
				
				
				gameController.popModal(resultController.getView());

			};
		});
		

		Animations.labelTypingAnimation(LB_Com, "« Il y’a pas mal d’agitation ici. Nous sommes sur la piste d’un terroriste […] et avec toutes mes félicitations c’est toi qui es en charge de sa surveillance. L’équipe sur le terrain a installé un logiciel espion sur téléphone portable de la cible. Tu as aura donc un accès total à son terminal Android. »");
	}

	public void processInputCode(){


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
