package com.orangetalents.cadastrodeveiculos.mapper;

import com.orangetalents.cadastrodeveiculos.dto.request.UsuarioDTO;
import com.orangetalents.cadastrodeveiculos.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = VeiculoMapper.class)
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd-MM-yyyy")
    Usuario toModel (UsuarioDTO usuarioDTO);

    UsuarioDTO toDTO (Usuario usuario);
}
