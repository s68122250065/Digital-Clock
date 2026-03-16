package com.example.dc;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DigitalClock extends Application {

    @Override
    public void start(Stage stage) {

        Label clockLabel = new Label();
        clockLabel.setStyle("-fx-font-size: 40px; -fx-font-weight: bold;");
        clockLabel.setAlignment(Pos.CENTER);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    LocalTime now = LocalTime.now();
                    clockLabel.setText(now.format(formatter));
                })
        );

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        StackPane root = new StackPane(clockLabel);

        Scene scene = new Scene(root, 300, 150);

        stage.setTitle("Digital Clock");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}