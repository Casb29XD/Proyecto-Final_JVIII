package co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Mappers;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.EmpleadoDto;
import co.edu.uniquindio.proyecto_final.proyecto_final.Mapping.Dto.UsuarioDto;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Empleado;
import co.edu.uniquindio.proyecto_final.proyecto_final.Model.Usuario;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface SgreMapper {
    SgreMapper INSTANCE =Mappers.getMapper(SgreMapper.class);

    @Named("usuarioToUsuarioDto")
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
    Usuario usuarioDtoFtoToUsuario(UsuarioDto usuarioDto);
    @IterableMapping(qualifiedByName = "usuarioToUsuarioDto")
    List<UsuarioDto> getUsuarioDto(List<Usuario> Usuarios);

    //Mapper de los empleados
    @Named("empleadoToEmpleadoDto")
    EmpleadoDto empleadoToEmpleadoDto(Empleado empleado);
    Empleado empleadoDtoFtoToempleado(EmpleadoDto empleadoDto);
    @IterableMapping(qualifiedByName = "empleadoToEmpleadoDto")
    List<EmpleadoDto> getEmpleadoDtos(List<Empleado> empleado);
}
