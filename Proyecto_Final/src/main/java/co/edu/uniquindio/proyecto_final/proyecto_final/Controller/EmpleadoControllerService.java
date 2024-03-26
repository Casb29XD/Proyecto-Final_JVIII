package co.edu.uniquindio.proyecto_final.proyecto_final.Controller;

import co.edu.uniquindio.proyecto_final.proyecto_final.Controller.Service.IEmpleadoControllerService;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.EmpleadoDto;

import java.util.List;

public class EmpleadoControllerService implements IEmpleadoControllerService {
    @Override
    public List<EmpleadoDto> obtenerEmpleados() {
        return null;
    }

    @Override
    public boolean agregarEmpleado(EmpleadoDto empleado) {
        return false;
    }

    @Override
    public boolean eliminarEmpleado(int id) {
        return false;
    }

    @Override
    public boolean actualizarEmpleado(int id, EmpleadoDto empleado) {
        return false;
    }
}
