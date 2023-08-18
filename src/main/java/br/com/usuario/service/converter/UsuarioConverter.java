package br.com.usuario.service.converter;

import br.com.usuario.service.dto.UsuarioDTO;
import br.com.usuario.service.entity.UsuarioEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.util.List;

@Configuration
public class UsuarioConverter {
    public static ModelMapper getMapper() {
        return new ModelMapper();
    }

    public static UsuarioDTO entityToDTO(UsuarioEntity entity){
        return UsuarioConverter.getMapper().map(entity,UsuarioDTO.class);
    }

    public static UsuarioEntity dtoToEntity(UsuarioDTO dto){
        return UsuarioConverter.getMapper().map(dto,UsuarioEntity.class);
    }

    public static List<UsuarioDTO> dtoList(List<UsuarioEntity> usuarios){
        Type listType = new TypeToken<List<UsuarioDTO>>(){}.getType();
        return UsuarioConverter.getMapper().map(usuarios,listType);
    }

}
