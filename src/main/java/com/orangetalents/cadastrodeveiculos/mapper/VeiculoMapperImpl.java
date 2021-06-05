package com.orangetalents.cadastrodeveiculos.mapper;

import com.orangetalents.cadastrodeveiculos.dto.request.VeiculoDTO;
import com.orangetalents.cadastrodeveiculos.entity.Usuario;
import com.orangetalents.cadastrodeveiculos.entity.Veiculo;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-04T10:58:51-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.0.2.jar, environment: Java 15.0.2 (Amazon.com Inc.)"
)
public class VeiculoMapperImpl implements VeiculoMapper {

    @Override
    public Veiculo toModel(VeiculoDTO veiculoDTO) {
        if ( veiculoDTO == null ) {
            return null;
        }

        Veiculo veiculo = new Veiculo();

        veiculo.setUsuario( veiculoDTOToUsuario( veiculoDTO ) );
        veiculo.setId( veiculoDTO.getId() );
        veiculo.setTipo( veiculoDTO.getTipo() );
        veiculo.setMarca( veiculoDTO.getMarca() );
        veiculo.setModelo( veiculoDTO.getModelo() );
        veiculo.setAno( veiculoDTO.getAno() );
        veiculo.setValor( veiculoDTO.getValor() );
        veiculo.setDiaRodizio( veiculoDTO.getDiaRodizio() );

        return veiculo;
    }

    @Override
    public VeiculoDTO toDTO(Veiculo veiculo) {
        if ( veiculo == null ) {
            return null;
        }

        VeiculoDTO veiculoDTO = new VeiculoDTO();

        veiculoDTO.setUsuario( veiculoUsuarioId( veiculo ) );
        veiculoDTO.setId( veiculo.getId() );
        veiculoDTO.setTipo( veiculo.getTipo() );
        veiculoDTO.setMarca( veiculo.getMarca() );
        veiculoDTO.setModelo( veiculo.getModelo() );
        veiculoDTO.setAno( veiculo.getAno() );
        veiculoDTO.setValor( veiculo.getValor() );
        veiculoDTO.setDiaRodizio( veiculo.getDiaRodizio() );

        return veiculoDTO;
    }

    @Override
    public List<Veiculo> toModel(List<VeiculoDTO> veiculoDTOList) {
        if ( veiculoDTOList == null ) {
            return null;
        }

        List<Veiculo> list = new ArrayList<Veiculo>( veiculoDTOList.size() );
        for ( VeiculoDTO veiculoDTO : veiculoDTOList ) {
            list.add( toModel( veiculoDTO ) );
        }

        return list;
    }

    private VeiculoDTO setarRodizioAtivo(VeiculoDTO veiculoDTO) {
        String hoje = new DateFormatSymbols().getWeekdays()[Calendar.getInstance().get(Calendar.DAY_OF_WEEK)];
        if(veiculoDTO.getDiaRodizio().equals(hoje)){
            veiculoDTO.setRodizioAtivo(true);
        }else{
            veiculoDTO.setRodizioAtivo(false);
        }
        return veiculoDTO;
    }

    @Override
    public List<VeiculoDTO> toDTO(List<Veiculo> veiculoList) {
        if ( veiculoList == null ) {
            return null;
        }

        List<VeiculoDTO> list = new ArrayList<VeiculoDTO>( veiculoList.size() );
        for ( Veiculo veiculo : veiculoList ) {
            VeiculoDTO veiculoDTOComRodizio =toDTO( veiculo );
            list.add(setarRodizioAtivo(veiculoDTOComRodizio));
        }

        return list;
    }

    protected Usuario veiculoDTOToUsuario(VeiculoDTO veiculoDTO) {
        if ( veiculoDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( veiculoDTO.getUsuario() );

        return usuario;
    }

    private Long veiculoUsuarioId(Veiculo veiculo) {
        if ( veiculo == null ) {
            return null;
        }
        Usuario usuario = veiculo.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        Long id = usuario.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
