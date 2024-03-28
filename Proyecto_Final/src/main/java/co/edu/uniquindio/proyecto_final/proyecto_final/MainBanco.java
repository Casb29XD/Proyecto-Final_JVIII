package co.edu.uniquindio.proyecto_final.proyecto_final;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainBanco {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Welcome to JavaFX Application!");
    }
}