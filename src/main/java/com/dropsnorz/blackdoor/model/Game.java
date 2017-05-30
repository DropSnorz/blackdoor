package com.dropsnorz.blackdoor.model;

import java.util.ArrayList;

public class Game {
	
	FragmentsManager fragmentsManager;
	
	ArrayList<GameLevel> gameLevelList;
	GameLevel currentGameLevel;

	public Game() {
		super();
		gameLevelList = new ArrayList<GameLevel>();
		fragmentsManager = new FragmentsManager();
		
		fillData();
	}
	

	private void fillData(){
		
		fragmentsManager.addFragment(new CodeFragment("SEMICOLON", ";"));
		fragmentsManager.addFragment(new CodeFragment("DOT", "."));
		fragmentsManager.addFragment(new CodeFragment("EQUALS", "="));
		fragmentsManager.addFragment(new CodeFragment("CONTEXT", "Context"));
		fragmentsManager.addFragment(new CodeFragment("GET_CONTEXT()", "getContext()"));
		fragmentsManager.addFragment(new CodeFragment("VIBRATOR_V", "Vibrator v"));
		fragmentsManager.addFragment(new CodeFragment("GET_SYSTEM_SERVICE", "getSystemService"));
		fragmentsManager.addFragment(new CodeFragment("VIBRATOR_SERVICE", "VIBRATOR_SERVICE"));
		fragmentsManager.addFragment(new CodeFragment("MESSAGE_SERVICE", "MESSAGE_SERVICE"));
		fragmentsManager.addFragment(new CodeFragment("V_VIBRATE(100)", "v.vibrate(100)"));

		GameLevel l1 = new GameLevel();
		l1.setIntroText("« Bien, dans un premier temps on va tester si le virus fonctionne correctement. Je pense qu’on peut faire vibrer le téléphone de la cible dans un premier temps» ");
		l1.getFragmentList().add(fragmentsManager.getFragmentById("CONTEXT"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("GET_CONTEXT()"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("VIBRATOR_V"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("GET_SYSTEM_SERVICE"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("VIBRATOR_SERVICE"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("MESSAGE_SERVICE"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("V_VIBRATE(100)"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("EQUALS"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("SEMICOLON"));



		
		FragmentListBuilder builder = new FragmentListBuilder(fragmentsManager);
		builder.add("VIBRATOR_V").add("EQUALS").add("GET_CONTEXT()").add("GET_SYSTEM_SERVICE").add("SEMICOLON")
			.add("V_VIBRATE(100)").add("SEMICOLON");


		l1.setResponseFragmentList(builder.build());
		
		
		gameLevelList.add(l1);
		
		currentGameLevel = l1;
		
	}
	
	public GameLevel getCurrentGameLevel(){
		return currentGameLevel;
	}
	
	public FragmentsManager getFragmentsManager(){
		return fragmentsManager;
	}
	
	

}
