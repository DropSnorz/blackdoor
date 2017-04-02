package com.dropsnorz.blackdoor.controller;

import com.dropsnorz.blackdoor.view.FragmentContainerView;

public class FragmentContainerController {
	
	FragmentContainerView view;
	
	public FragmentContainerController(){
		
		view = new FragmentContainerView();
	}
	
	public FragmentContainerView getView(){
		return view;
	}

}
