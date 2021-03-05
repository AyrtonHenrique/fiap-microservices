package br.com.fiap.microservices.easynsurance.cliente.service;

import java.util.List;

import br.com.fiap.microservices.easynsurance.cliente.dto.ClienteCreateUpdateDTO;
import br.com.fiap.microservices.easynsurance.cliente.dto.ClienteDTO;

public interface ClienteService {

    List<ClienteDTO> findAll();
    ClienteDTO findById(Long id);
    ClienteDTO create(ClienteCreateUpdateDTO clienteCreateUpdateDTO);
    ClienteDTO update(Long id, ClienteCreateUpdateDTO clienteCreateUpdateDTO);
    void delete(Long id);

}
