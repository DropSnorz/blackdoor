package com.dropsnorz.blackdoor.level.model;

import java.util.ArrayList;

import com.dropsnorz.blackdoor.core.model.KeywordManager;

public class LevelResolver {

	protected GameLevel level;
	protected KeywordManager keywordManager;
	
	protected ArrayList<String> errorList;

	public LevelResolver(GameLevel level, KeywordManager keywordManager){
		this.level = level;
		this.keywordManager = keywordManager;
		this.errorList = new ArrayList<String>();
	}

	public boolean resolve(ArrayList<CodeFragment> inputFragmentList){

		level.getKeywords().clear();

		for(LevelAnswer answer :level.getAnswerList()){

			if(inputFragmentList.equals(answer.getFragmentList())){

				keywordManager.spawnKeywords(answer);

				return true;
			}

		}
		
		
		
		for(LevelAnswer answer :level.getAnswerList()){

			if(checkMissingFragment(inputFragmentList, answer.getFragmentList(), "OP_SEMICOLON")){
				errorList.add("Missing semicolon ';'");
			}
			
			if (checkMissingFragment(inputFragmentList, answer.getFragmentList(), "OP_NEW")){
				errorList.add("Missing 'new' operator");

			}


		}
		
		
		
		return false;
	}
	
	public boolean checkMissingFragment(ArrayList<CodeFragment> input, ArrayList<CodeFragment> answer, String id){
		
		ArrayList<CodeFragment> reject = new ArrayList<CodeFragment>(answer);
		
		reject.removeAll(input);
		
		boolean state = true;
		for(CodeFragment fragment : reject){
			
			if(!fragment.getId().equals(id))return false;
			
		}
		
		
		return true;
	}

	public ArrayList<String> getErrorList() {
		return errorList;
	}
	
	

}
