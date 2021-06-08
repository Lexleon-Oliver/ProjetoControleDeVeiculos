package com.orangetalents.cadastrodeveiculos.service;

import com.orangetalents.cadastrodeveiculos.dto.request.VeiculoDTO;
import com.orangetalents.cadastrodeveiculos.dto.response.MessageResponseDTO;
import com.orangetalents.cadastrodeveiculos.entity.Veiculo;
import com.orangetalents.cadastrodeveiculos.exception.AnoNaoEncontradoException;
import com.orangetalents.cadastrodeveiculos.exception.MarcaNaoEncontradaException;
import com.orangetalents.cadastrodeveiculos.exception.ModeloNaoEncontradoException;
import com.orangetalents.cadastrodeveiculos.fipe.*;
import com.orangetalents.cadastrodeveiculos.mapper.VeiculoMapper;
import com.orangetalents.cadastrodeveiculos.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VeiculoServiceImpl implements VeiculoService{

    private final VeiculoRepository veiculoRepository;
    private final VeiculoMapper veiculoMapper = VeiculoMapper.INSTANCE;
    private final FipeClient fipeClient;
    private UsuarioService usuarioService;

    @Override
    public MessageResponseDTO criarVeiculo(VeiculoDTO veiculoDTO) {
        String tipo = veiculoDTO.getTipo();
        List<MarcaFipe> marcaFipeList = fipeClient.listarMarcas(tipo);
        MarcaFipe marca= marcaFipeList.stream()
                .filter(marcaFipe -> marcaFipe.getNome().equalsIgnoreCase(veiculoDTO.getMarca()))
                .findFirst()
                .orElseThrow(MarcaNaoEncontradaException::new);

        String idMarca = marca.getCodigo();
        ModeloFipe modeloFipe = fipeClient.listarModelos(tipo, idMarca);
        Modelo modelo =modeloFipe.getModelos().stream()
                .filter(modelo1 -> modelo1.getNome().equalsIgnoreCase(veiculoDTO.getModelo()))
                .findFirst()
                .orElseThrow(ModeloNaoEncontradoException::new);

        Integer idModelo =modelo.getCodigo();
        List<AnoFipe> anoFipeList = fipeClient.listarAnos(tipo,idMarca,idModelo);
        AnoFipe ano = anoFipeList.stream()
                .filter(anoFipe -> anoFipe.getNome().equalsIgnoreCase(veiculoDTO.getAno()))
                .findFirst()
                .orElseThrow(AnoNaoEncontradoException::new);

        String idAno = ano.getCodigo();
        ValorFipe valorFipe = fipeClient.listarVeiculo(tipo,idMarca,idModelo,idAno);
        veiculoDTO.setValor(valorFipe.getValor());
        veiculoDTO.setRodizioAtivo(setarDiaRodizio(veiculoDTO));
        usuarioService.listarPorId(veiculoDTO.getUsuario());
        Veiculo veiculoParaSalvar = veiculoMapper.toModel(veiculoDTO);
        Veiculo veiculoSalvo = veiculoRepository.save(veiculoParaSalvar);
        return messageResponseCriada(veiculoSalvo.getId(),"Criado veículo com id ");
    }


    private Boolean setarDiaRodizio(VeiculoDTO veiculoDTO) {
        Integer ultimoDigito =Integer.parseInt(veiculoDTO.getAno().substring(3,4));
        if (ultimoDigito == 0 || ultimoDigito == 1) {
            veiculoDTO.setDiaRodizio("segunda-feira");
        } else if (ultimoDigito == 2 || ultimoDigito == 3){
            veiculoDTO.setDiaRodizio("terça-feira");
        } else if (ultimoDigito == 4 || ultimoDigito == 5){
            veiculoDTO.setDiaRodizio("quarta-feira");
        } else if (ultimoDigito == 6 || ultimoDigito == 7){
            veiculoDTO.setDiaRodizio("quinta-feira");
        } else {
            veiculoDTO.setDiaRodizio("sexta-feira");
        }
        String hoje = new DateFormatSymbols().getWeekdays()[Calendar.getInstance().get(Calendar.DAY_OF_WEEK)];
        if(veiculoDTO.getDiaRodizio().equals(hoje)){
            return true;
        }
        return false;

    }

    private MessageResponseDTO messageResponseCriada(Long id, String mensagem) {
        return MessageResponseDTO
                .builder()
                .mensagem(mensagem + id)
                .build();
    }

}
