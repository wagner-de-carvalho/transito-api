package com.carvalho.transito.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proprietario {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
}
