package co.edu.uniquindio.proyecto_final.proyecto_final.Controller.Service;

import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.UsuarioDto;

import java.util.List;

public interface IModelFactoryService {
    List<UsuarioDto> obtenerUsuarios();
    boolean agregarUsuario(UsuarioDto usuarioDto);
    boolean eliminarUsuario(int id);
    boolean actualizarUsuario(int id, UsuarioDto usuarioDto);
}
