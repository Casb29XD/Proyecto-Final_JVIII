package co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto;

import java.util.List;

public record EmpleadoDto(
    int id,
    String nombre,
    String correo,
    List<EventoDto> eventoDtoList
) {}
