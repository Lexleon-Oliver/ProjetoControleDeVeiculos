package com.orangetalents.cadastrodeveiculos.service;

import com.orangetalents.cadastrodeveiculos.dto.request.UsuarioDTO;
import com.orangetalents.cadastrodeveiculos.dto.response.MessageResponseDTO;
import com.orangetalents.cadastrodeveiculos.entity.Usuario;
import com.orangetalents.cadastrodeveiculos.exception.UsuarioNaoEncontradoException;
import com.orangetalents.cadastrodeveiculos.mapper.UsuarioMapper;
import com.orangetalents.cadastrodeveiculos.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioServiceImpl implements UsuarioService{
    
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;

    
    @Override
    public MessageResponseDTO criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuarioParaSalvar = usuarioMapper.toModel(usuarioDTO);
        Usuario usuarioSalvo = usuarioRepository.save(usuarioParaSalvar);
        return messageResponseCriada(usuarioSalvo.getId(),"Criado usuário com id ");
    }

    @Override
    public UsuarioDTO listarPorId(Long id) {
        Usuario usuario= verificarSeExiste(id);
        return usuarioMapper.toDTO(usuario);
    }

    private MessageResponseDTO messageResponseCriada(Long id, String mensagem) {
        return MessageResponseDTO
                .builder()
                .mensagem(mensagem + id)
                .build();
    }

    private Usuario verificarSeExiste(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(UsuarioNaoEncontradoException::new);
    }
}
