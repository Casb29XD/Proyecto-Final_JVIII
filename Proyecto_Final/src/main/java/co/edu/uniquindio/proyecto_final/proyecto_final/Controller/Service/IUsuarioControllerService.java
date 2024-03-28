package co.edu.uniquindio.proyecto_final.proyecto_final.Controller.Service;

import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.UsuarioDto;

import java.util.List;

public interface IUsuarioControllerService {
    List<UsuarioDto> obtenerUsuarios();
    boolean agregarUsuario(UsuarioDto usuario);
    boolean eliminarUsuario(String id);
    boolean actualizarUsuario(String id, UsuarioDto usuario);
}
