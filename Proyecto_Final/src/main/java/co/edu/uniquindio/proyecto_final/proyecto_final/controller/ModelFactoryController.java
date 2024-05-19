package co.edu.uniquindio.proyecto_final.proyecto_final.controller;

import co.edu.uniquindio.proyecto_final.proyecto_final.controller.service.IEmpleadoControllerService;
import co.edu.uniquindio.proyecto_final.proyecto_final.controller.service.IModelFactoryService;
import co.edu.uniquindio.proyecto_final.proyecto_final.controller.service.IReservaControllerService;
import co.edu.uniquindio.proyecto_final.proyecto_final.controller.service.IUsuarioControllerService;
import co.edu.uniquindio.proyecto_final.proyecto_final.exceptions.EmpleadoException;
import co.edu.uniquindio.proyecto_final.proyecto_final.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.proyecto_final.proyecto_final.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyecto_final.proyecto_final.mapping.mappers.SgreMapper;
import co.edu.uniquindio.proyecto_final.proyecto_final.model.Empleado;
import co.edu.uniquindio.proyecto_final.proyecto_final.model.Sgre;
import co.edu.uniquindio.proyecto_final.proyecto_final.utils.ArchivoUtil;
import co.edu.uniquindio.proyecto_final.proyecto_final.utils.Persistencia;
import co.edu.uniquindio.proyecto_final.proyecto_final.utils.SgreUtils;

import java.io.IOException;
import java.util.List;

import static co.edu.uniquindio.proyecto_final.proyecto_final.utils.Persistencia.RUTA_ARCHIVO_EMPLEADOS;

public class ModelFactoryController implements IModelFactoryService, IUsuarioControllerService {
    Sgre sgre;
    SgreMapper mapper = SgreMapper.INSTANCE;


    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        System.out.println("invocación clase singleton");

        //cargarDatosBase();
        //salvarDatosPrueba();

        //2. Cargar los datos de los archivos
		cargarDatosDesdeArchivos();

        //3. Guardar y Cargar el recurso serializable binario

		//cargarResourceBinario();
		//guardarResourceBinario();

        //4. Guardar y Cargar el recurso serializable XML
		guardarResourceXML();
        cargarResourceXML();

        //Siempre se debe verificar si la raiz del recurso es null

        if(sgre == null){

            cargarDatosBase();
            guardarResourceXML();
            cargarDatosDesdeArchivos();
            cargarResourceXML();
        }
        registrarAccionesSistema("Inicio de sesión", 1, "inicioSesión");


    }

    private void cargarDatosDesdeArchivos() {
        sgre = new Sgre();
        try {
            Persistencia.cargarDatosArchivos(sgre);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void salvarDatosPrueba() {
        try {
            Persistencia.guardarEmpleados(getSgre().getEmpleados());
            //Persistencia.guardarClientes(getSgre().getUsuarios());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

//empleado
    @Override
    public List<EmpleadoDto> obtenerEmpleados() {
        return  mapper.getEmpleadosDto(sgre.getEmpleados());
    }

    @Override
    public boolean agregarEmpleado(EmpleadoDto empleadoDto) {
        try {
            Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
            getSgre().agregarEmpleado(empleado);
            Persistencia.guardarEmpleados(getSgre().getEmpleados());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminarEmpleado(String id) {
        try {
            boolean flagExiste = getSgre().eliminarEmpleado(id);
            if (flagExiste) {
                Persistencia.guardarEmpleados(getSgre().getEmpleados());
                guardarResourceXML();
            }
            return flagExiste;
        } catch (IOException | EmpleadoException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizarEmpleado(String id, EmpleadoDto empleadoDto) {
        try {
            Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
            boolean resultado = getSgre().actualizarEmpleado(id, empleado);
            if (resultado) {
                Persistencia.guardarEmpleados(getSgre().getEmpleados());
                guardarResourceXML();
            }
            return resultado;
        } catch (IOException | EmpleadoException e) {
            e.printStackTrace();
            return false;
        }
    }

//usuario
    @Override
    public List<UsuarioDto> obtenerUsuarios() {
        return List.of();
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuario) {
        return false;
    }

    @Override
    public boolean eliminarUsuario(String id) {
        return false;
    }

    @Override
    public boolean actualizarUsuario(String id, UsuarioDto usuario) {
        return false;
    }

//Evento


    private void cargarResourceXML() {
        sgre = Persistencia.cargarRecursosSgreXML();
    }

    private void guardarResourceXML() {
        Persistencia.guardarRecursoSgreXML(sgre);
    }

    private void cargarResourceBinario() {
        sgre = Persistencia.cargarRecursoSgreBinario();
    }

    private void guardarResourceBinario() {
        Persistencia.guardarRecursoSgreBinario(sgre);
    }

    public void registrarAccionesSistema(String mensaje, int nivel, String accion) {
        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }
}
