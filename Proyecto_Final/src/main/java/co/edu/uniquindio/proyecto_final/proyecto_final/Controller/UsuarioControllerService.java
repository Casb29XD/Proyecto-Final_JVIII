package co.edu.uniquindio.proyecto_final.proyecto_final.Controller;

import co.edu.uniquindio.proyecto_final.proyecto_final.Controller.Service.IUsuarioControllerService;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.EmpleadoDto;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.UsuarioDto;

import java.util.List;

public class UsuarioControllerService implements IUsuarioControllerService {
    @Override
    public List<UsuarioDto> obtenerUsuarios() {
        return null;
    }

    @Override
    public boolean agregarUsuario(EmpleadoDto empleado) {
        return false;
    }

    @Override
    public boolean eliminarUsuario(int id) {
        return false;
    }

    @Override
    public boolean actualizarUsuario(int id, EmpleadoDto empleado) {
        return false;
    }
}
