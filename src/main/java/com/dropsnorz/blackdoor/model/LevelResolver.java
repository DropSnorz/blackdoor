package com.dropsnorz.blackdoor.model;

import java.util.ArrayList;

public class LevelResolver {
	
	protected GameLevel level;
	
	public LevelResolver(GameLevel level){
		this.level = level;
	}
	
	public boolean resolve(ArrayList<CodeFragment> inputFragmentList){
		
		
		return inputFragmentList.equals(level.getResponseFragmentList());
	}

}
