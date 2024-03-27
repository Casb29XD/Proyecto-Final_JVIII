package co.edu.uniquindio.proyecto_final.proyecto_final.Model;

import co.edu.uniquindio.proyecto_final.proyecto_final.Exceptions.UsuarioException;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.services.IUsuarioService;

import java.util.ArrayList;

public class Sgre implements IUsuarioService {

    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Empleado> empleados = new ArrayList<>();
    ArrayList<Evento> eventos = new ArrayList<>();
    ArrayList<Reserva> reservas = new ArrayList<>();

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
//crud de usuarios
    @Override
    public Usuario crearUsuario(int id, String nombre, String correo, ArrayList<Reserva> reserva) throws UsuarioException {
        Usuario nuevoUsuario= null;
        boolean usuarioExistente= verificarUsuario(id);
        if (usuarioExistente){
            throw new UsuarioException("El usuario con Id: "+id+" ya se encuentra registrado");
        }else {
            nuevoUsuario = new Usuario();
            nuevoUsuario.setId(id);
            nuevoUsuario.setNombre(nombre);
            nuevoUsuario.setCorreo(correo);
            nuevoUsuario.setReserva(reserva);
            getUsuarios().add(nuevoUsuario);
        }
        return nuevoUsuario;
    }
    public void agregarUsuario(Usuario usuario) throws UsuarioException{
        getUsuarios().add(usuario);
    }
    @Override
    public boolean eliminarUsuario(int id) throws UsuarioException {
         Usuario usuario= null;
         boolean existe=false;
         usuario= obtenerUsuario(id);
         if (usuario == null){
                throw new UsuarioException("El usuario no se encuentra registrado");
         }else {
                getUsuarios().remove(usuario);
                existe=true;
         }
         return existe;
    }

    @Override
    public boolean actualizarUsuario(int id, Usuario usuario) throws UsuarioException {
        Usuario usuarioactual = obtenerUsuario(id);
        if (usuarioactual == null){
            throw new UsuarioException("Ese usuario no existe");
        }else {
            usuarioactual.setNombre(usuario.getNombre());
            usuarioactual.setCorreo(usuario.getCorreo());
            usuarioactual.setReserva(usuario.getReserva());
            return true;
        }
    }

    @Override
    public boolean verificarUsuario(int id) throws UsuarioException {
        if (usuarioExiste(id)){
            throw new UsuarioException("El usuario con id: " +id+" ya se encuentra registrado");
        }else {
            return false;
        }
    }

    private boolean usuarioExiste(int id) {
        boolean usuarioEncontrado=false;
        for (Usuario usuario: getUsuarios()){
            if (usuario.getId()== id){
                usuarioEncontrado = true;
                break;
            }
        }
        return usuarioEncontrado;
    }

    @Override
    public Usuario obtenerUsuario(int id) throws UsuarioException {
        Usuario usuarioEncontrado= null;
        for (Usuario usuario: getUsuarios()){
            if (usuario.getId()== id){
                usuarioEncontrado = usuario;
                break;
            }
        }
        return usuarioEncontrado;
    }

    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        return getUsuarios();
    }
}
