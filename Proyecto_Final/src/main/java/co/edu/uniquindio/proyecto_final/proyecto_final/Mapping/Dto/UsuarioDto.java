package co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto;

import java.util.List;

public record UsuarioDto(
    int id,
    String nombre,
    String Correo,
    List<ReservaDto> reservaDtoList){
}
