package com.carvalho.transito.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carvalho.transito.domain.model.Proprietario;
import com.carvalho.transito.domain.repository.ProprietarioRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/proprietarios")
@AllArgsConstructor
public class ProprietarioController {

    private ProprietarioRepository proprietarioRepository;

    @GetMapping()
    public List<Proprietario> listar() {
        return proprietarioRepository.findAll();
    }

    @GetMapping("/{proprietarioId}")
    public ResponseEntity<Proprietario> buscar(@PathVariable Long proprietarioId) {
        return proprietarioRepository.findById(proprietarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
