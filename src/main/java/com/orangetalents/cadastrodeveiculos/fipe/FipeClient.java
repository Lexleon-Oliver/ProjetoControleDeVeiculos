package com.orangetalents.cadastrodeveiculos.fipe;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "fipe", url = "https://parallelum.com.br/fipe/api/v1")
public interface FipeClient {


    @RequestMapping("/{tipo}/marcas")
    List<MarcaFipe> listarMarcas(@PathVariable String tipo);

    @RequestMapping("/{tipo}/marcas/{idMarca}/modelos")
    ModeloFipe listarModelos(@PathVariable String tipo, @PathVariable String idMarca);

    @GetMapping("/{tipo}/marcas/{idMarca}/modelos/{idModelo}/anos")
    List<AnoFipe> listarAnos(@PathVariable String tipo, @PathVariable String idMarca, @PathVariable Integer idModelo);

    @GetMapping("/{tipo}/marcas/{idMarca}/modelos/{idModelo}/anos/{idAno}")
    ValorFipe listarVeiculo(@PathVariable String tipo, @PathVariable String idMarca, @PathVariable Integer idModelo,
                            @PathVariable String idAno);


}
