package co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto;

import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Empleado;

import java.util.Date;
import java.util.List;

public record EventoDto() {
    static int id;
    static String nombre;
    static String descripcion;
    static Date fecha;
    static int capacidadMaxima;
    static Empleado empleado;
    static List<ReservaDto> reservaDtoList;
}
