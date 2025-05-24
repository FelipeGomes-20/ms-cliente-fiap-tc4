package org.fiap.api.usecase;

import lombok.RequiredArgsConstructor;
import org.fiap.api.gateway.ClienteGateway;

@RequiredArgsConstructor
public class ExcluirClienteUseCase {
    private final ClienteGateway clienteGateway;

    public void excluirCliente(Long id) {
        clienteGateway.excluir(id);
    }
}
