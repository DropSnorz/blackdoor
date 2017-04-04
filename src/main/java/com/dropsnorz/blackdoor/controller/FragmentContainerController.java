package com.dropsnorz.blackdoor.controller;

import java.util.ArrayList;

import com.dropsnorz.blackdoor.model.CodeFragment;
import com.dropsnorz.blackdoor.view.FragmentContainerView;

public class FragmentContainerController {
	
	FragmentContainerView view;
	
	public FragmentContainerController(){
		
		view = new FragmentContainerView();
	}
	
	public void setCodeFragmentList(ArrayList<CodeFragment> codeFragmentList){
		
		for(CodeFragment codeFragment: codeFragmentList){
			view.getChildren().add(new CodeFragmentController(codeFragment).getView());

		}
	}
	
	public FragmentContainerView getView(){
		return view;
	}

}
