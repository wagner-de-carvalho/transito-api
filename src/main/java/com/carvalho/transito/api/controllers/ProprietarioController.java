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
        return List.of();
    }

}
