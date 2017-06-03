package com.dropsnorz.blackdoor.level.model;

import java.util.ArrayList;

public class GameLevel {

	protected String id;
	protected String introText;
	protected String helperText;
	
	protected ArrayList<CodeFragment> fragmentList;
	protected ArrayList<CodeFragment> responseFragmentList;

	
	public GameLevel(String id){
		
		this.id = id;
		fragmentList = new ArrayList<CodeFragment>();
		responseFragmentList = new ArrayList<CodeFragment>();
		
	}
	
	public String getId() {
		return id;
	}

	
	public void setId(String id) {
		this.id = id;
	}

	public String getIntroText() {
		return introText;
	}


	public void setIntroText(String introText) {
		this.introText = introText;
	}


	public String getHelperText() {
		return helperText;
	}


	public void setHelperText(String helperText) {
		this.helperText = helperText;
	}


	public ArrayList<CodeFragment> getFragmentList() {
		return fragmentList;
	}


	public void setFragmentList(ArrayList<CodeFragment> fragmentList) {
		this.fragmentList = fragmentList;
	}


	public ArrayList<CodeFragment> getResponseFragmentList() {
		return responseFragmentList;
	}


	public void setResponseFragmentList(ArrayList<CodeFragment> responseFragmentList) {
		this.responseFragmentList = responseFragmentList;
	}
	
	
	
	
	
	
}
