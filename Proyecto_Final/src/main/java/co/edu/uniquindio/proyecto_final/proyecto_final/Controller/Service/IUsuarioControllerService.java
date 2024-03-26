package co.edu.uniquindio.proyecto_final.proyecto_final.Controller.Service;

import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.EmpleadoDto;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.UsuarioDto;

import java.util.List;

public interface IUsuarioControllerService {
    List<UsuarioDto> obtenerUsuarios();
    boolean agregarUsuario(EmpleadoDto empleado);
    boolean eliminarUsuario(int id);
    boolean actualizarUsuario(int id, EmpleadoDto empleado);
}
