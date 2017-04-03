package com.dropsnorz.blackdoor.controller;

import java.io.IOException;

import com.dropsnorz.blackdoor.components.JavaCodeArea;
import com.dropsnorz.blackdoor.utils.Animations;

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

public class GameFieldController {

	
	protected DropCodeFragmentController dropCodeFragmentController;
	protected FragmentContainerController fragmentContainerController; 
	
	private Parent root;
	
	@FXML
	Label LB_Com;
	@FXML
	Button BT_Submit;
	@FXML
	Pane PANE_CodeArea;
	
    private double oldHeight = 0;
    private Text textHolder = new Text();
	JavaCodeArea topCodeArea;
	JavaCodeArea inputCodeArea;
	JavaCodeArea bottomCodeArea;
	

	public GameFieldController(){

		generateUI();
		
		dropCodeFragmentController = new DropCodeFragmentController();
		fragmentContainerController = new FragmentContainerController();
		
		topCodeArea = new JavaCodeArea();
		topCodeArea.replaceText(0,0,"public class App { \n\t public process() {");
		topCodeArea.setEditable(false);
		inputCodeArea = new JavaCodeArea();
		bottomCodeArea = new JavaCodeArea();
		bottomCodeArea.replaceText("\t } \n }");
		bottomCodeArea.setEditable(false);
		
		PANE_CodeArea.getChildren().add(topCodeArea);
		//PANE_CodeArea.getChildren().add(inputCodeArea);
		PANE_CodeArea.getChildren().add(dropCodeFragmentController.getView());
		//PANE_CodeArea.getChildren().add(bottomCodeArea);
		PANE_CodeArea.getChildren().add(fragmentContainerController.getView());
		
		fragmentContainerController.getView().getChildren().add(new CodeFragmentController().getView());
		
        textHolder.textProperty().bind(inputCodeArea.textProperty());
        textHolder.layoutBoundsProperty().addListener(new ChangeListener<Bounds>() {
            @Override
            public void changed(ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) {
                if (oldHeight != newValue.getHeight()) {
                    System.out.println("newValue = " + newValue.getHeight());
                    oldHeight = newValue.getHeight();
                    inputCodeArea.setPrefHeight(textHolder.getLayoutBounds().getHeight() + 20); // +20 is for paddings
                }
            }
        });


		BT_Submit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.out.println("On click");
				processInputCode();
			};
		});
		
		
		Animations.labelTypingAnimation(LB_Com, "« Il y’a pas mal d’agitation ici. Nous sommes sur la piste d’un terroriste […] et avec toutes mes félicitations c’est toi qui es en charge de sa surveillance. L’équipe sur le terrain a installé un logiciel espion sur téléphone portable de la cible. Tu as aura donc un accès total à son terminal Android. »");
	}
	
	public void processInputCode(){
		
		
	}
	public Parent getView(){
		return root;
	}

	private void generateUI(){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dropsnorz/blackdoor/FieldView.fxml"));
			loader.setController(this);
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
