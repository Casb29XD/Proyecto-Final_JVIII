package co.edu.uniquindio.proyecto_final.proyecto_final;

import co.edu.uniquindio.proyecto_final.proyecto_final.ViewController.BancoViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Banco UQ");
        mostrarVentanaPrincipal();

        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("BancoView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Banco");
        stage.setScene(scene);
        stage.show();*/

    }

    private void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("BancoView.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            BancoViewController bancoViewController = loader.getController();
//            bancoViewController.setAplicacion(this);
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            //scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
