package co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto;

import java.util.List;

public record UsuarioDto() {
    static int id;
    static String nombre;
    static String Correo;
    static List<ReservaDto> reservaDtoList;
}
