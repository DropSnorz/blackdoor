package com.dropsnorz.blackdoor.core.model;

import java.util.ArrayList;
import java.util.HashMap;

public class KeywordManager {

	protected Game game;

	public KeywordManager(Game game){
		
		this.game = game;
	}

	public ArrayList<String> getKeywords(String domain){
		
		if(domain.equals("com.dropsnorz.blackdoor.game")){
			return game.getKeywords();

		}
		else if(domain.equals("com.dropsnorz.blackdoor.level")){
			return game.getCurrentGameLevel().getKeywords();

		}
		
		return new ArrayList<String>();

	}
	
	public ArrayList<String> getAllKeywords(){
		ArrayList<String> list = new ArrayList<String>(); 
		list.addAll(getKeywords("com.dropsnorz.blackdoor.game"));
		list.addAll(getKeywords("com.dropsnorz.blackdoor.level"));

		return list;
		
	}

	public void addKeywords(HashMap<String, ArrayList<String>> newKeywords){

		for(String key : newKeywords.keySet()){
			
			if(key.equals("com.dropsnorz.blackdoor.game")){
				for(String value : newKeywords.get(key)){
					if(!game.getKeywords().contains(value)){
						game.getKeywords().add(value);

					}
					
				}

			}
			else if(key.equals("com.dropsnorz.blackdoor.level")){
				for(String value : newKeywords.get(key)){
					if(!game.getCurrentGameLevel().getKeywords().contains(value)){
						game.getCurrentGameLevel().getKeywords().add(value);

					}					
				}

			}
		}
	}

	public void spawnKeywords(KeywordSpawner spawner){
		addKeywords(spawner.getSpawnedKeywords());
	}


	public static void addKeyword(HashMap<String, ArrayList<String>> map, String key, String keyword){

		if(map.get(key) == null){
			map.put(key, new ArrayList<String>());
		}

		map.get(key).add(keyword);
	}
	
}
