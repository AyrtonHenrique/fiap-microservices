package br.com.fiap.microservices.easynsurance.corretor.service;

import java.util.List;

import br.com.fiap.microservices.easynsurance.corretor.dto.CorretorCreateUpdateDTO;
import br.com.fiap.microservices.easynsurance.corretor.dto.CorretorDTO;

public interface CorretorService {

    List<CorretorDTO> findAll();
    CorretorDTO findById(Long id);
    CorretorDTO create(CorretorCreateUpdateDTO corretorCreateUpdateDTO);
    CorretorDTO update(Long id, CorretorCreateUpdateDTO corretorCreateUpdateDTO);
    void delete(Long id);

}
