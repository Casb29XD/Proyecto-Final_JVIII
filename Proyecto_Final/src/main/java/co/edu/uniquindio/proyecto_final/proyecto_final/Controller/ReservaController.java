package co.edu.uniquindio.proyecto_final.proyecto_final.Controller;

import co.edu.uniquindio.proyecto_final.proyecto_final.Controller.Service.IReservaControllerService;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.ReservaDto;

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
    public boolean eliminarUsuario(int id) {
        return false;
    }

    @Override
    public boolean actualizarUsuario(int id, ReservaDto reserva) {
        return false;
    }
}
