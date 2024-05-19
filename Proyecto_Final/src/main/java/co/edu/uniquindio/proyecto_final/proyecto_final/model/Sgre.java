package co.edu.uniquindio.proyecto_final.proyecto_final.model;

import co.edu.uniquindio.proyecto_final.proyecto_final.exceptions.EmpleadoException;
import co.edu.uniquindio.proyecto_final.proyecto_final.exceptions.UsuarioException;
import co.edu.uniquindio.proyecto_final.proyecto_final.model.services.IEmpleadoService;
import co.edu.uniquindio.proyecto_final.proyecto_final.model.services.IUsuarioService;

import java.util.ArrayList;
import java.util.List;

public class Sgre implements IEmpleadoService, IUsuarioService {

    private static final long serialVersionUID = 1L;
    List<Usuario> usuarios = new ArrayList<>();
    List<Empleado> empleados = new ArrayList<>();
    List<Evento> eventos = new ArrayList<>();
    List<Reserva> reservas = new ArrayList<>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }


    //empleados
    @Override
    public Empleado crearEmpleado(String id, String nombre, String correo, ArrayList<Reserva> reserva) throws EmpleadoException {
        Empleado nuevoEmpleado= null;
        boolean empleadoExistente= verificarEmpleadoExistente(id);
        if (empleadoExistente){
            throw new EmpleadoException("El usuario con Id: "+id+" ya se encuentra registrado");
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
    public void agregarEmpleado(Empleado empleado){
        getEmpleados().add(empleado);
    }

    @Override
    public Boolean eliminarEmpleado(String id) throws EmpleadoException {
        Empleado empleado= null;
        boolean existe=false;
        empleado = obtenerEmpleado(id);
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
            empleadoactual.setId(empleado.getId());
            empleadoactual.setCorreo(empleado.getCorreo());
            return true;
        }
    }

    @Override
    public boolean verificarEmpleadoExistente(String id) throws EmpleadoException {
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
    public Empleado obtenerEmpleado(String id) {
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
    public ArrayList<Empleado> obtenerEmpleados() {
        return null;
    }

    //usuarios
    public void agregarUsuario(Usuario usuario){
        getUsuarios().add(usuario);
    }

    @Override
    public Usuario crearUsuario(String id, String nombre, String correo, ArrayList<Reserva> reserva) throws UsuarioException {
        return null;
    }

    @Override
    public boolean eliminarUsuario(String id) throws UsuarioException {
        return false;
    }

    @Override
    public boolean actualizarUsuario(String id, Usuario usuario) throws UsuarioException {
        return false;
    }

    @Override
    public boolean verificarUsuario(String id) throws UsuarioException {
        return false;
    }

    @Override
    public Usuario obtenerUsuario(String id) throws UsuarioException {
        return null;
    }

    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        return null;
    }

}
