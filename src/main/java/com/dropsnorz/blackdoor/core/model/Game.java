package com.dropsnorz.blackdoor.core.model;

import java.util.ArrayList;

import com.dropsnorz.blackdoor.level.model.CodeFragment;
import com.dropsnorz.blackdoor.level.model.CodeFragmentType;
import com.dropsnorz.blackdoor.level.model.Dialog;
import com.dropsnorz.blackdoor.level.model.FragmentListBuilder;
import com.dropsnorz.blackdoor.level.model.FragmentsManager;
import com.dropsnorz.blackdoor.level.model.GameLevel;

public class Game {
	
	FragmentsManager fragmentsManager;
	KeywordManager keywordManager;
	
	ArrayList<GameLevel> gameLevelList;
	GameLevel currentGameLevel;
	

	public Game() {
		super();
		gameLevelList = new ArrayList<GameLevel>();
		fragmentsManager = new FragmentsManager();
		keywordManager = new KeywordManager();
		
		fillData();
	}
	

	private void fillData(){
		
		fragmentsManager.addFragment(new CodeFragment("OP_SEMICOLON", ";", CodeFragmentType.TYPE_OPERATOR));
		fragmentsManager.addFragment(new CodeFragment("OP_DOT", ".", CodeFragmentType.TYPE_OPERATOR));
		fragmentsManager.addFragment(new CodeFragment("OP_EQUALS", "=", CodeFragmentType.TYPE_OPERATOR));
		fragmentsManager.addFragment(new CodeFragment("OP_RETURN", "return", CodeFragmentType.TYPE_OPERATOR));

		fragmentsManager.addFragment(new CodeFragment("CONTEXT", "Context"));
		fragmentsManager.addFragment(new CodeFragment("GET_CONTEXT()", "getContext()"));
		fragmentsManager.addFragment(new CodeFragment("VIBRATOR_V", "Vibrator v", CodeFragmentType.TYPE_VARIABLE));
		fragmentsManager.addFragment(new CodeFragment("GET_SYSTEM_SERVICE_VIBRATOR", "getSystemService(VIBRAOTR_SERVICE)"));
		fragmentsManager.addFragment(new CodeFragment("VIBRATOR_SERVICE", "VIBRATOR_SERVICE"));
		fragmentsManager.addFragment(new CodeFragment("MESSAGE_SERVICE", "MESSAGE_SERVICE"));
		fragmentsManager.addFragment(new CodeFragment("V_VIBRATE(100)", "v.vibrate(100)"));

		//Level 2
		fragmentsManager.addFragment(new CodeFragment("TELEPHONY_MANAGER_MANAGER", "TelephonyManager manager"));
		fragmentsManager.addFragment(new CodeFragment("GET_SYSTEM_SERVICE_TELEPHONY", "getSystemService(TELEPHONY_SERVICE)"));
		fragmentsManager.addFragment(new CodeFragment("MANAGER_GET_LINE_NUMBER", "manager.getLine1Number()"));
		
		//Level 3
		fragmentsManager.addFragment(new CodeFragment("PACKAGE_MANAGER_MANAGER", "PackageManager manager", CodeFragmentType.TYPE_VARIABLE));
		fragmentsManager.addFragment(new CodeFragment("GET_PACKAGE_MANAGER", "getPackageManager()"));
		fragmentsManager.addFragment(new CodeFragment("LIST_APPLICATION_INFO", "List<ApplicationInfo> packages"));
		fragmentsManager.addFragment(new CodeFragment("GET_INSTALLED_APP", "getInstalledApplications()"));
		fragmentsManager.addFragment(new CodeFragment("VAR_MANAGER", "manager", CodeFragmentType.TYPE_VARIABLE));

		//Level 4
		
		fragmentsManager.addFragment(new CodeFragment("CURSOR_CURSOR", "Cursor cursor", CodeFragmentType.TYPE_VARIABLE));
		fragmentsManager.addFragment(new CodeFragment("RETURN_CURSOR_SEMICOLON", "return cursor;", CodeFragmentType.TYPE_VARIABLE));
		fragmentsManager.addFragment(new CodeFragment("GET_CONTENT_RESOLVER", "getContentResolver()"));
		fragmentsManager.addFragment(new CodeFragment("QUERY_CONTENT_CALLS", "query(content://calls/lastCalls)"));
		
		GameLevel l1 = new GameLevel("level1", this);
		l1.setTitle("Mission 1");
		l1.setHelperText("Faire vibrer le téléphone de la cible pendant 100 ms");
		l1.setIntroText("« Bien, dans un premier temps on va tester si le virus fonctionne correctement. Je pense qu’on peut faire vibrer le téléphone de la cible dans un premier temps» ");
		l1.getFragmentList().add(fragmentsManager.getFragmentById("CONTEXT"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("GET_CONTEXT()"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("VIBRATOR_V"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("GET_SYSTEM_SERVICE_VIBRATOR"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("VIBRATOR_SERVICE"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("MESSAGE_SERVICE"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("V_VIBRATE(100)"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("OP_DOT"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("OP_EQUALS"));
		l1.getFragmentList().add(fragmentsManager.getFragmentById("OP_SEMICOLON"));
		
		FragmentListBuilder builder = new FragmentListBuilder(fragmentsManager);
		builder.add("VIBRATOR_V").add("OP_EQUALS").add("GET_CONTEXT()").add("OP_DOT").add("GET_SYSTEM_SERVICE_VIBRATOR").add("OP_SEMICOLON")
			.add("V_VIBRATE(100)").add("OP_SEMICOLON");


		l1.getDialogKeywordFinder().addKeywordMapping(null, new Dialog("Continuer"));
		
		l1.setResponseFragmentList(builder.build());
		
		
		GameLevel l2 = new GameLevel("level2", this);
		l2.setTitle("Mission 2");
		l2.setIntroText("« Parfait ! L’équipe technique a vraiment fait un super boulot. On aimerait bien obtenir son numéro de téléphone pour voir s’il n’est pas en contact avec d’autres suspects. Tu peux nous obtenir ça ?»");
		l2.setHelperText("Retourner le numéro de téléphone du terminal de la cible");
		l2.getFragmentList().add(fragmentsManager.getFragmentById("TELEPHONY_MANAGER_MANAGER"));
		l2.getFragmentList().add(fragmentsManager.getFragmentById("GET_SYSTEM_SERVICE_TELEPHONY"));
		l2.getFragmentList().add(fragmentsManager.getFragmentById("MANAGER_GET_LINE_NUMBER"));
		l2.getFragmentList().add(fragmentsManager.getFragmentById("GET_CONTEXT()"));
		l2.getFragmentList().add(fragmentsManager.getFragmentById("OP_DOT"));
		l2.getFragmentList().add(fragmentsManager.getFragmentById("OP_EQUALS"));
		l2.getFragmentList().add(fragmentsManager.getFragmentById("OP_SEMICOLON"));
		l2.getFragmentList().add(fragmentsManager.getFragmentById("OP_RETURN"));

		builder = new FragmentListBuilder(fragmentsManager);
		builder.add("TELEPHONY_MANAGER_MANAGER").add("OP_EQUALS").add("GET_CONTEXT()").add("OP_DOT").add("GET_SYSTEM_SERVICE_TELEPHONY").add("OP_SEMICOLON")
			.add("OP_RETURN").add("MANAGER_GET_LINE_NUMBER").add("OP_SEMICOLON");
		
		l2.setResponseFragmentList(builder.build());
		
		l2.getDialogKeywordFinder().addKeywordMapping(null, new Dialog("Continuer"));

		GameLevel l3 = new GameLevel("level3", this);
		l3.setTitle("Mission 3");
		l3.setIntroText("« Bon voyons un peu ce qu'il y'a sur ce téléphone. Est-ce que tu peux obtenir la liste des applications installées sur son terminal ? On aura un bon point du vue sur les réseaux sociaux qu'il peut utiliser pour communiquer avec d'éventuels complices »");
		l3.setHelperText("Retourner la liste des applications installées sur le téléphone");
		
		l3.getFragmentList().add(fragmentsManager.getFragmentById("PACKAGE_MANAGER_MANAGER"));
		l3.getFragmentList().add(fragmentsManager.getFragmentById("GET_SYSTEM_SERVICE_TELEPHONY"));
		l3.getFragmentList().add(fragmentsManager.getFragmentById("GET_PACKAGE_MANAGER"));
		l3.getFragmentList().add(fragmentsManager.getFragmentById("LIST_APPLICATION_INFO"));
		l3.getFragmentList().add(fragmentsManager.getFragmentById("GET_INSTALLED_APP"));
		l3.getFragmentList().add(fragmentsManager.getFragmentById("VAR_MANAGER"));
		l3.getFragmentList().add(fragmentsManager.getFragmentById("GET_CONTEXT()"));
		l3.getFragmentList().add(fragmentsManager.getFragmentById("OP_DOT"));
		l3.getFragmentList().add(fragmentsManager.getFragmentById("OP_EQUALS"));
		l3.getFragmentList().add(fragmentsManager.getFragmentById("OP_SEMICOLON"));
		l3.getFragmentList().add(fragmentsManager.getFragmentById("OP_RETURN"));
		
		builder = new FragmentListBuilder(fragmentsManager);
		builder.add("PACKAGE_MANAGER_MANAGER").add("OP_EQUALS").add("GET_CONTEXT()").add("OP_DOT").add("GET_PACKAGE_MANAGER").add("OP_SEMICOLON")
			.add("OP_RETURN").add("VAR_MANAGER").add("OP_DOT").add("GET_INSTALLED_APP").add("OP_SEMICOLON");
		
		l3.setResponseFragmentList(builder.build());
		
		l3.getDialogKeywordFinder().addKeywordMapping(null, new Dialog("Continuer"));
		
		
		
		GameLevel l4 = new GameLevel("level4", this);
		l4.setTitle("Mission 4");
		l4.setIntroText("« Je ne veux pas te mettre la pression mais le reste de l'équipe est très inquiète a propos de cet individu. Nous allons avoir besoin d'informations plus probantes. Essaye d'obtenir la liste de ses derniers appels. »");
		l4.setHelperText("Retourner la liste des dernier appels");
		
		l4.getFragmentList().add(fragmentsManager.getFragmentById("CURSOR_CURSOR"));
		l4.getFragmentList().add(fragmentsManager.getFragmentById("RETURN_CURSOR_SEMICOLON"));
		l4.getFragmentList().add(fragmentsManager.getFragmentById("QUERY_CONTENT_CALLS"));
		l4.getFragmentList().add(fragmentsManager.getFragmentById("GET_CONTENT_RESOLVER"));
		l4.getFragmentList().add(fragmentsManager.getFragmentById("GET_CONTEXT()"));
		l4.getFragmentList().add(fragmentsManager.getFragmentById("OP_DOT"));
		l4.getFragmentList().add(fragmentsManager.getFragmentById("OP_EQUALS"));
		l4.getFragmentList().add(fragmentsManager.getFragmentById("OP_SEMICOLON"));
		
		
		builder = new FragmentListBuilder(fragmentsManager);
		builder.add("CURSOR_CURSOR").add("OP_EQUALS").add("GET_CONTEXT()").add("OP_DOT").add("GET_CONTENT_RESOLVER").add("OP_DOT").add("QUERY_CONTENT_CALLS").add("OP_SEMICOLON")
			.add("RETURN_CURSOR_SEMICOLON");
		
		l4.setResponseFragmentList(builder.build());
		
		l4.getDialogKeywordFinder().addKeywordMapping(null, new Dialog("Continuer"));
		
		
		
		gameLevelList.add(l1);
		gameLevelList.add(l2);
		gameLevelList.add(l3);
		gameLevelList.add(l4);
		
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


	public KeywordManager getKeywordManager() {
		return keywordManager;
	}
	

}
