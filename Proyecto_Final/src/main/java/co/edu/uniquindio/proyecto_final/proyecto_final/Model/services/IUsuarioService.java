package co.edu.uniquindio.proyecto_final.proyecto_final.Model.services;

import co.edu.uniquindio.proyecto_final.proyecto_final.Exceptions.UsuarioException;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Empleado;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Reserva;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Usuario;

import java.util.ArrayList;

public interface IUsuarioService {
    public Usuario crearUsuario(int id, String nombre, String correo, ArrayList<Reserva> reserva)throws UsuarioException;
    public boolean eliminarUsuario(int id)throws UsuarioException;
    public boolean actualizarUsuario(int id, Empleado empleado)throws UsuarioException;
    public boolean verificarUsuario(int id)throws UsuarioException;
    public Usuario obtenerUsuario(int id)throws UsuarioException;
    public ArrayList<Usuario> obtenerUsuarios();
}
