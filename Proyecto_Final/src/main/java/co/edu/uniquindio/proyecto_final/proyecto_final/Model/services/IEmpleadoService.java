package co.edu.uniquindio.proyecto_final.proyecto_final.Model.services;

import co.edu.uniquindio.proyecto_final.proyecto_final.Exceptions.EmpleadoException;
import co.edu.uniquindio.proyecto_final.proyecto_final.Exceptions.UsuarioException;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Empleado;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Reserva;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Usuario;

import java.util.ArrayList;

public interface IEmpleadoService {
    public Usuario crearEmpleado(String id, String nombre, String correo, ArrayList<Reserva> reserva)throws UsuarioException;
    public boolean eliminarEmpleado(String id)throws EmpleadoException;
    public boolean actualizarEmpleado(String id, Empleado empleado)throws EmpleadoException;
    public boolean verificarEmpleado(String id)throws EmpleadoException;
    public Usuario obtenerEmpleado(String id)throws EmpleadoException;
    public ArrayList<Empleado> obtenerEmpleado();
}
