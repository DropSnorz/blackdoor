package com.dropsnorz.blackdoor.level.model;

import java.util.ArrayList;

import com.dropsnorz.blackdoor.core.model.KeywordManager;

public class LevelResolver {
	
	protected GameLevel level;
	protected KeywordManager keywordManager;
	
	public LevelResolver(GameLevel level, KeywordManager keywordManager){
		this.level = level;
		this.keywordManager = keywordManager;
	}
	
	public boolean resolve(ArrayList<CodeFragment> inputFragmentList){
		
		
		for(LevelAnswer answer :level.getAnswerList()){
			
			if(inputFragmentList.equals(answer.getFragmentList())){
				keywordManager.spawnKeywords(answer);
				return true;
			}
			
		}
		return false;
	}

}
