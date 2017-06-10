package com.dropsnorz.blackdoor.core.model;

import java.util.ArrayList;
import java.util.HashMap;

public class KeywordFinder<T> {

	public HashMap<ArrayList<String>, T> keywordMappings;
	public ArrayList<T> defaultObjects;

	public KeywordFinder(){
		keywordMappings = new HashMap<ArrayList<String>, T>();
		defaultObjects = new ArrayList<T>();

	}

	public void addKeywordMapping(ArrayList<String> mapping, T object){

		if(mapping == null || mapping.size() == 0){
			defaultObjects.add(object);
		}
		else{
			keywordMappings.put(mapping, object);

		}
	}

	public T getFirstObject(ArrayList<String> keywords){
		
		
		for(ArrayList<String> map : keywordMappings.keySet()){
			ArrayList<String> intersection = new ArrayList<String>(keywords);
			intersection.retainAll(map);

			if(intersection.equals(map)){
				return keywordMappings.get(map);
			}
		}

		return defaultObjects.get(0);

	}


	public ArrayList<T> getObjects(ArrayList<String> keywords){

		ArrayList<T> result = new ArrayList<T>();
		
		result.addAll(defaultObjects);

		for(ArrayList<String> map : keywordMappings.keySet()){
			ArrayList<String> intersection = new ArrayList<String>(keywords);
			intersection.retainAll(map);

			if(intersection.equals(map)){
				result.add(keywordMappings.get(map));
			}
		}

		return result;

	}
}
