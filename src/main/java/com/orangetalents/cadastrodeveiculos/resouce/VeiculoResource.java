package com.orangetalents.cadastrodeveiculos.resouce;

import com.orangetalents.cadastrodeveiculos.dto.request.VeiculoDTO;
import com.orangetalents.cadastrodeveiculos.dto.response.MessageResponseDTO;
import com.orangetalents.cadastrodeveiculos.exception.AnoNaoEncontradoException;
import com.orangetalents.cadastrodeveiculos.exception.MarcaNaoEncontradaException;
import com.orangetalents.cadastrodeveiculos.exception.ModeloNaoEncontradoException;
import com.orangetalents.cadastrodeveiculos.service.VeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/v1/veiculos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VeiculoResource {

    private VeiculoService veiculoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO criarVeiculo(@RequestBody @Valid VeiculoDTO veiculoDTO){
        return veiculoService.criarVeiculo(veiculoDTO);

    }

}
