package com.dropsnorz.blackdoor.level.model;

import java.util.ArrayList;

public class FragmentListBuilder {

	ArrayList<CodeFragment> fragmentList;
	FragmentsManager fragmentsManager;
	
	public FragmentListBuilder(FragmentsManager fragmentsManager){
		
		this.fragmentsManager = fragmentsManager;
		fragmentList = new ArrayList<CodeFragment>();
			
	}
	
	public FragmentListBuilder add(String fragmentId){
		CodeFragment fragment = fragmentsManager.getFragmentById(fragmentId);
		fragmentList.add(fragment);
		
		return this;
	}
	
	public ArrayList<CodeFragment> build(){
		
		return  fragmentList;
	}
	
	public LevelAnswer buildAnswer(){
		return new LevelAnswer(fragmentList);
	}
	
	
}
