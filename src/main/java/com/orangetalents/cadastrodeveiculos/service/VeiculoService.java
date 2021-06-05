package com.orangetalents.cadastrodeveiculos.service;

import com.orangetalents.cadastrodeveiculos.dto.request.VeiculoDTO;
import com.orangetalents.cadastrodeveiculos.dto.response.MessageResponseDTO;
import com.orangetalents.cadastrodeveiculos.exception.AnoNaoEncontradoException;
import com.orangetalents.cadastrodeveiculos.exception.MarcaNaoEncontradaException;
import com.orangetalents.cadastrodeveiculos.exception.ModeloNaoEncontradoException;

public interface VeiculoService {
    MessageResponseDTO criarVeiculo(VeiculoDTO veiculoDTO) throws AnoNaoEncontradoException, ModeloNaoEncontradoException, MarcaNaoEncontradaException;

}
