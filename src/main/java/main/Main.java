package main;

import entities.Player;
import javafx.animation.AnimationTimer;
import javafx.animation.ParallelTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {
    public static final int GAMEWIDTH = 1280;
    public static final int GAMEHEIGHT = 720;
    protected Pane levelRoot = new Pane();
    protected Pane playerRoot = new Pane();
    protected Pane uiRoot = new Pane();


    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene uiScene = new Scene(uiRoot, GAMEWIDTH, GAMEHEIGHT);

        StartScreen startScreen = new StartScreen(uiRoot, levelRoot, playerRoot, primaryStage);
        startScreen.renderStartScreen();

        primaryStage.setScene(uiScene);
        primaryStage.show();
    }
}
