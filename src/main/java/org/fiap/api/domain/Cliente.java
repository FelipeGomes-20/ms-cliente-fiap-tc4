package org.fiap.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Cliente {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private List<Endereco> enderecos;
}
