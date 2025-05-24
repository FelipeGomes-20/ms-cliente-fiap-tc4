package org.fiap.api.usecase;

import lombok.RequiredArgsConstructor;
import org.fiap.api.domain.Cliente;
import org.fiap.api.gateway.ClienteGateway;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class BuscarClientesUseCase {
    private final ClienteGateway clienteGateway;

// Sei que seria um UseCase pra cada, mas reduzi por serem buscas simples

    public List<Cliente> listarTodosClientes(){
        return clienteGateway.listarTodos();
    }

    public Optional<Cliente> buscarClienteCPF(String cpf){
        return clienteGateway.buscarPorCpf(cpf);
    }

    public Optional<Cliente> buscarClienteId(Long id){
        return clienteGateway.buscarPorId(id);
    }
}
