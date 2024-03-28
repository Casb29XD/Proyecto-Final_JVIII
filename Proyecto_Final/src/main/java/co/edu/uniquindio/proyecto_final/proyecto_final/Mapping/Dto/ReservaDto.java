package co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto;

import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Evento;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Usuario;

import java.util.Date;

public record ReservaDto(
        String id,
    Usuario usuario,
    Evento evento,
    Date fechaSolicitud,
    String estado
) {}
