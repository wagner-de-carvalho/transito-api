package com.carvalho.transito.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carvalho.transito.domain.model.Proprietario;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    @GetMapping()
    public List<Proprietario> listar() {
        var p1 = new Proprietario()
                .builder()
                .email("acme@mail.com")
                .id(2L)
                .nome("Acme")
                .build();
        var p2 = new Proprietario()
                .builder()
                .id(1L)
                .email("plim@mail.com")
                .nome("Plim")
                .build();
        return List.of(p1, p2);

    }

}
