package co.edu.uniquindio.proyecto_final.proyecto_final.controller;

import co.edu.uniquindio.proyecto_final.proyecto_final.controller.service.IReservaControllerService;
import co.edu.uniquindio.proyecto_final.proyecto_final.mapping.dto.ReservaDto;

import java.util.List;

public class ReservaController implements IReservaControllerService {
    @Override
    public List<ReservaDto> obtenerReserva() {
        return null;
    }

    @Override
    public boolean agregarEvento(ReservaDto reserva) {
        return false;
    }

    @Override
    public boolean eliminarUsuario(String id) {
        return false;
    }

    @Override
    public boolean actualizarUsuario(String id, ReservaDto reserva) {
        return false;
    }
}
