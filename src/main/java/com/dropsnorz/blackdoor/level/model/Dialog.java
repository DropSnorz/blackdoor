package com.dropsnorz.blackdoor.level.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.dropsnorz.blackdoor.core.model.KeywordSpawner;

public class Dialog implements KeywordSpawner {
	
	protected String text;
	protected ArrayList<String> generatedKeywords;
	
	public Dialog(String text, ArrayList<String> generatedKeywords) {
		super();
		this.text = text;
		this.generatedKeywords = generatedKeywords;
	}
	
	public Dialog(String text){
		this.text = text;
		this.generatedKeywords = new ArrayList<String>();
		
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ArrayList<String> getGeneratedKeywords() {
		return generatedKeywords;
	}

	public void setGeneratedKeywords(ArrayList<String> generatedKeywords) {
		this.generatedKeywords = generatedKeywords;
	}

	@Override
	public HashMap<String, ArrayList<String>> getSpawnedKeywords() {
		// TODO Auto-generated method stub
		
		HashMap<String, ArrayList<String>> keywords = new HashMap<String, ArrayList<String>>();
		keywords.put("com.dropsnorz.blackdoor.game", generatedKeywords);
		return keywords;
	}
	
	
	
	
	

}
