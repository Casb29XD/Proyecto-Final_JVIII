package co.edu.uniquindio.proyecto_final.proyecto_final.Utils;

import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.EmpleadoDto;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Empleado;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Sgre;

import java.util.ArrayList;

public class SgreUtils {

    public static Sgre InicializarDatos(){
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
}
