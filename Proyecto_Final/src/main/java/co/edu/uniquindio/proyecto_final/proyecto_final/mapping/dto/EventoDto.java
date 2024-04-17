package co.edu.uniquindio.proyecto_final.proyecto_final.mapping.dto;

import co.edu.uniquindio.proyecto_final.proyecto_final.model.Empleado;

import java.util.Date;
import java.util.List;

public record EventoDto(String id,
    String nombre,
    String descripcion,
    Date fecha,
    int capacidadMaxima,
    Empleado empleado,
    List<ReservaDto> reservaDtoList
) {}
