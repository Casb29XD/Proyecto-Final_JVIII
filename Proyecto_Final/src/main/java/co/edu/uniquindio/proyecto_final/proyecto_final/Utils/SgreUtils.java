package co.edu.uniquindio.proyecto_final.proyecto_final.Utils;

import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Empleado;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Sgre;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Usuario;

import java.util.ArrayList;

public class SgreUtils {

    public static Sgre inicializarDatos(){
        Sgre sgre = new Sgre();
        Empleado empleado = new Empleado();
        empleado.setId("34892");
        empleado.setNombre("Juan Pérez");
        empleado.setCorreo("juan.perez@Gmail.com");
        empleado.setEvento(new ArrayList<>());
        sgre.getEmpleados().add(empleado);

        empleado = new Empleado();
        empleado.setId("10273");
        empleado.setNombre("Ana García");
        empleado.setCorreo("ana.garcia85@gmail.com");
        empleado.setEvento(new ArrayList<>());
        sgre.getEmpleados().add(empleado);

        empleado = new Empleado();
        empleado.setId("45781");
        empleado.setNombre("Javier Martínez");
        empleado.setCorreo(" javier.martinez92@gmail.com");
        empleado.setEvento(new ArrayList<>());
        sgre.getEmpleados().add(empleado);

        empleado = new Empleado();
        empleado.setId("30894");
        empleado.setNombre("María Rodríguez");
        empleado.setCorreo("m.rodriguez78@gmail.com");
        empleado.setEvento(new ArrayList<>());
        sgre.getEmpleados().add(empleado);

        empleado = new Empleado();
        empleado.setId("81537");
        empleado.setNombre("Pablo López");
        empleado.setCorreo("pablo.lopez89@gmail.com");
        empleado.setEvento(new ArrayList<>());
        sgre.getEmpleados().add(empleado);

        return sgre;
    }
    public static Sgre InicializarDatosUsuario() {
        Sgre sgre = new Sgre();
        Usuario usuario = new Usuario();
        usuario.setId("34892");
        usuario.setNombre("Juan Pérez");
        usuario.setCorreo("juan.perez@Gmail.com");
        usuario.setReserva(new ArrayList<>());
        sgre.getUsuarios().add(usuario);

        usuario = new Usuario();
        usuario.setId("10273");
        usuario.setNombre("Ana García");
        usuario.setCorreo("ana.garcia85@gmail.com");
        usuario.setReserva(new ArrayList<>());
        sgre.getUsuarios().add(usuario);

        usuario = new Usuario();
        usuario.setId("45781");
        usuario.setNombre("Javier Martínez");
        usuario.setCorreo(" javier.martinez92@gmail.com");
        usuario.setReserva(new ArrayList<>());
        sgre.getUsuarios().add(usuario);

        usuario = new Usuario();
        usuario.setId("30894");
        usuario.setNombre("María Rodríguez");
        usuario.setCorreo("m.rodriguez78@gmail.com");
        usuario.setReserva(new ArrayList<>());
        sgre.getUsuarios().add(usuario);

        usuario = new Usuario();
        usuario.setId("81537");
        usuario.setNombre("Pablo López");
        usuario.setCorreo("pablo.lopez89@gmail.com");
        usuario.setReserva(new ArrayList<>());
        sgre.getUsuarios().add(usuario);
        return sgre;
    }
}
