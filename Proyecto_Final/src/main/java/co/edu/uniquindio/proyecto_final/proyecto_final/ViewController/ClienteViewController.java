package co.edu.uniquindio.proyecto_final.proyecto_final.ViewController;

import co.edu.uniquindio.proyecto_final.proyecto_final.Controller.UsuarioController;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.UsuarioDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Optional;

public class ClienteViewController {
    @FXML
    private TextField txtCorreo;

    @FXML
    private TableColumn<?, ?> tcCorreo;

    @FXML
    private Button btnNuevo;

    @FXML
    private Button btnActualizar;

    @FXML
    private TextField txtCedula;

    @FXML
    private TableColumn<?, ?> tcCedula;

    @FXML
    private DatePicker DateReserva;

    @FXML
    private TableView<?> tableClientes;

    @FXML
    private Button btnEliminar;

    @FXML
    private TextField txtNombre;

    @FXML
    private TableColumn<?, ?> tcNombre;

    @FXML
    private TableColumn<?, ?> tcReserva;

    @FXML
    private Button btnAgregar;

    UsuarioController usuarioControllerService;
    ObservableList<UsuarioDto> listaUsuarioDtos = FXCollections.observableArrayList();
    UsuarioDto usuarioSeleccionado;

    private void obtenerUsuarios() {
        listaUsuarioDtos.addAll(usuarioControllerService.obtenerUsuarios());
    }
    private void creaUsuario() {
        //1. Capturar los datos
        UsuarioDto usuarioDto= construirUsuarioDto();
        //2. Validar la información
        if(datosValidos(usuarioDto)){
            if(usuarioControllerService.agregarUsuario(usuarioDto)){
                listaUsuarioDtos.add(usuarioDto);
                mostrarMensaje("Notificación usuario", "usuario creado", "El usuario se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposEmpleado();
            }else{
                mostrarMensaje("Notificación usuario", "usuario no creado", "El usuario no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación usuario", "usuario no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }

    }
    @FXML
    void NuevoClienteAction(ActionEvent event) {
        txtNombre.setText("Ingrese el nombre");
        txtCedula.setText("Ingrese la cedula");
        txtCorreo.setText("Ingrese el correo");
    }
    @FXML
    void eliminarClienteAction(){

    }
    @FXML
    void ActualizarClienteAction(){

    }
    @FXML
    void AgregarClienteAction(){

    }

    private UsuarioDto construirUsuarioDto() {
        return new UsuarioDto(123,"martin","",new ArrayList<>());
    }
    private void limpiarCamposEmpleado() {
    }
    private boolean datosValidos(UsuarioDto usuarioDto){
        String mensaje="";
        if (usuarioDto.id() == 0){
            mensaje += "El id es invalido \n" ;
        }if (usuarioDto.nombre()==null || usuarioDto.nombre().equals("")){
            mensaje += "El nombre es invalido \n" ;
        }if (usuarioDto.correo()==null || usuarioDto.correo().equals("")){
            mensaje += "El correo es invalido \n" ;
        }if (mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación cliente","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }
}
