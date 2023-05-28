package com.home.transito.api.controller;

import com.home.transito.domain.model.Veiculo;
import com.home.transito.domain.repository.VeiculoRepository;
import com.home.transito.domain.service.RegistroVeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    private final VeiculoRepository veiculosRepository;
    private final RegistroVeiculoService registroVeiculoService;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) {
        return registroVeiculoService.cadastrar(veiculo);
    }
}
