package co.edu.uniquindio.proyecto_final.proyecto_final.controller;

import co.edu.uniquindio.proyecto_final.proyecto_final.controller.service.IUsuarioControllerService;
import co.edu.uniquindio.proyecto_final.proyecto_final.mapping.dto.UsuarioDto;

import java.util.List;

public class UsuarioController implements IUsuarioControllerService {
    @Override
    public List<UsuarioDto> obtenerUsuarios() {
        return null;
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuario) {
        return false;
    }

    @Override
    public boolean eliminarUsuario(String id) {
        return false;
    }

    @Override
    public boolean actualizarUsuario(String id, UsuarioDto usuario) {
        return false;
    }
}
