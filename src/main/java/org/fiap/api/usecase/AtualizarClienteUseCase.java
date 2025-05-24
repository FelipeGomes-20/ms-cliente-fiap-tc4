package org.fiap.api.usecase;

import lombok.RequiredArgsConstructor;
import org.fiap.api.domain.Cliente;
import org.fiap.api.gateway.ClienteGateway;

@RequiredArgsConstructor
public class AtualizarClienteUseCase {
    private final ClienteGateway clienteGateway;

    public Cliente atualizarCliente(Cliente cliente) {
        return clienteGateway.atualizar(cliente);
    }
}
