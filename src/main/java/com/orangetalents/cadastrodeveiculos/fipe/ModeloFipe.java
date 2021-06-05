package com.orangetalents.cadastrodeveiculos.fipe;

import lombok.Data;

import java.util.List;

@Data
public class ModeloFipe {

    private List<Modelo> modelos;
    private List<AnoFipe> anos;

}
