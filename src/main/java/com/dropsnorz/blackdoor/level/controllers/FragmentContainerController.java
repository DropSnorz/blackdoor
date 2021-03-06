package com.dropsnorz.blackdoor.level.controllers;

import java.util.ArrayList;

import com.dropsnorz.blackdoor.level.model.CodeFragment;
import com.dropsnorz.blackdoor.level.view.FragmentContainerView;

public class FragmentContainerController {
	
	FragmentContainerView view;
	
	public FragmentContainerController(){
		
		view = new FragmentContainerView();
	}
	
	public void setCodeFragmentList(ArrayList<CodeFragment> codeFragmentList){
		
		view.getChildren().clear();
		for(CodeFragment codeFragment: codeFragmentList){
			view.getChildren().add(new CodeFragmentController(codeFragment).getView());

		}
	}
	
	public FragmentContainerView getView(){
		return view;
	}

}
