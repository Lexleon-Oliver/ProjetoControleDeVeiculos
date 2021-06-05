package com.orangetalents.cadastrodeveiculos.mapper;

import com.orangetalents.cadastrodeveiculos.dto.request.UsuarioDTO;
import com.orangetalents.cadastrodeveiculos.entity.Usuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-04T10:58:51-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.0.2.jar, environment: Java 15.0.2 (Amazon.com Inc.)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    private final VeiculoMapper veiculoMapper = Mappers.getMapper( VeiculoMapper.class );

    @Override
    public Usuario toModel(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        if ( usuarioDTO.getDataNascimento() != null ) {
            usuario.setDataNascimento( LocalDate.parse( usuarioDTO.getDataNascimento(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        usuario.setId( usuarioDTO.getId() );
        usuario.setNome( usuarioDTO.getNome() );
        usuario.setEmail( usuarioDTO.getEmail() );
        usuario.setCpf( usuarioDTO.getCpf() );
        usuario.setVeiculos( veiculoMapper.toModel( usuarioDTO.getVeiculos() ) );

        return usuario;
    }

    @Override
    public UsuarioDTO toDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( usuario.getId() );
        usuarioDTO.setNome( usuario.getNome() );
        usuarioDTO.setEmail( usuario.getEmail() );
        usuarioDTO.setCpf( usuario.getCpf() );
        if ( usuario.getDataNascimento() != null ) {
            usuarioDTO.setDataNascimento( DateTimeFormatter.ISO_LOCAL_DATE.format( usuario.getDataNascimento() ) );
        }
        usuarioDTO.setVeiculos( veiculoMapper.toDTO( usuario.getVeiculos() ) );

        return usuarioDTO;
    }
}
