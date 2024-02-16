package com.carvalho.transito.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carvalho.transito.domain.model.Proprietario;
import com.carvalho.transito.domain.repository.ProprietarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistroProprietarioService {
    private final ProprietarioRepository proprietarioRepository;

    @Transactional
    public Proprietario salvar(Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }

    @Transactional
    public void excluir(Long proprietarioId) {
        proprietarioRepository.deleteById(proprietarioId);
    }

}
