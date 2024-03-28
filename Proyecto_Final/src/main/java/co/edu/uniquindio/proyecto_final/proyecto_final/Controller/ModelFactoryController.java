package co.edu.uniquindio.proyecto_final.proyecto_final.Controller;

import co.edu.uniquindio.proyecto_final.proyecto_final.Controller.Service.IModelFactoryService;
import co.edu.uniquindio.proyecto_final.proyecto_final.Exceptions.UsuarioException;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.UsuarioDto;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Mappers.SgreMapper;
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
    public List<UsuarioDto> obtenerUsuarios() {
        return mapper.getUsuarioDto(sgre.getUsuarios());
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        try {
            if (!sgre.verificarUsuario(usuarioDto.id())){
                Usuario usuario= mapper.usuarioDtoFtoToUsuario(usuarioDto);
                getSgre().agregarUsuario(usuario);
            }
            return true;
        }catch (UsuarioException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarUsuario(String id) {
        boolean flagExiste = false;
        try {
            flagExiste = getSgre().eliminarUsuario(id);
        } catch (UsuarioException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }
    @Override
    public boolean actualizarUsuario(String id, UsuarioDto usuarioDto) {
        try {
            Usuario usuario = mapper.usuarioDtoFtoToUsuario(usuarioDto);
            getSgre().actualizarUsuario(id,usuario);
            return true;
        } catch (UsuarioException e) {
            e.printStackTrace();
            return false;
        }
    }
}
