package br.com.fiap.microservices.easynsurance.cliente.controller;

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

import br.com.fiap.microservices.easynsurance.cliente.dto.ClienteCreateUpdateDTO;
import br.com.fiap.microservices.easynsurance.cliente.dto.ClienteDTO;
import br.com.fiap.microservices.easynsurance.cliente.service.ClienteService;

/**
 * Controller responsável por expor todos os métodos da API relativos ao Cliente expostos nesta aplicação.
 * @author Carlos Eduardo Roque da Silva
 *
 */
@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	private final Logger logger = LoggerFactory.getLogger(ClienteController.class);

	private final ClienteService clienteService;
	
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> listAll() {	
		List<ClienteDTO> result = null;
		try {
			logger.info("listAll: Buscando todos os clientes");
			result = this.clienteService.findAll();			
			if(result.isEmpty())
				return new ResponseEntity<List<ClienteDTO>>(result, HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<ClienteDTO>>(result, HttpStatus.OK);
		} catch (ResponseStatusException e) {
			throw e;
		} catch(Exception e) {
			logger.error("Ocorreu um erro na aplicação", e);
			return new ResponseEntity<List<ClienteDTO>>(result, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
		ClienteDTO result = null;
		try {
			logger.info("listAll: Buscando Cliente de ID: " + id);
			result = this.clienteService.findById(id);
			if(result == null)
				return new ResponseEntity<ClienteDTO>(result, HttpStatus.NO_CONTENT);
			return new ResponseEntity<ClienteDTO>(result, HttpStatus.OK);
		} catch (ResponseStatusException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Ocorreu um erro na aplicação", e);
			return new ResponseEntity<ClienteDTO>(result, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ClienteDTO> create(@RequestBody ClienteCreateUpdateDTO clienteCreateUpdateDTO) {
    	ClienteDTO result = null;
    	try {
    		if(!clienteCreateUpdateDTO.validaDadosMinimosEnviados()) {
    			logger.info("Create: Criando um novo cliente");
        		result = this.clienteService.create(clienteCreateUpdateDTO);
        		return new ResponseEntity<ClienteDTO>(result, HttpStatus.OK);
        	} else {
        		logger.info("Dados do Cliente enviados incompletos.");
        		return new ResponseEntity<ClienteDTO>(result, HttpStatus.BAD_REQUEST);
        	}
    	} catch (ResponseStatusException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Ocorreu um erro na aplicação", e);
			return new ResponseEntity<ClienteDTO>(result, HttpStatus.INTERNAL_SERVER_ERROR); 
    	}
    	
	}
    
	@PutMapping("{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteCreateUpdateDTO clienteCreateUpdateDTO) {
    	ClienteDTO result = null;
    	try {
    		if(!clienteCreateUpdateDTO.validaDadosMinimosEnviados()) {
    			logger.info("Update: Atualizando um novo cliente de ID: " + id);
    			result = this.clienteService.update(id, clienteCreateUpdateDTO);
        		return new ResponseEntity<ClienteDTO>(result, HttpStatus.OK);
    		} else {
        		logger.info("Dados do Cliente enviados incompletos.");
        		return new ResponseEntity<ClienteDTO>(result, HttpStatus.BAD_REQUEST);
        	}
		} catch (ResponseStatusException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Ocorreu um erro na aplicação", e);
			return new ResponseEntity<ClienteDTO>(result, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
    	try {
    		logger.info("Apagando cliente de ID: " + id);
    	   	this.clienteService.delete(id);
    	} catch (ResponseStatusException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Ocorreu um erro na aplicação", e);
			throw e;
		}
 
    }

}
