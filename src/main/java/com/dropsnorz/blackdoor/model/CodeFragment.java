package com.dropsnorz.blackdoor.model;

public class CodeFragment {
	
	protected String id;
	protected String text;
	
	public CodeFragment(String id, String text){
		
		this.id = id;
		this.text = text;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public boolean equals(Object o){
		
		if(o instanceof CodeFragment){
			CodeFragment frag = (CodeFragment)o;
			return id.equals(frag.getId());
		}
		else{
			return super.equals(o);
		}
	}
	
	public String toString(){
		return text;
	}
	
	

}
