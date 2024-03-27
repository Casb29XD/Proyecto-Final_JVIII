package co.edu.uniquindio.proyecto_final.proyecto_final.Model;

import java.util.ArrayList;

public class Usuario extends Persona{
    ArrayList<Reserva> reserva;

    public ArrayList<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(ArrayList<Reserva> reserva) {
        this.reserva = reserva;
    }
}
