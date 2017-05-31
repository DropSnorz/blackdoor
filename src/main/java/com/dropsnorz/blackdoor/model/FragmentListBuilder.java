package com.dropsnorz.blackdoor.model;

import java.util.ArrayList;

public class FragmentListBuilder {

	ArrayList<CodeFragment> fragmentList;
	FragmentsManager fragmentsManager;
	
	FragmentListBuilder(FragmentsManager fragmentsManager){
		
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
	
	
}
