package co.edu.uniquindio.proyecto_final.proyecto_final.controller.service;

import co.edu.uniquindio.proyecto_final.proyecto_final.mapping.dto.ReservaDto;

import java.util.List;

public interface IReservaControllerService {
    List<ReservaDto> obtenerReserva();
    boolean agregarEvento(ReservaDto reserva);
    boolean eliminarUsuario(String id);
    boolean actualizarUsuario(String id, ReservaDto reserva);
}
