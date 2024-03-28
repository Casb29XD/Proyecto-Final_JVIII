package co.edu.uniquindio.proyecto_final.proyecto_final.ViewController;

import co.edu.uniquindio.proyecto_final.proyecto_final.Controller.UsuarioController;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.EmpleadoDto;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.UsuarioDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.Optional;

public class UsuarioViewController {
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
    private  void eliminarUsuario(){}
    private  void actualizarUsuario(){}

    private UsuarioDto construirUsuarioDto() {
        return new UsuarioDto("123","martin","",new ArrayList<>());
    }
    private void limpiarCamposEmpleado() {
    }
    private boolean datosValidos(UsuarioDto usuarioDto){
        String mensaje="";
        if (usuarioDto.id() ==null || usuarioDto.id().equals("")){
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
