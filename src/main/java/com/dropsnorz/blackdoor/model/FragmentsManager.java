package com.dropsnorz.blackdoor.model;

import java.util.ArrayList;

public class FragmentsManager {
	
	protected ArrayList<CodeFragment> fragmentList;
	
	FragmentsManager(){
		
		fragmentList = new ArrayList<CodeFragment>();
	}
	
	
	public CodeFragment getFragmentById(String id){
		
		for(CodeFragment currentFragment : fragmentList){
			
			if(id.equals(currentFragment.getId())){
				return currentFragment;
			}
		}
		
		return null;
		
	}

	public ArrayList<CodeFragment> getFragmentList() {
		return fragmentList;
	}
	
	public void addFragment(CodeFragment codeFragment){
		//TODO check fragment id ?
		
		fragmentList.add(codeFragment);
	}
	
	

}
