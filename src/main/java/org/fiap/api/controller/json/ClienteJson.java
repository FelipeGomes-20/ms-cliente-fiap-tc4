package org.fiap.api.controller.json;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteJson {

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotBlank(message = "CPF é obrigatório.")
    @Pattern(regexp = "^\\d{11}$", message = "O CPF deve conter exatamente 11 dígitos numéricos! Insira um CPF válido.")
    //@CPF(message = "Insira um CPF válido.") substituir depois
    private String cpf;

    @NotNull(message = "Data de nascimento é obrigatória.")
    private LocalDate dataNascimento;

    @Valid
    @NotNull(message = "Pelo menos um endereço deve ser informado")
    private List<EnderecoJson> enderecos;
}
