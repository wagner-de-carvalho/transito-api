package com.home.transito.api.controller;

import com.home.transito.domain.model.Proprietario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    @GetMapping()
    public List<Proprietario> testar() {
        var p1 = new Proprietario();
        p1.setNome("João de");
        p1.setId(1L);
        p1.setTelefone("66684579");
        p1.setEmail("joao@mail.com");

        var p2 = new Proprietario();
        p2.setNome("Maria Alves");
        p2.setId(2L);
        p2.setTelefone("54278954");
        p2.setEmail("alvesma@mail.com");

        return Arrays.asList(p1, p2);
    }
}
