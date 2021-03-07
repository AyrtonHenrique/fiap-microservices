package br.com.fiap.microservices.easynsurance.corretor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	public ResponseEntity<List<CorretorDTO>> listAll() {
		List<CorretorDTO> result = null;
		try {
			logger.info("listAll: Buscando todos os Corretores");
			result = this.corretorService.findAll();		
			if(result.isEmpty())
				return new ResponseEntity<List<CorretorDTO>>(result, HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<CorretorDTO>>(result, HttpStatus.OK);
		} catch (ResponseStatusException e) {
			throw e;
		} catch(Exception e) {
			logger.error("Ocorreu um erro na aplicação", e);
			return new ResponseEntity<List<CorretorDTO>>(result, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CorretorDTO> getById(@PathVariable Long id) {
		CorretorDTO result = null;
		try {
			logger.info("listAll: Buscando Corretor de ID: " + id);
			result = this.corretorService.findById(id);
			if(result == null)
				return new ResponseEntity<CorretorDTO>(result, HttpStatus.NO_CONTENT);
			return new ResponseEntity<CorretorDTO>(result, HttpStatus.OK);
		} catch (ResponseStatusException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Ocorreu um erro na aplicação", e);
			return new ResponseEntity<CorretorDTO>(result, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public  ResponseEntity<CorretorDTO> create(@RequestBody CorretorCreateUpdateDTO corretorCreateUpdateDTO) {
    	CorretorDTO result = null;
    	try {
    		if(!corretorCreateUpdateDTO.validaDadosMinimosEnviados()) {
    			logger.info("Create: Criando um novo Corretor");
        		result = this.corretorService.create(corretorCreateUpdateDTO);
        		return new ResponseEntity<CorretorDTO>(result, HttpStatus.OK);
        	} else {
        		logger.info("Dados do Corretor enviados incompletos.");
        		return new ResponseEntity<CorretorDTO>(result, HttpStatus.BAD_REQUEST);
        	}
    	} catch (ResponseStatusException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Ocorreu um erro na aplicação", e);
			return new ResponseEntity<CorretorDTO>(result, HttpStatus.INTERNAL_SERVER_ERROR); 
    	}
    	
	}
    
    @PutMapping("{id}")
    public ResponseEntity<CorretorDTO> update(@PathVariable Long id, @RequestBody CorretorCreateUpdateDTO corretorCreateUpdateDTO) {
    	CorretorDTO result = null;
     	try {
     		if(!corretorCreateUpdateDTO.validaDadosMinimosEnviados()) {
     			logger.info("Update: Atualizando um Corretor de ID: " + id);
     			result = this.corretorService.update(id, corretorCreateUpdateDTO);
         		return new ResponseEntity<CorretorDTO>(result, HttpStatus.OK);
     		} else {
         		logger.info("Dados do Corretor enviados incompletos.");
         		return new ResponseEntity<CorretorDTO>(result, HttpStatus.BAD_REQUEST);
         	}
 		} catch (ResponseStatusException e) {
 			throw e;
 		} catch (Exception e) {
 			logger.error("Ocorreu um erro na aplicação", e);
 			return new ResponseEntity<CorretorDTO>(result, HttpStatus.INTERNAL_SERVER_ERROR); 
 		}    	 
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
    	try {
    		logger.info("Apagando Corretor de ID: " + id);
    		this.corretorService.delete(id);
    	} catch (ResponseStatusException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Ocorreu um erro na aplicação", e);
			throw e;
		}
    }
    
}
