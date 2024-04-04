package co.edu.uniquindio.proyecto_final.proyecto_final.mapping.mappers;
import co.edu.uniquindio.proyecto_final.proyecto_final.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.proyecto_final.proyecto_final.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyecto_final.proyecto_final.model.Empleado;
import co.edu.uniquindio.proyecto_final.proyecto_final.model.Usuario;
import org.mapstruct.IterableMapping;
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

    Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto);

    @IterableMapping(qualifiedByName = "empleadoToEmpleadoDto")
    List<EmpleadoDto> getEmpleadosDto(List<Empleado> listaEmpleados);
}
