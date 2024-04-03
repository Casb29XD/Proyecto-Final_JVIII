module co.edu.uniquindio.proyecto_final.proyecto_final {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;

    opens co.edu.uniquindio.proyecto_final.proyecto_final.ViewController to javafx.fxml;

    opens co.edu.uniquindio.proyecto_final.proyecto_final to javafx.fxml;

    exports co.edu.uniquindio.proyecto_final.proyecto_final;
}
