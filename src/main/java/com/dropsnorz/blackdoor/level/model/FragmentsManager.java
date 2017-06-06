package com.dropsnorz.blackdoor.level.model;

import java.util.ArrayList;

public class FragmentsManager {
	
	protected ArrayList<CodeFragment> fragmentList;
	private CodeFragment blankFragment;
	
	public FragmentsManager(){
		
		fragmentList = new ArrayList<CodeFragment>();
		blankFragment = new CodeFragment("","");
		
	}
	
	
	public CodeFragment getFragmentById(String id){
		
		for(CodeFragment currentFragment : fragmentList){
			
			if(id.equals(currentFragment.getId())){
				return currentFragment;
			}
		}
		
		return blankFragment;
		
	}

	public ArrayList<CodeFragment> getFragmentList() {
		return fragmentList;
	}
	
	public void addFragment(CodeFragment codeFragment){
		//TODO check fragment id ?
		
		fragmentList.add(codeFragment);
	}
	
	

}
