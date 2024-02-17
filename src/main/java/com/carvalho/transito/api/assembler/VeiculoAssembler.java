package com.carvalho.transito.api.assembler;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.carvalho.transito.api.model.VeiculoModel;
import com.carvalho.transito.api.model.input.VeiculoInput;
import com.carvalho.transito.domain.model.Veiculo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class VeiculoAssembler {
    private final ModelMapper modelMapper;

    public Veiculo toEntity(VeiculoInput veiculoInput) {
        return modelMapper.map(veiculoInput, Veiculo.class);
    }

    public VeiculoModel toModel(Veiculo veiculo) {
        return modelMapper.map(veiculo, VeiculoModel.class);
    }

    public List<VeiculoModel> toCollectionModel(List<Veiculo> veiculos) {
        return veiculos.stream()
                .map(this::toModel)
                .toList();
    }
}
