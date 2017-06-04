package com.dropsnorz.blackdoor.core.model;

import java.util.ArrayList;
import java.util.HashMap;

public class KeywordFinder<T> {

	public HashMap<ArrayList<String>, T> keywordMappings;
	public T defaultObject;

	public KeywordFinder(){
		keywordMappings = new HashMap<ArrayList<String>, T>();

	}

	public void addKeywordMapping(ArrayList<String> mapping, T object){

		if(mapping == null || mapping.size() == 0){
			defaultObject = object;
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

		return null;

	}


	public ArrayList<T> getObjects(ArrayList<String> keywords){

		ArrayList<T> result = new ArrayList<T>();
		
		if(defaultObject != null){
			result.add(defaultObject);
		}

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
