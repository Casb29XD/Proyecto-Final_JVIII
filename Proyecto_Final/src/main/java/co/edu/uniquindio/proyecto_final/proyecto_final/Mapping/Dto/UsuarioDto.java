package co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto;

import java.util.List;

public record UsuarioDto(
    String id,
    String nombre,
    String correo,
    List<ReservaDto> reservaDtoList){
}
