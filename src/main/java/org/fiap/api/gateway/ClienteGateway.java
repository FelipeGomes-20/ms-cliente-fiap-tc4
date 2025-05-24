package org.fiap.api.gateway;

import org.fiap.api.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteGateway {
    Cliente salvar(Cliente cliente);
    Cliente atualizar(Cliente cliente);
    void excluir(Long id);
    List<Cliente> listarTodos();
    Optional<Cliente> buscarPorCpf(String cpf);
    Optional<Cliente> buscarPorId(Long id);
}
