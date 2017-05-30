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
		fragmentsManager.addFragment(new CodeFragment("GET_CONTEXT()", "getContext()"));
		fragmentsManager.addFragment(new CodeFragment("VIBRATOR_V_NEW_VIBRATOR", "Vibrator v"));

		GameLevel l1 = new GameLevel();
		gameLevelList.add(l1);
		
	}
	
	public FragmentsManager getFragmentsManager(){
		return fragmentsManager;
	}
	
	

}
