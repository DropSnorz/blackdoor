package com.dropsnorz.blackdoor.core.model;

import java.util.ArrayList;

import com.dropsnorz.blackdoor.level.model.CodeFragment;
import com.dropsnorz.blackdoor.level.model.CodeFragmentType;
import com.dropsnorz.blackdoor.level.model.Dialog;
import com.dropsnorz.blackdoor.level.model.FragmentListBuilder;
import com.dropsnorz.blackdoor.level.model.FragmentsManager;
import com.dropsnorz.blackdoor.level.model.GameLevel;
import com.dropsnorz.blackdoor.level.model.LevelAnswer;

public class Game {

	FragmentsManager fragmentsManager;
	KeywordManager keywordManager;

	ArrayList<GameLevel> gameLevelList;
	GameLevel currentGameLevel;
	
	protected ArrayList<String> keywords;
 

	public Game() {
		super();
		gameLevelList = new ArrayList<GameLevel>();
		fragmentsManager = new FragmentsManager();
		keywords = new ArrayList<String>();
		keywordManager = new KeywordManager(this);

		fillData();
	}


	private void fillData(){

		fragmentsManager.addFragment(new CodeFragment("OP_SEMICOLON", ";", CodeFragmentType.TYPE_OPERATOR));
		fragmentsManager.addFragment(new CodeFragment("OP_DOT", ".", CodeFragmentType.TYPE_OPERATOR));
		fragmentsManager.addFragment(new CodeFragment("OP_EQUALS", "=", CodeFragmentType.TYPE_OPERATOR));
		fragmentsManager.addFragment(new CodeFragment("OP_RETURN", "return ", CodeFragmentType.TYPE_OPERATOR));
		fragmentsManager.addFragment(new CodeFragment("OP_NEW", "new ", CodeFragmentType.TYPE_OPERATOR));

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
		fragmentsManager.addFragment(new CodeFragment("QUERY_CONTENT_CALLS", "query(\"content://calls/lastCalls\")"));


		//Level5

		fragmentsManager.addFragment(new CodeFragment("REQUEST_REQUEST", "Request req", CodeFragmentType.TYPE_VARIABLE));
		fragmentsManager.addFragment(new CodeFragment("REQUEST_URI", "Request(uri)"));
		fragmentsManager.addFragment(new CodeFragment("REQUEST_SET_VISIBLE_SEMICOLON", "request.setVisibleInDownloadUi(false);"));
		fragmentsManager.addFragment(new CodeFragment("REQUEST_NOTIFICATION_VISIBILITY_SEMICOLON", "request.setNotificationVisibility(VISIBILITY_HIDDEN);"));
		fragmentsManager.addFragment(new CodeFragment("DOWNLOAD_MANAGER_MANAGER", "DownloadManager manager"));
		fragmentsManager.addFragment(new CodeFragment("GET_SYSTEM_SERVICE_DOWNLOAD_SERVICE", "getSystemService(DOWNLOAD_SERVICE)"));
		fragmentsManager.addFragment(new CodeFragment("DOWNLOAD_MANAGER_ENQUEU_REQUEST_SEMICOLON", "downloadManager.enqueu(request);", CodeFragmentType.TYPE_VARIABLE));

		//Level 6
		
		//Level 7

		fragmentsManager.addFragment(new CodeFragment("QUERY_CONTENT_SMS", "query(\"content://sms\")"));
		
		//Level8
		fragmentsManager.addFragment(new CodeFragment("STRING_BUILDER_CONTENT", "StringBuilder content", CodeFragmentType.TYPE_VARIABLE));
		fragmentsManager.addFragment(new CodeFragment("NEW_STRING_BUILDER", "new StringBuilder()"));
		fragmentsManager.addFragment(new CodeFragment("FILE_FILE", "FILE file", CodeFragmentType.TYPE_VARIABLE));
		fragmentsManager.addFragment(new CodeFragment("FILE_SD_CARD_ARTICLE_TXT_SEMICOLON", "File(getExternalStorageDirectory(), \"article.txt\");", CodeFragmentType.TYPE_VARIABLE));
		fragmentsManager.addFragment(new CodeFragment("FILE_SD_CARD_LOG_TXT_SEMICOLON", "File(getExternalStorageDirectory(), \"log.txt\");", CodeFragmentType.TYPE_VARIABLE));
		fragmentsManager.addFragment(new CodeFragment("CONTENT_COPY_FILE_SEMICOLON", "content.copyFile(file);", CodeFragmentType.TYPE_VARIABLE));

		fragmentsManager.addFragment(new CodeFragment("STRING_BUILDER", "StringBuilder()", CodeFragmentType.TYPE_VARIABLE));
		fragmentsManager.addFragment(new CodeFragment("STRING_BUILDER", "StringBuilder()", CodeFragmentType.TYPE_VARIABLE));

		
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

		l1.addAnswer(builder.buildAnswer());
		l1.getResultKeywordFinder().addKeywordMapping(null, "level1");



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

		l2.addAnswer(builder.buildAnswer());

		l2.getDialogKeywordFinder().addKeywordMapping(null, new Dialog("Continuer"));
		l2.getResultKeywordFinder().addKeywordMapping(null, "level2");


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

		l3.addAnswer(builder.buildAnswer());

		l3.getDialogKeywordFinder().addKeywordMapping(null, new Dialog("Continuer"));
		l3.getResultKeywordFinder().addKeywordMapping(null, "level3");


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

		l4.addAnswer(builder.buildAnswer());
		l4.getDialogKeywordFinder().addKeywordMapping(null, new Dialog("Continuer"));
		l4.getResultKeywordFinder().addKeywordMapping(null, "level4");


		GameLevel l5 = new GameLevel("level5", this);
		l5.setTitle("Mission 5");
		l5.setIntroText("« Tu t’en sors très bien, cette liste nous sera très utile. Pour la suite des opérations nous aurons besoin d’injecter un virus beaucoup plus puissant. Ce virus se trouve à l’adresse http://goo.gl/OHK4cm/hazardous.apk, tu dois le télécharger sur le terminal de la cible. »");
		l5.setHelperText("Télécharger un fichier depuis internet sur le terminal de la cible");

		l5.setPreWrittenCode("String uri = ”http://goo.gl/OHK4cm/hazardous.apk”;");

		l5.getFragmentList().add(fragmentsManager.getFragmentById("REQUEST_REQUEST"));
		l5.getFragmentList().add(fragmentsManager.getFragmentById("REQUEST_URI"));
		l5.getFragmentList().add(fragmentsManager.getFragmentById("REQUEST_SET_VISIBLE_SEMICOLON"));
		l5.getFragmentList().add(fragmentsManager.getFragmentById("REQUEST_NOTIFICATION_VISIBILITY_SEMICOLON"));
		l5.getFragmentList().add(fragmentsManager.getFragmentById("DOWNLOAD_MANAGER_MANAGER"));
		l5.getFragmentList().add(fragmentsManager.getFragmentById("GET_SYSTEM_SERVICE_DOWNLOAD_SERVICE"));
		l5.getFragmentList().add(fragmentsManager.getFragmentById("DOWNLOAD_MANAGER_ENQUEU_REQUEST_SEMICOLON"));

		l5.getFragmentList().add(fragmentsManager.getFragmentById("GET_CONTEXT()"));
		l5.getFragmentList().add(fragmentsManager.getFragmentById("OP_DOT"));
		l5.getFragmentList().add(fragmentsManager.getFragmentById("OP_EQUALS"));
		l5.getFragmentList().add(fragmentsManager.getFragmentById("OP_SEMICOLON"));
		l5.getFragmentList().add(fragmentsManager.getFragmentById("OP_NEW"));

		builder = new FragmentListBuilder(fragmentsManager);
		builder.add("REQUEST_REQUEST").add("OP_EQUALS").add("OP_NEW").add("REQUEST_URI").add("OP_SEMICOLON")
		.add("REQUEST_SET_VISIBLE_SEMICOLON").add("REQUEST_NOTIFICATION_VISIBILITY_SEMICOLON")
		.add("DOWNLOAD_MANAGER_MANAGER").add("OP_EQUALS").add("GET_CONTEXT()").add("OP_DOT").add("GET_SYSTEM_SERVICE_DOWNLOAD_SERVICE").add("OP_SEMICOLON")
		.add("DOWNLOAD_MANAGER_ENQUEU_REQUEST_SEMICOLON");

		l5.addAnswer(builder.buildAnswer());
		l5.getDialogKeywordFinder().addKeywordMapping(null, new Dialog("Continuer"));
		l5.getResultKeywordFinder().addKeywordMapping(null, "level5");


		GameLevel l6 = new GameLevel("level6", this);

		l6.setTitle("Mission 6");
		l6.setIntroText("« Avec ce nouveau virus beaucoup plus puissant nous allons pouvoir accéder à l’ensemble de son terminal. Si tu peux récupérer une prise de vue depuis son appareil photo, nous pourrions récolter des informations sur l’intérieur de sa planque. »");
		l6.setHelperText("Prendre une photo depuis la caméra frontale");

		l6.getFragmentList().add(fragmentsManager.getFragmentById("OP_RETURN"));

		builder = new FragmentListBuilder(fragmentsManager);
		builder.add("OP_RETURN");

		l6.addAnswer(builder.buildAnswer());
		l6.getDialogKeywordFinder().addKeywordMapping(null, new Dialog("Continuer"));
		l6.getResultKeywordFinder().addKeywordMapping(null, "level6");


		GameLevel l7 = new GameLevel("level7", this);

		l7.setTitle("Mission 7");
		l7.setIntroText(" « Il est visiblement dans une zone en extérieur. C’est inquiétant car il est à découvert, s’il ne se cache pas c’est qu’il est peut être prêt à passer à l’action. Je vais avertir une équipe sur le terrain, nous n’avons pas beaucoup de temps si nous devons intervenir. La meilleure manière d’obtenir des informations est d’accéder à la liste des derniers messages reçu, est-ce que tu peux faire ça ? »");
		l7.setHelperText("Retourne la liste des derniers SMS");

		
		l7.getFragmentList().add(fragmentsManager.getFragmentById("CURSOR_CURSOR"));
		l7.getFragmentList().add(fragmentsManager.getFragmentById("GET_CONTENT_RESOLVER"));
		l7.getFragmentList().add(fragmentsManager.getFragmentById("QUERY_CONTENT_SMS"));
		l7.getFragmentList().add(fragmentsManager.getFragmentById("RETURN_CURSOR_SEMICOLON"));
		l7.getFragmentList().add(fragmentsManager.getFragmentById("OP_DOT"));
		l7.getFragmentList().add(fragmentsManager.getFragmentById("OP_EQUALS"));
		l7.getFragmentList().add(fragmentsManager.getFragmentById("OP_SEMICOLON"));

		builder = new FragmentListBuilder(fragmentsManager);
		builder.add("CURSOR_CURSOR").add("OP_EQUALS").add("GET_CONTEXT()").add("OP_DOT").add("GET_CONTENT_RESOLVER").add("OP_DOT").add("QUERY_CONTENT_SMS").add("OP_SEMICOLON")
		.add("RETURN_CURSOR_SEMICOLON");


		l7.addAnswer(builder.buildAnswer());
		l7.getDialogKeywordFinder().addKeywordMapping(null, new Dialog("Continuer"));
		l7.getResultKeywordFinder().addKeywordMapping(null, "level7");



		GameLevel l8 = new GameLevel("level8", this);

		l8.setTitle("Mission 8");
		l8.setIntroText("« Ces conversation sont inquiétantes. Nos doutes se confirment. Les équipes techniques ont repérés un fichier non sécurisé « /log.txt » sur sa carte SD qui pourrait contenir des données intéressantes. Peux-tu récupérer le contenu ? »");
		
		l8.setHelperText("Retourner le contenu d'un fichier sur la carte SD du téléphone");

		l8.getFragmentList().add(fragmentsManager.getFragmentById("STRING_BUILDER_CONTENT"));
		l8.getFragmentList().add(fragmentsManager.getFragmentById("FILE_FILE"));
		l8.getFragmentList().add(fragmentsManager.getFragmentById("NEW_STRING_BUILDER"));

		l8.getFragmentList().add(fragmentsManager.getFragmentById("FILE_SD_CARD_ARTICLE_TXT_SEMICOLON"));
		l8.getFragmentList().add(fragmentsManager.getFragmentById("FILE_SD_CARD_LOG_TXT_SEMICOLON"));
		l8.getFragmentList().add(fragmentsManager.getFragmentById("CONTENT_COPY_FILE_SEMICOLON"));
		l8.getFragmentList().add(fragmentsManager.getFragmentById("OP_DOT"));
		l8.getFragmentList().add(fragmentsManager.getFragmentById("OP_EQUALS"));
		l8.getFragmentList().add(fragmentsManager.getFragmentById("OP_SEMICOLON"));
		l8.getFragmentList().add(fragmentsManager.getFragmentById("OP_NEW"));
		l8.getFragmentList().add(fragmentsManager.getFragmentById("OP_RETURN"));


	
		builder = new FragmentListBuilder(fragmentsManager);
		builder.add("STRING_BUILDER_CONTENT").add("OP_EQUALS").add("NEW_STRING_BUILDER").add("OP_SEMICOLON")
		.add("FILE_FILE").add("OP_EQUALS").add("OP_NEW").add("FILE_SD_CARD_LOG_TXT_SEMICOLON")
		.add("OP_RETURN").add("CONTENT_COPY_FILE_SEMICOLON");

		LevelAnswer l8a1 = builder.buildAnswer();
		KeywordManager.addKeyword(l8a1.getKeywords(), "com.dropsnorz.blackdoor.level", "LEVEL_USER_GET_LOG_FILE");
		KeywordManager.addKeyword(l8a1.getKeywords(), "com.dropsnorz.blackdoor.game", "USER_GET_LOG_FILE");
		l8.addAnswer(l8a1);

		
		builder = new FragmentListBuilder(fragmentsManager);
		builder.add("STRING_BUILDER_CONTENT").add("OP_EQUALS").add("NEW_STRING_BUILDER").add("OP_SEMICOLON")
		.add("FILE_FILE").add("OP_EQUALS").add("OP_NEW").add("FILE_SD_CARD_ARTICLE_TXT_SEMICOLON")
		.add("OP_RETURN").add("CONTENT_COPY_FILE_SEMICOLON");

		LevelAnswer l8a2 = builder.buildAnswer();
		KeywordManager.addKeyword(l8a2.getKeywords(), "com.dropsnorz.blackdoor.level", "LEVEL_USER_GET_ARTICLE_FILE");
		KeywordManager.addKeyword(l8a2.getKeywords(), "com.dropsnorz.blackdoor.game", "USER_GET_ARTICLE_FILE");
		l8.addAnswer(l8a2);
		
		
		ArrayList<String> keywordBind = new ArrayList<String>();
		keywordBind.add("USER_GET_LOG_FILE");
		l8.getDialogKeywordFinder().addKeywordMapping(keywordBind, new Dialog("Envoyer log.txt"));
		keywordBind = new ArrayList<String>();
		keywordBind.add("USER_GET_ARTICLE_FILE");
		l8.getDialogKeywordFinder().addKeywordMapping(keywordBind, new Dialog("Envoyer article.txt"));
		l8.getDialogKeywordFinder().addKeywordMapping(null, new Dialog("Continuer"));

		keywordBind = new ArrayList<String>();
		keywordBind.add("LEVEL_USER_GET_ARTICLE_FILE");
		l8.getResultKeywordFinder().addKeywordMapping(keywordBind, "level8-article");
		keywordBind = new ArrayList<String>();
		keywordBind.add("LEVEL_USER_GET_LOG_FILE");
		l8.getResultKeywordFinder().addKeywordMapping(keywordBind, "level8-log");

		/*
		gameLevelList.add(l1);
		gameLevelList.add(l2);
		gameLevelList.add(l3);
		gameLevelList.add(l4);
		gameLevelList.add(l5);
		gameLevelList.add(l6);
		gameLevelList.add(l7);
		*/
		
		gameLevelList.add(l8);

		currentGameLevel = l8;

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
	
	

	public ArrayList<String> getKeywords() {
		return keywords;
	}


	public void setKeywords(ArrayList<String> keywords) {
		this.keywords = keywords;
	}


	public FragmentsManager getFragmentsManager(){
		return fragmentsManager;
	}


	public KeywordManager getKeywordManager() {
		return keywordManager;
	}


}
