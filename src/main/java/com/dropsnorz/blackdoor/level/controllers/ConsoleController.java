package com.dropsnorz.blackdoor.level.controllers;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.dropsnorz.blackdoor.level.view.ConsoleView;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ConsoleController {

	protected ConsoleView view;
	protected ArrayList<String> textOutput;

	protected Timer timer;
	protected EventHandler<Event> handler;

	public ConsoleController(){

		view = new ConsoleView();
	
		handler = new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				
			}
		};

	}

	public void write(String text){

		if (timer == null){
			timer = new Timer();
		}
		
		ArrayList<String> outputs = new ArrayList<String>();
		outputs.add("Generate Binairies...");
		outputs.add("Sending data to target device...");
		outputs.add("Waiting for incoming outputs...");
		long duration = 1000;


		for(String output : outputs){
			timer.schedule(new ConsoleTimerTask(output), duration);
			duration += Math.random() * 1000; 

		}

		timer.schedule(new ConsoleTimerTask(text), duration);
		timer.schedule(new NotifyEndTimerTask(this), duration + 1000);

	}

	public void onEndConsoleDisplay(EventHandler<Event> handler){
		this.handler = handler;
	}

	public void clear(){
		this.getView().getChildren().clear();
	}

	public ConsoleView getView(){
		return view;
	}

	class ConsoleTimerTask extends TimerTask{

		String text;

		public ConsoleTimerTask(String text) {
			this.text = text;
		}

		@Override
		public void run() {

			Platform.runLater(new Runnable(){

				@Override
				public void run() {
					view.appendText(text);

				}

			});

		}

	}

	class NotifyEndTimerTask extends TimerTask{

		ConsoleController consoleController;
		public NotifyEndTimerTask (ConsoleController consoleController){
			this.consoleController = consoleController;
		}
		@Override
		public void run() {
			
			Platform.runLater(new Runnable(){

				@Override
				public void run() {
					timer.cancel();
					timer = null;
					handler.handle(null);
					
				}			
			});

		}

	}
}
