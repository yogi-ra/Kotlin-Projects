import javafx.application.Application
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import kotlin.random.Random

class GuessTheNumberGame : Application() {
    private var randomNumber = Random.nextInt(1, 101)
    private var guess = 0
    private var attempts = 0
    
    override fun start(primaryStage: Stage) {
        val root = BorderPane()
        root.style = "-fx-background-color: #f0f0f0;"
        
        val centerLabel = Label("I'm thinking of a number between 1 and 100. Can you guess what it is?")
        centerLabel.style = "-fx-font-size: 16pt; -fx-padding: 10px;"
        centerLabel.alignment = Pos.CENTER
        root.center = centerLabel
        
        val guessLabel = Label("Guess:")
        guessLabel.style = "-fx-font-size: 14pt; -fx-padding: 10px;"
        
        val guessField = TextField()
        guessField.style = "-fx-font-size: 14pt; -fx-padding: 10px;"
        
        val guessButton = Button("Guess")
        guessButton.style = "-fx-font-size: 14pt; -fx-padding: 10px;"
        guessButton.setOnAction {
            attempts++
            guess = guessField.text.toIntOrNull() ?: 0
            
            val resultLabel: Label
            if (guess == randomNumber) {
                if (attempts == 1) {
                    resultLabel = Label("Congratulations! You guessed correctly in $attempts attempt.\nHere's your flag: TKJCyberLAB{ubah_value_aj4}")
                    resultLabel.style = "-fx-font-size: 16pt; -fx-padding: 10px;"
                    resultLabel.alignment = Pos.CENTER
                } else {
                    resultLabel = Label("Congratulations! You guessed correctly in $attempts attempts.")
                    resultLabel.style = "-fx-font-size: 16pt; -fx-padding: 10px;"
                    resultLabel.alignment = Pos.CENTER
                }
                
                val resetButton = Button("Reset")
                resetButton.style = "-fx-font-size: 14pt; -fx-padding: 10px;"
                resetButton.setOnAction {
                    resetGame()
                    root.center = centerLabel
                }
                
                val centerBox = BorderPane(resultLabel)
                centerBox.bottom = resetButton
                BorderPane.setAlignment(resetButton, Pos.CENTER)
                root.center = centerBox
            } else if (guess > randomNumber) {
                resultLabel = Label("Too high, try again!")
                resultLabel.style = "-fx-font-size: 16pt; -fx-padding: 10px;"
                resultLabel.alignment = Pos.CENTER
                root.center = resultLabel
            } else {
                resultLabel = Label("Too low, try again!")
                resultLabel.style = "-fx-font-size: 16pt; -fx-padding: 10px;"
                resultLabel.alignment = Pos.CENTER
                root.center = resultLabel
            }
        }
        
        val bottomBox = BorderPane()
        bottomBox.left = guessLabel
        bottomBox.center = guessField
        bottomBox.right = guessButton
        BorderPane.setAlignment(guessLabel, Pos.CENTER)
        BorderPane.setAlignment(guessButton, Pos.CENTER)
        
        root.bottom = bottomBox
        
        val scene = Scene(root, 300.0, 150.0)
        primaryStage.title = "Guess the Number"
        primaryStage.scene = scene
        primaryStage.show()
    }
    
    private fun resetGame() {
        randomNumber = Random.nextInt(1, 101)
        guess = 0
        attempts = 0
    }
}

fun main() {
	Application.launch(GuessTheNumberGame::class.java)
}