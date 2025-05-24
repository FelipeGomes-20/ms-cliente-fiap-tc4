package org.fiap.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.fiap.api.controller.json.ClienteJson;
import org.fiap.api.controller.json.EnderecoJson;
import org.fiap.api.domain.Cliente;
import org.fiap.api.domain.Endereco;
import org.fiap.api.usecase.CadastrarClienteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final CadastrarClienteUseCase cadastrarCliente;

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@Valid @RequestBody ClienteJson clienteJson) {
        Cliente clienteSalvo = cadastrarCliente.cadastrarCliente(mapToDomain(clienteJson));
        return ResponseEntity.ok(clienteSalvo);
    }

    private Cliente mapToDomain(ClienteJson json) {
        return new Cliente(
                null,
                json.getNome(),
                json.getCpf(),
                json.getDataNascimento(),
                json.getEnderecos().stream()
                        .map(this::mapToEndereco)
                        .collect(Collectors.toList())
        );
    }

    private Endereco mapToEndereco(EnderecoJson json) {
        return new Endereco(
                json.getRua(),
                json.getNumero(),
                json.getComplemento(),
                json.getBairro(),
                json.getCidade(),
                json.getEstado(),
                json.getCep()
        );
    }
}
