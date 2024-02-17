package com.carvalho.transito.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.carvalho.transito.api.model.AutuacaoModel;
import com.carvalho.transito.api.model.input.AutuacaoInput;
import com.carvalho.transito.domain.model.Autuacao;
import lombok.AllArgsConstructor;

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
