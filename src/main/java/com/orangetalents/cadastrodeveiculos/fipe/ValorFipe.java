package com.orangetalents.cadastrodeveiculos.fipe;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ValorFipe {

    @JsonProperty("Valor")
    private String valor;

}
