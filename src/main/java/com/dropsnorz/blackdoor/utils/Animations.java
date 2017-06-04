package com.dropsnorz.blackdoor.utils;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Animations {

	public static void labelTypingAnimation(final Label lbl, String descImp) {
		final String content = descImp;
		final Transition animation = new Transition() {
			{
				setCycleDuration(Duration.millis(3000));
				setDelay(Duration.seconds(1));
			}

			protected void interpolate(double frac) {
				final int length = content.length();
				final int n = Math.round(length * (float) frac);
				lbl.setText(content.substring(0, n));
			}
		};
		animation.play();

	}

	public static void textTypingAnimation(final Text lbl, String descImp) {
		final String content = descImp;
		final Transition animation = new Transition() {
			{
				setCycleDuration(Duration.millis(3000));
				setDelay(Duration.seconds(1));
			}

			protected void interpolate(double frac) {
				final int length = content.length();
				final int n = Math.round(length * (float) frac);
				lbl.setText(content.substring(0, n));
			}
		};
		animation.play();

	}

	public static void fadeOut(final Parent object, Duration delay){
		FadeTransition ft = new FadeTransition(Duration.millis(1000), object);
		ft.setDelay(delay);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);

		// Fade transition don't update view visible parameter
		// We have to set it manually to give the focus back
		ft.onFinishedProperty().set(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent actionEvent) {
				object.setVisible(false);
			}
		});

		ft.play();

	}

	public static void slideIn(final Pane object){

		double startWidth = object.getWidth();

		final Animation showSidebar = new Transition() {
			{ setCycleDuration(Duration.millis(250)); }
			protected void interpolate(double frac) {
				final double curWidth = startWidth * frac;
				object.setVisible(true);
				object.setTranslateX(-startWidth + curWidth);
			}
		};
		
		showSidebar.play();

	}

}
