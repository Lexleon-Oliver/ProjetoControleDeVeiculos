package com.orangetalents.cadastrodeveiculos.service;

import com.orangetalents.cadastrodeveiculos.dto.request.UsuarioDTO;
import com.orangetalents.cadastrodeveiculos.dto.response.MessageResponseDTO;
import com.orangetalents.cadastrodeveiculos.exception.UsuarioNaoEncontradoException;

public interface UsuarioService {

    MessageResponseDTO criarUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO listarPorId(Long id) throws UsuarioNaoEncontradoException;
}
