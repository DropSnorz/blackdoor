package com.dropsnorz.blackdoor.core.model;

import java.util.ArrayList;
import java.util.HashMap;

public class KeywordManager {
	
	protected HashMap<String, ArrayList<String>> keywords;
	
	public KeywordManager(){
		
		keywords = new HashMap<String, ArrayList<String>>();
		keywords.put("com.dropsnorz.blackdoor.level", new ArrayList<String>());
	}
	
	public ArrayList<String> getKeywords(String domain){
		return keywords.get(domain);
		
	}
	
	public void addKeywords(HashMap<String, ArrayList<String>> newKeywords){
		
		for(String newKey: newKeywords.keySet()){
			if(!keywords.keySet().contains(newKey)){
				keywords.put(newKey, newKeywords.get(newKey));
			}
			else{
				for(String newKeyword : newKeywords.get(newKey)){
					keywords.get(newKey).add(newKeyword);
				}
			}
		}
	}
	
	public void spawnKeywords(KeywordSpawner spawner){
		addKeywords(spawner.getSpawnedKeywords());
	}

}
