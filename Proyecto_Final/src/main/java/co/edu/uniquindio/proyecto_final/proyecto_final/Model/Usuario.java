package co.edu.uniquindio.proyecto_final.proyecto_final.Model;

import java.util.ArrayList;

public class Usuario extends Persona{
    ArrayList<Evento> evento;

    public ArrayList<Evento> getEvento() {
        return evento;
    }

    public void setEvento(ArrayList<Evento> evento) {
        this.evento = evento;
    }
}
