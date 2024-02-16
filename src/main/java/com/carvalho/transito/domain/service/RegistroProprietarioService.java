package com.carvalho.transito.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carvalho.transito.domain.exception.NegocioException;
import com.carvalho.transito.domain.model.Proprietario;
import com.carvalho.transito.domain.repository.ProprietarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistroProprietarioService {
    private final ProprietarioRepository proprietarioRepository;

    @Transactional
    public Proprietario salvar(Proprietario novoProprietario) {
        boolean emailEmUso = proprietarioRepository.findByEmail(novoProprietario.getEmail())
                .filter(p -> !p.equals(
                        novoProprietario))
                .isPresent();

        if (emailEmUso) {
            throw new NegocioException("E-mail já cadastrado");
        }
        return proprietarioRepository.save(novoProprietario);
    }

    @Transactional
    public void excluir(Long proprietarioId) {
        proprietarioRepository.deleteById(proprietarioId);
    }

    public Proprietario buscar(Long proprietarioId) {
        return this.proprietarioRepository.findById(
                proprietarioId)
                .orElseThrow(() -> new NegocioException("Proprietário não encontrado"));
    }

}
