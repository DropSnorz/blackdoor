package com.dropsnorz.blackdoor.tutorial.model;

import javafx.scene.Node;

public class TutorialStep {
	
	protected Node targetNode;
	protected String message;
	
	protected double offsetX;
	protected double offsetY;
	
	
	public TutorialStep(Node targetNode, String message, double offset_x, double offset_y) {
		super();
		this.targetNode = targetNode;
		this.message = message;
		this.offsetX = offset_x;
		this.offsetY = offset_y;
	}
	
	public Node getTargetNode() {
		return targetNode;
	}
	public void setTargetNode(Node targetNode) {
		this.targetNode = targetNode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getOffsetX() {
		return offsetX;
	}
	public void setOffsetX(double offset_x) {
		this.offsetX = offset_x;
	}
	public double getOffsetY() {
		return offsetY;
	}
	public void setOffsetY(double offset_y) {
		this.offsetY = offset_y;
	}
	
	

}
