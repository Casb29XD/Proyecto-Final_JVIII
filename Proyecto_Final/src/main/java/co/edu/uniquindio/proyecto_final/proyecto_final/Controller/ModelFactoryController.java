package co.edu.uniquindio.proyecto_final.proyecto_final.Controller;

import co.edu.uniquindio.proyecto_final.proyecto_final.Controller.Service.IModelFactoryService;
import co.edu.uniquindio.proyecto_final.proyecto_final.Exceptions.EmpleadoException;
import co.edu.uniquindio.proyecto_final.proyecto_final.Exceptions.UsuarioException;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.EmpleadoDto;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.UsuarioDto;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Mappers.SgreMapper;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Empleado;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Sgre;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Usuario;
import co.edu.uniquindio.proyecto_final.proyecto_final.Utils.SgreUtils;

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
        sgre = SgreUtils.InicializarDatos();
    }

    public Sgre getSgre() {
        return sgre;
    }

    public void setSgre(Sgre sgre) {
        this.sgre = sgre;
    }

    @Override
    public List<EmpleadoDto> obtenerEmpleados() {
        return mapper.getEmpleadoDtos(sgre.getEmpleados());
    }

    @Override
    public boolean agregarEmpleados(EmpleadoDto empleadoDto) {
        try {
            if (!sgre.verificarUsuario(empleadoDto.id())){
                Empleado empleado= mapper.empleadoDtoFtoToempleado(empleadoDto);
                getSgre().agregarEmpleado(empleado);
            }
            return true;
        }catch (UsuarioException e){
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
            Empleado empleado = mapper.empleadoDtoFtoToempleado(empleadoDto);
            getSgre().actualizarEmpleado(id,empleado);
            return true;
        } catch (EmpleadoException e) {
            e.printStackTrace();
            return false;
        }
    }
}
