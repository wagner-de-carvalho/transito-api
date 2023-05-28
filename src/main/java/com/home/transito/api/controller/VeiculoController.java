package com.home.transito.api.controller;

import com.home.transito.domain.model.Veiculo;
import com.home.transito.domain.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    private final VeiculoRepository veiculosRepository;

    @GetMapping
    public List<Veiculo> listar() {
        return veiculosRepository.findAll();
    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<Veiculo> buscar(@PathVariable Long veiculoId) {
        return veiculosRepository.findById(veiculoId)
                       .map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }
}
