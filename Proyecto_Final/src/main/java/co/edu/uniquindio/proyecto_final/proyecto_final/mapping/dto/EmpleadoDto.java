package co.edu.uniquindio.proyecto_final.proyecto_final.mapping.dto;

import java.util.List;

public record EmpleadoDto(
        String id,
    String nombre,
    String correo,
    List<EventoDto> eventoDtoList
) {}
