package co.edu.uniquindio.proyecto_final.proyecto_final.controller;

import co.edu.uniquindio.proyecto_final.proyecto_final.controller.service.IEventoControllerService;
import co.edu.uniquindio.proyecto_final.proyecto_final.mapping.dto.EventoDto;

import java.util.List;

public class EventoController implements IEventoControllerService {
    @Override
    public List<EventoDto> obtenerEvento() {
        return null;
    }

    @Override
    public boolean agregarEvento(EventoDto evento) {
        return false;
    }

    @Override
    public boolean eliminarUsuario(String id) {
        return false;
    }

    @Override
    public boolean actualizarUsuario(String id, EventoDto evento) {
        return false;
    }
}
