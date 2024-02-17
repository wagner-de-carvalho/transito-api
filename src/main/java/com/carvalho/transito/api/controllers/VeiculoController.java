package com.carvalho.transito.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carvalho.transito.api.model.VeiculoModel;
import com.carvalho.transito.domain.exception.NegocioException;
import com.carvalho.transito.domain.model.Veiculo;
import com.carvalho.transito.domain.repository.VeiculoRepository;
import com.carvalho.transito.domain.service.RegistroVeiculoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/veiculos")
@AllArgsConstructor
public class VeiculoController {

    private final VeiculoRepository veiculoRepository;
    private final RegistroVeiculoService registroVeiculoService;

    @GetMapping
    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<VeiculoModel> buscar(@PathVariable Long veiculoId) {
        return veiculoRepository.findById(veiculoId)
                .map(veiculo -> {
                    var veiculoModel = new VeiculoModel();
                    veiculoModel.setId(veiculo.getId());
                    veiculoModel.setNomeProprietario(veiculo.getProprietario().getNome());
                    veiculoModel.setMarca(veiculo.getMarca());
                    veiculoModel.setModelo(veiculo.getModelo());
                    veiculoModel.setPlaca(veiculo.getPlaca());
                    veiculoModel.setStatus(veiculo.getStatus());
                    veiculoModel.setDataCadastro(veiculo.getDataCadastro());
                    veiculoModel.setDataApreensao(veiculo.getDataApreensao());
                    return veiculoModel;
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo cadastrar(@Valid @RequestBody Veiculo veiculo) {
        return registroVeiculoService.cadastrar(veiculo);
    }

}
