package com.dropsnorz.blackdoor.utils;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class TimerUtils {
	
	public static void scheduleUIAction(int delay, EventHandler<ActionEvent> handler){
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(delay),handler ));
		timeline.setCycleCount(1);
		timeline.playFromStart();
	}
}
