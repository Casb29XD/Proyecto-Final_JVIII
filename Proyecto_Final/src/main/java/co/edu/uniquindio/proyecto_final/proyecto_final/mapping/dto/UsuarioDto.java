package co.edu.uniquindio.proyecto_final.proyecto_final.mapping.dto;

import java.util.List;

public record UsuarioDto(
    String id,
    String nombre,
    String correo,
    List<ReservaDto> reservaDtoList){
}
