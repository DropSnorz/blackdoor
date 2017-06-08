package com.dropsnorz.blackdoor.level.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.dropsnorz.blackdoor.core.model.KeywordSpawner;

public class LevelAnswer implements KeywordSpawner {
	
	protected ArrayList<CodeFragment> fragmentList;
	protected HashMap<String, ArrayList<String>> keywords;
	
	public LevelAnswer(){
		
		this.fragmentList = new ArrayList<CodeFragment>();
		keywords = new HashMap<String, ArrayList<String>>();
		
	}
	
	
	public LevelAnswer(ArrayList<CodeFragment> fragmentList) {
		this.fragmentList = fragmentList;
		keywords = new HashMap<String, ArrayList<String>>();

	}

	public ArrayList<CodeFragment> getFragmentList() {
		return fragmentList;
	}

	public void setFragmentList(ArrayList<CodeFragment> fragmentList) {
		this.fragmentList = fragmentList;
	}


	public HashMap<String, ArrayList<String>> getKeywords() {
		return keywords;
	}


	public void setKeywords(HashMap<String, ArrayList<String>> keywords) {
		this.keywords = keywords;
	}


	@Override
	public HashMap<String, ArrayList<String>> getSpawnedKeywords() {
		// TODO Auto-generated method stub
		return keywords;
	}
	
	

}
