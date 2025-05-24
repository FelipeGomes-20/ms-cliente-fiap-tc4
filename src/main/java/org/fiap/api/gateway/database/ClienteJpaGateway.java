package org.fiap.api.gateway.database;

import lombok.RequiredArgsConstructor;
import org.fiap.api.domain.Cliente;
import org.fiap.api.domain.Endereco;
import org.fiap.api.gateway.ClienteGateway;
import org.fiap.api.gateway.database.entity.ClienteEntity;
import org.fiap.api.gateway.database.entity.EnderecoEntity;
import org.fiap.api.gateway.database.repository.ClienteRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteJpaGateway implements ClienteGateway {

    private final ClienteRepository clienteRepository;


    @Override
    public Cliente salvar(Cliente cliente) {
        ClienteEntity entity = toEntity(cliente);
        ClienteEntity saved = clienteRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        ClienteEntity entity = toEntity(cliente);
        ClienteEntity saved = clienteRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> listarTodos() {
        //return clienteRepository.findAll().stream().map(this::toDomain);
        return null;
    }

    @Override
    public Optional<Cliente> buscarPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf).map(this::toDomain);
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id).map(this::toDomain);
    }

    private ClienteEntity toEntity(Cliente cliente) {
        ClienteEntity entity = ClienteEntity.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .dataNascimento(cliente.getDataNascimento())
                .build();

        List<EnderecoEntity> enderecos = cliente.getEnderecos().stream()
                .map(e -> EnderecoEntity.builder()
                        .rua(e.getRua())
                        .numero(e.getNumero())
                        .complemento(e.getComplemento())
                        .bairro(e.getBairro())
                        .cidade(e.getCidade())
                        .estado(e.getEstado())
                        .cep(e.getCep())
                        .cliente(entity)
                        .build())
                .collect(Collectors.toList());

        entity.setEnderecos(enderecos);
        return entity;
    }

    private Cliente toDomain(ClienteEntity entity) {
        List<Endereco> enderecos = entity.getEnderecos().stream()
                .map(e -> new Endereco(
                        e.getRua(), e.getNumero(), e.getComplemento(),
                        e.getBairro(), e.getCidade(), e.getEstado(), e.getCep()
                )).collect(Collectors.toList());

        return new Cliente(entity.getId(), entity.getNome(), entity.getCpf(), entity.getDataNascimento(), enderecos);
    }
}
