package co.edu.uniquindio.proyecto_final.proyecto_final.utils;

import co.edu.uniquindio.proyecto_final.proyecto_final.model.Empleado;
import co.edu.uniquindio.proyecto_final.proyecto_final.model.Sgre;

import java.util.ArrayList;

public class SgreUtils {

    public static Sgre InicializarDatosEmpleados(){
        Sgre sgre = new Sgre();
        Empleado empleado = new Empleado();
        empleado.setNombre("Juan Pérez");
        empleado.setId("34892");
        empleado.setCorreo("juan.perez@Gmail.com");
        empleado.setEvento(new ArrayList<>());
        sgre.getEmpleados().add(empleado);

        empleado = new Empleado();
        empleado.setNombre("Ana García");
        empleado.setId("10273");
        empleado.setCorreo("ana.garcia85@gmail.com");
        empleado.setEvento(new ArrayList<>());
        sgre.getEmpleados().add(empleado);

        empleado = new Empleado();
        empleado.setNombre("Javier Martínez");
        empleado.setId("45781");
        empleado.setCorreo(" javier.martinez92@gmail.com");
        empleado.setEvento(new ArrayList<>());
        sgre.getEmpleados().add(empleado);

        empleado = new Empleado();
        empleado.setNombre("María Rodríguez");
        empleado.setId("30894");
        empleado.setCorreo("m.rodriguez78@gmail.com");
        empleado.setEvento(new ArrayList<>());
        sgre.getEmpleados().add(empleado);

        empleado = new Empleado();
        empleado.setNombre("Pablo López");
        empleado.setId("81537");
        empleado.setCorreo("pablo.lopez89@gmail.com");
        empleado.setEvento(new ArrayList<>());
        sgre.getEmpleados().add(empleado);

        return sgre;
    }
    public static Sgre InicializarDatosUsuarios() {
        Sgre sgre = new Sgre();
        return sgre;
    }
}
