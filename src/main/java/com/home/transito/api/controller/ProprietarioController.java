package com.home.transito.api.controller;

import com.home.transito.domain.model.Proprietario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {
    @PersistenceContext
    private EntityManager manager;

    @GetMapping()
    public List<Proprietario> testar() {
        return manager.createQuery("from Proprietario", Proprietario.class)
                       .getResultList();
    }
}
