package br.com.fiap.microservices.easynsurance.corretor.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.microservices.easynsurance.corretor.dto.CorretorCreateUpdateDTO;
import br.com.fiap.microservices.easynsurance.corretor.dto.CorretorDTO;
import br.com.fiap.microservices.easynsurance.corretor.entity.Corretor;
import br.com.fiap.microservices.easynsurance.corretor.repository.ClienteRepository;

@Service
public class CorretorServiceImpl implements CorretorService {

    private final ClienteRepository corretorRepository;

    public CorretorServiceImpl(ClienteRepository corretorRepository){
        this.corretorRepository = corretorRepository;
    }

    @Override
    public List<CorretorDTO> findAll() {
        return corretorRepository.findAll()
                .stream()
                .map(corretor -> new CorretorDTO(corretor))
                .collect(Collectors.toList());
    }

    @Override
    public CorretorDTO findById(Long id) {
        Corretor product = getCorretor(id);
        return new CorretorDTO(product);
    }

    @Override
    public CorretorDTO create(CorretorCreateUpdateDTO corretorCreateUpdateDTO) {
        Corretor corretor = montaCorretor(corretorCreateUpdateDTO);
        
        Corretor savedCorretor = corretorRepository.save(corretor);
        return new CorretorDTO(savedCorretor);
    }

    private Corretor montaCorretor(CorretorCreateUpdateDTO corretorCreateUpdateDTO) {
    	Corretor corretor = new Corretor();
		corretor.setCpf(corretorCreateUpdateDTO.getCpf());
		corretor.setEndereco(corretorCreateUpdateDTO.getEndereco());
		corretor.setIdade(corretorCreateUpdateDTO.getIdade());
		corretor.setNome(corretorCreateUpdateDTO.getNome());
		corretor.setEmail(corretorCreateUpdateDTO.getEmailUsuario());
		corretor.setPassword(corretorCreateUpdateDTO.getPassword());
		corretor.setTelefone(corretorCreateUpdateDTO.getTelefone());
		return corretor;
	}

	@Override
    public CorretorDTO update(Long id, CorretorCreateUpdateDTO corretorCreateUpdateDTO) {
        Corretor corretor = getCorretor(id);

        corretor.setCpf(corretorCreateUpdateDTO.getCpf());
        corretor.setEndereco(corretorCreateUpdateDTO.getEndereco());
        corretor.setIdade(corretorCreateUpdateDTO.getIdade());
        corretor.setNome(corretorCreateUpdateDTO.getNome());
        corretor.setEmail(corretorCreateUpdateDTO.getEmailUsuario());
        corretor.setPassword(corretorCreateUpdateDTO.getPassword());
        corretor.setTelefone(corretorCreateUpdateDTO.getTelefone());
        
        Corretor savedCorretor = corretorRepository.save(corretor);

        return new CorretorDTO(savedCorretor);
    }


    @Override
    public void delete(Long id) {
        Corretor corretor = getCorretor(id);
        corretorRepository.delete(corretor);
    }

    private Corretor getCorretor(Long id) {
        return corretorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
