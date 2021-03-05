package br.com.fiap.microservices.easynsurance.cliente.controller;

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
	public List<ClienteDTO> listAll() {
		return this.clienteService.findAll();
	}
	
	@GetMapping("{id}")
	public ClienteDTO getById(@PathVariable Long id) {
		 return this.clienteService.findById(id);
	}
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public ClienteDTO create(@RequestBody ClienteCreateUpdateDTO clienteCreateUpdateDTO) {
    	return this.clienteService.create(clienteCreateUpdateDTO);
	}
    
    @PutMapping("{id}")
    public ClienteDTO update(@PathVariable Long id, @RequestBody ClienteCreateUpdateDTO clienteCreateUpdateDTO) {
    	 return this.clienteService.update(id, clienteCreateUpdateDTO);
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
    	this.clienteService.delete(id);
    }
    
}
