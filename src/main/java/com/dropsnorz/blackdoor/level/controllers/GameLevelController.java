package com.dropsnorz.blackdoor.level.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.dropsnorz.blackdoor.components.JavaCodeArea;
import com.dropsnorz.blackdoor.components.ModalFrame;
import com.dropsnorz.blackdoor.core.controllers.GameController;
import com.dropsnorz.blackdoor.core.model.Game;
import com.dropsnorz.blackdoor.level.model.CodeFragment;
import com.dropsnorz.blackdoor.level.model.FragmentsManager;
import com.dropsnorz.blackdoor.level.model.GameLevel;
import com.dropsnorz.blackdoor.level.model.LevelResolver;
import com.dropsnorz.blackdoor.tutorial.controllers.TutorialController;
import com.dropsnorz.blackdoor.tutorial.model.TutorialListener;
import com.dropsnorz.blackdoor.tutorial.model.TutorialStep;
import com.dropsnorz.blackdoor.utils.Animations;
import com.dropsnorz.blackdoor.utils.TimerUtils;
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
	Label LB_LevelTitle;
	@FXML
	Label LB_Com;
	@FXML
	Label LB_Helper;
	@FXML
	Pane helperPane;
	@FXML
	Button BT_Course;
	@FXML
	Button BT_RestartTutorial;
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
		
		BT_RestartTutorial.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				startTutorial();
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
		
	}

	public void updateUI(){

		GameLevel currentLevel = game.getCurrentGameLevel();
		LB_LevelTitle.setText(currentLevel.getTitle());
		LB_Helper.setText(currentLevel.getHelperText());
		
		if(currentLevel.getPreWrittenCode() != null){
			topCodeArea.replaceText("public class App { \n     public process() {\n     " + currentLevel.getPreWrittenCode());
		}
		else{
			topCodeArea.replaceText("public class App { \n     public process() {");

		}
		
		Animations.labelTypingAnimation(LB_Com, currentLevel.getIntroText());
		
		helperPane.setVisible(false);
		TimerUtils.scheduleUIAction(6, new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Animations.slideIn(helperPane);
			}
			
		});
		dropCodeFragmentController.removeAllCodeFragments();
		bottomTabPane.getSelectionModel().select(0);
		fragmentContainerController.setCodeFragmentList(currentLevel.getFragmentList());
	}
	
	public void startTutorial(){

		//Tutorial tuto = new Tutorial();
		//tuto.displayToolTip(LB_Com, gameController.getView());
		
		TutorialController tutorialControler = new TutorialController(gameController);
		
		tutorialControler.addStep(new TutorialStep(LB_Com, "Le COM est votre canal de communication, lisez le attentivement afin \nde recevoir les directives de votre mission", 20, 40));
		tutorialControler.addStep(new TutorialStep(dropCodeFragmentController.getView(), "Votre mission va nécéssiter l'écriture d'un virus en Java. \nVous devrez assembler le code dans cette zone", 0, 60));		
		tutorialControler.addStep(new TutorialStep(bottomTabPane, "Pour construire votre virus, vous avez accès à des fragments.\nAssemblez ces fragments en les glissant puis déposant dans la zone de code", -40, 30));
		tutorialControler.addStep(new TutorialStep(BT_Submit, "Lorsque vous avez terminé, soumettez votre code.\nIl sera automatiquement analysé et envoyé à votre cible", -600, -100));
		tutorialControler.addStep(new TutorialStep(BT_Course, "Si vous avez besoin d'aide, vous pouvez consultez à tout moment la documentation Android", -600, 50));


		
		tutorialControler.setTutorialEndListener(new TutorialListener(){

			@Override
			public void handle() {
				gameController.getView().unstackView(tutorialControler.getView());
				
			}
			
		});

		gameController.getView().stackView(tutorialControler.getView());
		
		tutorialControler.startTutorial();

		
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

		LevelResolver resolver = new LevelResolver(game.getCurrentGameLevel(), game.getKeywordManager());

		bottomTabPane.getSelectionModel().select(1);
		consoleController.clear();

		if(resolver.resolve(response)){
			consoleController.onEndConsoleDisplay(new EventHandler<Event>(){

				@Override
				public void handle(Event event) {

					resultController = new ResultController(_this, game);
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
	
	public void endGame(){
		
		gameController.endGame();
		
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
