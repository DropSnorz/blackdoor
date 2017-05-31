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

		GameLevel l1 = new GameLevel("level1");
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
		
		
		GameLevel l2 = new GameLevel("level2");
		l2.setIntroText("« Parfait ! L’équipe technique a vraiment fait un super boulot. On aimerait bien obtenir son numéro de téléphone pour voir s’il n’est pas en contact avec d’autres suspects. Tu peux nous obtenir ça ?»");
		l2.setFragmentList(l1.getFragmentList());
		l2.setResponseFragmentList(l1.getResponseFragmentList());
		
		gameLevelList.add(l1);
		gameLevelList.add(l2);
		
		currentGameLevel = l1;
		
	}
	
	public GameLevel getCurrentGameLevel(){
		return currentGameLevel;
	}
	
	public GameLevel nextLevel(){
		
		for(int i = 0; i < gameLevelList.size(); i++){
			
			if(gameLevelList.get(i).equals(currentGameLevel) && i < gameLevelList.size() - 1){
				currentGameLevel = gameLevelList.get(i+ 1);
				return currentGameLevel;
			}
		}
		
		
		return null;
	}
	
	public FragmentsManager getFragmentsManager(){
		return fragmentsManager;
	}
	
	

}
