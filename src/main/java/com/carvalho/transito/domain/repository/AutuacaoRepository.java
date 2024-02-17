package com.carvalho.transito.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carvalho.transito.domain.model.Autuacao;

public interface AutuacaoRepository extends JpaRepository<Autuacao, Long> {

}
