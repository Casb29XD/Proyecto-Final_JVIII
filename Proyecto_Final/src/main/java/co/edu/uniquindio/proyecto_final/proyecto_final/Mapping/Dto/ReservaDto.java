package co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto;

import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Evento;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Usuario;

import java.util.Date;

public record ReservaDto() {
    static int id;
    static Usuario usuario;
    static Evento evento;
    static Date fechaSolicitud;
    static String estado;
}
