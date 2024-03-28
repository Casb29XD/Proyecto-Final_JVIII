package co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto;

import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Empleado;

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
