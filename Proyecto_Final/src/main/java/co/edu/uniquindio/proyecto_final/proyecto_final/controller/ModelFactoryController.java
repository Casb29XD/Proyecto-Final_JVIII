package co.edu.uniquindio.proyecto_final.proyecto_final.controller;

import co.edu.uniquindio.proyecto_final.proyecto_final.controller.service.IModelFactoryService;
import co.edu.uniquindio.proyecto_final.proyecto_final.exceptions.EmpleadoException;
import co.edu.uniquindio.proyecto_final.proyecto_final.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.proyecto_final.proyecto_final.mapping.mappers.SgreMapper;
import co.edu.uniquindio.proyecto_final.proyecto_final.model.Empleado;
import co.edu.uniquindio.proyecto_final.proyecto_final.model.Sgre;
import co.edu.uniquindio.proyecto_final.proyecto_final.utils.SgreUtils;

import java.util.List;

public class ModelFactoryController implements IModelFactoryService {
    Sgre sgre;
    SgreMapper mapper = SgreMapper.INSTANCE;

    public static class SingletonHolder{
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        System.out.println("invocación clase singleton");
        cargarDatosBase();
    }

    private void cargarDatosBase() {
        sgre = SgreUtils.inicializarDatos();
    }

    public Sgre getSgre() {
        return sgre;
    }

    public void setSgre(Sgre sgre) {
        this.sgre = sgre;
    }

    @Override
    public List<EmpleadoDto> obtenerEmpleados() {
        return mapper.getEmpleadosDto(sgre.getEmpleados());
    }

    @Override
    public boolean agregarEmpleado(EmpleadoDto empleadoDto) {
        try {
            if (!sgre.verificarEmpleado(empleadoDto.id())){
                Empleado empleado= mapper.empleadoDtoToEmpleado(empleadoDto);
                getSgre().agregarEmpleado(empleado);
            }
            return true;
        }catch (EmpleadoException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarEmpleado(String id) {
        boolean flagExiste = false;
        try {
            flagExiste = getSgre().eliminarEmpleado(id);
        } catch (EmpleadoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }
    @Override
    public boolean actualizarEmpleado(String id, EmpleadoDto empleadoDto) {
        try {
            Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
            getSgre().actualizarEmpleado(id,empleado);
            return true;
        } catch (EmpleadoException e) {
            e.printStackTrace();
            return false;
        }
    }
}
