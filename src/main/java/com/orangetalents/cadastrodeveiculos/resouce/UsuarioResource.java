package com.orangetalents.cadastrodeveiculos.resouce;

import com.orangetalents.cadastrodeveiculos.dto.request.UsuarioDTO;
import com.orangetalents.cadastrodeveiculos.dto.response.MessageResponseDTO;
import com.orangetalents.cadastrodeveiculos.exception.UsuarioNaoEncontradoException;
import com.orangetalents.cadastrodeveiculos.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/usuarios")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioResource {

    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO criarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
        return usuarioService.criarUsuario(usuarioDTO);
    }


    @GetMapping("/{id}/veiculos")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO ListarPorId (@PathVariable Long id) throws UsuarioNaoEncontradoException {
        return usuarioService.listarPorId(id);
    }


}
