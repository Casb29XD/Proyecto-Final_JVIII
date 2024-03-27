package co.edu.uniquindio.proyecto_final.proyecto_final.Controller;

import co.edu.uniquindio.proyecto_final.proyecto_final.Controller.Service.IModelFactoryService;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.UsuarioDto;

import java.util.List;

public class ModelFactoryController implements IModelFactoryService {
    @Override
    public List<UsuarioDto> obtenerUsuarios() {
        return null;
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuario) {
        return false;
    }

    @Override
    public boolean eliminarUsuario(int id) {
        return false;
    }

    @Override
    public boolean actualizarUsuario(int id, UsuarioDto usuario) {
        return false;
    }
}
