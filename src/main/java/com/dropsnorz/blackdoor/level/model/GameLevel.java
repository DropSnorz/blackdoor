package com.dropsnorz.blackdoor.level.model;

import java.util.ArrayList;

import com.dropsnorz.blackdoor.core.model.Game;
import com.dropsnorz.blackdoor.core.model.KeywordFinder;

public class GameLevel {

	protected String id;
	protected String title;
	protected String introText;
	protected String helperText;
	protected String preWrittenCode;
	
	protected ArrayList<CodeFragment> fragmentList;
	protected ArrayList<LevelAnswer> answerList;
	
	protected KeywordFinder<Dialog> dialogKeywordFinder;
	protected KeywordFinder<GameLevel> nextLevelKeywordFinder;
	protected KeywordFinder<String> responseKeywordFinder;
	
	protected ArrayList<String> keywords;
	
	protected Game game;
	

	
	public GameLevel(String id, Game game){
		
		this.id = id;
		fragmentList = new ArrayList<CodeFragment>();
		answerList = new ArrayList<LevelAnswer>();
		keywords = new ArrayList<String>();
		
		dialogKeywordFinder = new KeywordFinder<Dialog>();
		
		this.game = game;
		
	}
	
	public ArrayList<Dialog> getDialogs(){
		return dialogKeywordFinder.getObjects(game.getKeywordManager().getAllKeywords());
	}
	
	public String getId() {
		return id;
	}

	
	public void setId(String id) {
		this.id = id;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroText() {
		return introText;
	}


	public void setIntroText(String introText) {
		this.introText = introText;
	}


	public String getHelperText() {
		return helperText;
	}


	public void setHelperText(String helperText) {
		this.helperText = helperText;
	}

	public String getPreWrittenCode() {
		return preWrittenCode;
	}

	public void setPreWrittenCode(String preWrittenCode) {
		this.preWrittenCode = preWrittenCode;
	}

	public ArrayList<CodeFragment> getFragmentList() {
		return fragmentList;
	}


	public void setFragmentList(ArrayList<CodeFragment> fragmentList) {
		this.fragmentList = fragmentList;
	}

	public void addAnswer(LevelAnswer answer){
		this.answerList.add(answer);
	}

	public ArrayList<LevelAnswer> getAnswerList() {
		return answerList;
	}


	public ArrayList<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(ArrayList<String> keywords) {
		this.keywords = keywords;
	}

	public void setAnswerList(ArrayList<LevelAnswer> answerList) {
		this.answerList = answerList;
	}

	public KeywordFinder<Dialog> getDialogKeywordFinder() {
		return dialogKeywordFinder;
	}
	
}
