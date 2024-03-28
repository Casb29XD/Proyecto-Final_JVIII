package co.edu.uniquindio.proyecto_final.proyecto_final.Model.services;

import co.edu.uniquindio.proyecto_final.proyecto_final.Exceptions.UsuarioException;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Reserva;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Usuario;

import java.util.ArrayList;

public interface IUsuarioService {
    public Usuario crearUsuario(String id, String nombre, String correo, ArrayList<Reserva> reserva)throws UsuarioException;
    public boolean eliminarUsuario(String id)throws UsuarioException;
    public boolean actualizarUsuario(String id, Usuario usuario)throws UsuarioException;
    public boolean verificarUsuario(String id)throws UsuarioException;
    public Usuario obtenerUsuario(String id)throws UsuarioException;
    public ArrayList<Usuario> obtenerUsuarios();
}
