package co.edu.uniquindio.proyecto_final.proyecto_final.Model;

import co.edu.uniquindio.proyecto_final.proyecto_final.Controller.Service.IEmpleadoControllerService;
import co.edu.uniquindio.proyecto_final.proyecto_final.Exceptions.EmpleadoException;
import co.edu.uniquindio.proyecto_final.proyecto_final.Exceptions.UsuarioException;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.EmpleadoDto;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.services.IEmpleadoService;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.services.IUsuarioService;

import java.util.ArrayList;
import java.util.List;

public class Sgre implements IEmpleadoService,IUsuarioService {

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

    @Override
    public Empleado crearEmpleado(String id, String nombre, String correo, ArrayList<Reserva> reserva) throws UsuarioException, EmpleadoException {
        Empleado nuevoEmpleado= null;
        boolean empleadoExistente= verificarEmpleado(id);
        if (empleadoExistente){
            throw new UsuarioException("El usuario con Id: "+id+" ya se encuentra registrado");
        }else {
            nuevoEmpleado = new Empleado();
            nuevoEmpleado.setId(id);
            nuevoEmpleado.setNombre(nombre);
            nuevoEmpleado.setCorreo(correo);
            nuevoEmpleado.setEvento(eventos);
            getEmpleados().add(nuevoEmpleado);
        }
        return nuevoEmpleado;
    }
    public void agregarEmpleado(Empleado empleado) throws UsuarioException{
        getEmpleados().add(empleado);
    }

    @Override
    public boolean eliminarEmpleado(String id) throws EmpleadoException {
        Empleado empleado= null;
        boolean existe=false;
        empleado= obtenerEmpleado(id);
        if (empleado == null){
            throw new EmpleadoException("El Empleado no se encuentra registrado");
        }else {
            getUsuarios().remove(empleado);
            existe=true;
        }
        return existe;
    }

    @Override
    public boolean actualizarEmpleado(String id, Empleado empleado) throws EmpleadoException {
        Empleado empleadoactual = obtenerEmpleado(id);
        if (empleadoactual == null){
            throw new EmpleadoException("Ese Empleado no existe");
        }else {
            empleadoactual.setNombre(empleado.getNombre());
            empleadoactual.setCorreo(empleado.getCorreo());
            empleadoactual.setEvento(empleado.getEvento());
            return true;
        }
    }

    @Override
    public boolean verificarEmpleado(String id) throws EmpleadoException {
        if (empleadoExiste(id)){
            throw new EmpleadoException("El Empleado con id: " +id+" ya se encuentra registrado");
        }else {
            return false;
        }
    }
    private boolean empleadoExiste(String id) {
        boolean empleadoEncontrado=false;
        for (Empleado empleado: getEmpleados()){
            if (empleado.getId().equals(id)){
                empleadoEncontrado = true;
                break;
            }
        }
        return empleadoEncontrado;
    }
    @Override
    public Empleado obtenerEmpleado(String id) throws EmpleadoException {
        Empleado empleadoEncontrado= null;
        for (Empleado empleado: getEmpleados()){
            if (empleado.getId().equals(id)){
                empleadoEncontrado = empleado;
                break;
            }
        }
        return empleadoEncontrado;
    }

    @Override
    public ArrayList<Empleado> obtenerEmpleado() {
        return getEmpleados();
    }


//crud de usuarios
   @Override
    public Usuario crearUsuario(String id, String nombre, String correo, ArrayList<Reserva> reserva) throws UsuarioException {
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
    public boolean eliminarUsuario(String id) throws UsuarioException {
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
    public boolean actualizarUsuario(String id, Usuario usuario) throws UsuarioException {
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
    public boolean verificarUsuario(String id) throws UsuarioException {
        if (usuarioExiste(id)){
            throw new UsuarioException("El usuario con id: " +id+" ya se encuentra registrado");
        }else {
            return false;
        }
    }

    private boolean usuarioExiste(String id) {
        boolean usuarioEncontrado=false;
        for (Usuario usuario: getUsuarios()){
            if (usuario.getId().equals(id)){
                usuarioEncontrado = true;
                break;
            }
        }
        return usuarioEncontrado;
    }

    @Override
    public Usuario obtenerUsuario(String id) throws UsuarioException {
        Usuario usuarioEncontrado= null;
        for (Usuario usuario: getUsuarios()){
            if (usuario.getId().equals(id)){
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
