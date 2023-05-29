package com.home.transito.api.assembler;

import com.home.transito.api.model.AutuacaoModel;
import com.home.transito.api.model.VeiculoInput;
import com.home.transito.api.model.VeiculoModel;
import com.home.transito.api.model.input.AutuacaoInput;
import com.home.transito.domain.model.Autuacao;
import com.home.transito.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class AutuacaoAssembler {

    private final ModelMapper modelMapper;

    public Autuacao toEntity(AutuacaoInput autuacaoInput) {
        return modelMapper.map(autuacaoInput, Autuacao.class);
    }

    public AutuacaoModel toModel(Autuacao autuacao) {
        return modelMapper.map(autuacao, AutuacaoModel.class);
    }

    public List<AutuacaoModel> toCollectionModel(List<Autuacao> autuacoes) {
        return autuacoes.stream()
                       .map(this::toModel)
                       .toList();
    }
}
