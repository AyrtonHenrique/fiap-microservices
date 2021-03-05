package br.com.fiap.microservices.easynsurance.cliente.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.microservices.easynsurance.cliente.dto.ClienteCreateUpdateDTO;
import br.com.fiap.microservices.easynsurance.cliente.dto.ClienteDTO;
import br.com.fiap.microservices.easynsurance.cliente.entity.Cliente;
import br.com.fiap.microservices.easynsurance.cliente.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll()
                .stream()
                .map(cliente -> new ClienteDTO(cliente))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO findById(Long id) {
        Cliente cliente = getCliente(id);
        return new ClienteDTO(cliente);
    }

    @Override
    public ClienteDTO create(ClienteCreateUpdateDTO clienteCreateUpdateDTO) {
        Cliente cliente = new Cliente();

        cliente.setCpf(clienteCreateUpdateDTO.getCpf());
        cliente.setEndereco(clienteCreateUpdateDTO.getEndereco());
        cliente.setIdade(clienteCreateUpdateDTO.getIdade());
        cliente.setNome(clienteCreateUpdateDTO.getNome());
        cliente.setNomeUsuario(clienteCreateUpdateDTO.getNomeUsuario());
        cliente.setPassword(clienteCreateUpdateDTO.getPassword());
       
        Cliente savedCliente = clienteRepository.save(cliente);

        return new ClienteDTO(savedCliente);
    }

    @Override
    public ClienteDTO update(Long id, ClienteCreateUpdateDTO corretorCreateUpdateDTO) {
        Cliente cliente = getCliente(id);

        cliente.setCpf(corretorCreateUpdateDTO.getCpf());
        cliente.setEndereco(corretorCreateUpdateDTO.getEndereco());
        cliente.setIdade(corretorCreateUpdateDTO.getIdade());
        cliente.setNome(corretorCreateUpdateDTO.getNome());
        cliente.setNomeUsuario(corretorCreateUpdateDTO.getNomeUsuario());
        cliente.setPassword(corretorCreateUpdateDTO.getPassword());

        Cliente savedCliente = clienteRepository.save(cliente);

        return new ClienteDTO(savedCliente);
    }


    @Override
    public void delete(Long id) {
        Cliente corretor = getCliente(id);
        clienteRepository.delete(corretor);
    }

    private Cliente getCliente(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
