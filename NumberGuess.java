package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends Application {

    private int randomNumber;
    private int numGuesses = 0;
    private int maxGuesses = 10;
    private int score = 0;
    private List<Integer> guessHistory = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Guess a number between 1 and 100:");
        TextField textField = new TextField();
        Button submitButton = new Button("Submit");
        Button hintButton = new Button("Hint");
        Button historyButton = new Button("History");
        Label scoreLabel = new Label("Score: 0");

        submitButton.setOnAction(event -> {
            int guess = Integer.parseInt(textField.getText());
            guessHistory.add(guess);
            if (guess == randomNumber) {
                label.setText("You guessed the number in " + numGuesses + " tries!\n" + "The number was " + randomNumber + "\n" + "Thanks for playing!");
                textField.setDisable(true);
                submitButton.setDisable(true);
                hintButton.setDisable(true);
                score++;
                scoreLabel.setText("Score: " + score);
            } else if (guess < randomNumber) {
                label.setText("Too low! Guess again:");
                numGuesses++;
                if (numGuesses >= maxGuesses) {
                    label.setText("You have reached the maximum number of guesses.\n" + "The number was " + randomNumber + "\n" + "Thanks for playing!");
                    textField.setDisable(true);
                    submitButton.setDisable(true);
                    hintButton.setDisable(true);
                }
            } else {
                label.setText("Too high! Guess again:");
                numGuesses++;
                if (numGuesses >= maxGuesses) {
                    label.setText("You have reached the maximum number of guesses.\n" + "The number was " + randomNumber + "\n" + "Thanks for playing!");
                    textField.setDisable(true);
                    submitButton.setDisable(true);
                    hintButton.setDisable(true);
                }
            }
        });

        hintButton.setOnAction(event -> {
            if (randomNumber % 2 == 0) {
                label.setText("Hint: The number is even.");
            } else {
                label.setText("Hint: The number is odd.");
            }
        });

        historyButton.setOnAction(event -> {
            String history = "";
            for (int i = 0; i < guessHistory.size(); i++) {
                history += "Guess #" + (i + 1) + ": " + guessHistory.get(i) + "\n";
            }
            label.setText("Guess history:\n" + history);
        });

        HBox hBox = new HBox(20, submitButton, hintButton, historyButton, scoreLabel);
        hBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(20, label, textField, hBox);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Number Guessing Game");
        primaryStage.show();
        randomNumber = new Random().nextInt(100) + 1;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
