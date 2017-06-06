package com.dropsnorz.blackdoor.level.model;

public class CodeFragment {
	
	protected String id;
	protected String text;
	protected CodeFragmentType type;
	
	public CodeFragment(String id, String text){
		
		this.id = id;
		this.text = text;
		type = CodeFragmentType.TYPE_UNSPECIFIED;
		
	}

	public CodeFragment(String id, String text, CodeFragmentType type) {
		this.id = id;
		this.text = text;
		this.type = type;
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
	
	
	public CodeFragmentType getType() {
		return type;
	}

	public void setType(CodeFragmentType type) {
		this.type = type;
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
