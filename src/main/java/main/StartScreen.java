package main;

import entities.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import static java.awt.SystemColor.text;
import static main.Main.GAMEHEIGHT;
import static main.Main.GAMEWIDTH;

public class StartScreen {
    Pane uiRoot;
    Pane levelRoot;
    Pane playerRoot;
    Stage primaryStage;
    protected Game game;
    public static Player playerInstance;

    public StartScreen(Pane uiRoot, Pane levelRoot, Pane playerRoot, Stage primaryStage) {
        this.uiRoot = uiRoot;
        this.levelRoot = levelRoot;
        this.playerRoot = playerRoot;
        this.primaryStage = primaryStage;
    }

    void renderStartScreen() {
        uiRoot.setStyle("-fx-background-color: #87ce87;");
        uiRoot.setPrefSize(GAMEWIDTH, GAMEHEIGHT);

        Label gameName = new Label("ROLLING  RIFT");
        gameName.setFont(Font.font("Game Over", FontWeight.BOLD, 200));
        gameName.setAlignment(Pos.TOP_CENTER);
        gameName.setStyle("-fx-text-fill: black;");


        Button newGameButton = new Button("New Game");
        Button loadGameButton = new Button("Load Game");
        newGameButton.setFont(Font.font("Gameplay", FontWeight.BOLD, 20));
        loadGameButton.setFont(Font.font("Gameplay", FontWeight.BOLD, 19));

        newGameButton.setOnMouseMoved(event -> {
                newGameButton.setStyle("-fx-background-color: #78ced9; ");
        });
        newGameButton.setOnMouseExited(event -> {
                newGameButton.setStyle("-fx-background-color: #ffffff; ");
        });
        loadGameButton.setOnMouseMoved(event -> {
                loadGameButton.setStyle("-fx-background-color: #78ced9");
        });
        loadGameButton.setOnMouseExited(event -> {
                loadGameButton.setStyle("-fx-background-color: #ffffff; ");
        });


        newGameButton.setOnAction(event -> {
                setupGameScene();
        });


        HBox hBox = new HBox();
        hBox.setSpacing(20);

        hBox.getChildren().addAll(newGameButton, loadGameButton);
        hBox.setAlignment(Pos.CENTER);


        HBox topBox = new HBox();
        topBox.setFillHeight(true);
        topBox.getChildren().add(gameName);
        topBox.setAlignment(Pos.CENTER);

        topBox.setMargin(gameName, new Insets(300, 0, 0, 0));
        BorderPane layout = new BorderPane();

        layout.setPrefSize(GAMEWIDTH, GAMEHEIGHT);
        layout.setTop(topBox);
        layout.setCenter(hBox);

        HBox bottomBox = new HBox();
        topBox.setMaxHeight(100);

        layout.setBottom(bottomBox);
        uiRoot.getChildren().add(layout);
    }

    private void setupGameScene() {
        Scene gameScene = new Scene(new Pane(playerRoot, levelRoot), GAMEWIDTH, GAMEHEIGHT);
        game = new Game(levelRoot, gameScene);
        playerInstance = new Player(playerRoot);
        game.startGame(primaryStage);

    }
}