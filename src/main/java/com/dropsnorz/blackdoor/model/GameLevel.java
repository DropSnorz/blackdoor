package com.dropsnorz.blackdoor.model;

import java.util.ArrayList;

public class GameLevel {


	protected String introText;
	protected String helperText;
	
	protected ArrayList<CodeFragment> fragmentList;
	protected ArrayList<CodeFragment> responseFragmentList;

	
	public GameLevel(){
		
		fragmentList = new ArrayList<CodeFragment>();
		responseFragmentList = new ArrayList<CodeFragment>();
		
	}
	
	
}
