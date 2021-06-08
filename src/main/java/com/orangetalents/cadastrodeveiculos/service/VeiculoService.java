package com.orangetalents.cadastrodeveiculos.service;

import com.orangetalents.cadastrodeveiculos.dto.request.VeiculoDTO;
import com.orangetalents.cadastrodeveiculos.dto.response.MessageResponseDTO;

public interface VeiculoService {
    MessageResponseDTO criarVeiculo(VeiculoDTO veiculoDTO);

}
