package com.dropsnorz.blackdoor.level.model;

import java.util.ArrayList;

import com.dropsnorz.blackdoor.core.model.Game;
import com.dropsnorz.blackdoor.core.model.KeywordFinder;

public class GameLevel {

	protected String id;
	protected String introText;
	protected String helperText;
	
	protected ArrayList<CodeFragment> fragmentList;
	protected ArrayList<CodeFragment> responseFragmentList;
	
	protected KeywordFinder<Dialog> dialogKeywordFinder;
	protected KeywordFinder<GameLevel> nextLevelKeywordFinder;
	protected KeywordFinder<String> responseKeywordFinder;
	
	protected Game game;
	

	
	public GameLevel(String id, Game game){
		
		this.id = id;
		fragmentList = new ArrayList<CodeFragment>();
		responseFragmentList = new ArrayList<CodeFragment>();
		
		dialogKeywordFinder = new KeywordFinder<Dialog>();
		
		this.game = game;
		
	}
	
	public ArrayList<Dialog> getDialogs(){
		return dialogKeywordFinder.getObjects(game.getKeywordManager().getKeywords("com.dropsnorz.blackdoor.level"));
	}
	
	public String getId() {
		return id;
	}

	
	public void setId(String id) {
		this.id = id;
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


	public ArrayList<CodeFragment> getFragmentList() {
		return fragmentList;
	}


	public void setFragmentList(ArrayList<CodeFragment> fragmentList) {
		this.fragmentList = fragmentList;
	}


	public ArrayList<CodeFragment> getResponseFragmentList() {
		return responseFragmentList;
	}


	public void setResponseFragmentList(ArrayList<CodeFragment> responseFragmentList) {
		this.responseFragmentList = responseFragmentList;
	}

	public KeywordFinder<Dialog> getDialogKeywordFinder() {
		return dialogKeywordFinder;
	}
	
}
