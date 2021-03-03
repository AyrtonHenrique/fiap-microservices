package br.com.fiap.microservices.easynsurance.corretor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.microservices.easynsurance.corretor.dto.CorretorCreateUpdateDTO;
import br.com.fiap.microservices.easynsurance.corretor.dto.CorretorDTO;
import br.com.fiap.microservices.easynsurance.corretor.service.CorretorService;

/**
 * Controller responsável por expor todos os métodos da API relativos ao Corretor expostos nesta aplicação.
 * @author Carlos Eduardo Roque da Silva
 *
 */
@RestController
@RequestMapping("corretor")
public class CorretorController {
	
	private final Logger logger = LoggerFactory.getLogger(CorretorController.class);

	private final CorretorService corretorService;
	
    public CorretorController(CorretorService corretorService) {
        this.corretorService = corretorService;
    }
	
	@GetMapping
	public List<CorretorDTO> listAll() {
		return this.corretorService.findAll();
	}
	
	@GetMapping("{id}")
	public CorretorDTO getById(@PathVariable Long id) {
		 return this.corretorService.findById(id);
	}
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public CorretorDTO create(@RequestBody CorretorCreateUpdateDTO corretorCreateUpdateDTO) {
    	return this.corretorService.create(corretorCreateUpdateDTO);
	}
    
    @PutMapping("{id}")
    public CorretorDTO update(@PathVariable Long id, @RequestBody CorretorCreateUpdateDTO corretorCreateUpdateDTO) {
    	 return this.corretorService.update(id, corretorCreateUpdateDTO);
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
    	this.corretorService.delete(id);
    }
    
}
