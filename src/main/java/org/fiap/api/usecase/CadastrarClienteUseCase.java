package org.fiap.api.usecase;

import lombok.RequiredArgsConstructor;
import org.fiap.api.domain.Cliente;
import org.fiap.api.exception.ClienteExistenteException;
import org.fiap.api.gateway.ClienteGateway;

@RequiredArgsConstructor
public class CadastrarClienteUseCase {

    private final ClienteGateway clienteGateway;

    public Cliente cadastrarCliente(Cliente cliente) {

        if (clienteGateway.buscarPorCpf(cliente.getCpf()).isPresent()) {
            throw new ClienteExistenteException("Cliente com CPF: "+ cliente.getCpf() +" já existe.");
        }

        return clienteGateway.salvar(cliente);
    }
}
