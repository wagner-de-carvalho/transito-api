package com.carvalho.transito.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carvalho.transito.api.assembler.AutuacaoAssembler;
import com.carvalho.transito.api.model.AutuacaoModel;
import com.carvalho.transito.api.model.input.AutuacaoInput;
import com.carvalho.transito.domain.model.Autuacao;
import com.carvalho.transito.domain.service.RegistroAutuacaoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos/{veiculoId}/autuacoes")
public class AutuacaoController {
    private final AutuacaoAssembler autuacaoAssembler;
    private final RegistroAutuacaoService registroAutuacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutuacaoModel registrar(@PathVariable Long veiculoId, @Valid @RequestBody AutuacaoInput autuacaoInput) {
        var autuacao = autuacaoAssembler.toEntity(autuacaoInput);
        var autuacaoRegistrada = registroAutuacaoService.registrar(veiculoId, autuacao);

        return autuacaoAssembler.toModel(autuacaoRegistrada);
    }

}
