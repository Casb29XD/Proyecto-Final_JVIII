package co.edu.uniquindio.proyecto_final.proyecto_final.Controller.Service;

import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.EventoDto;

import java.util.List;

public interface IEventoControllerService {
    List<EventoDto> obtenerEvento();
    boolean agregarEvento(EventoDto evento);
    boolean eliminarUsuario(int id);
    boolean actualizarUsuario(int id, EventoDto evento);
}
