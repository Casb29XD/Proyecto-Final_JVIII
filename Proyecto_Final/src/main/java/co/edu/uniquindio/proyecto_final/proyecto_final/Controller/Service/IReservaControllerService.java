package co.edu.uniquindio.proyecto_final.proyecto_final.Controller.Service;

import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.ReservaDto;

import java.util.List;

public interface IReservaControllerService {
    List<ReservaDto> obtenerReserva();
    boolean agregarEvento(ReservaDto reserva);
    boolean eliminarUsuario(int id);
    boolean actualizarUsuario(int id, ReservaDto reserva);
}
