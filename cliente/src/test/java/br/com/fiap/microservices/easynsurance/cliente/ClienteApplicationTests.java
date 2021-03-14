package br.com.fiap.microservices.easynsurance.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.google.gson.Gson;

import br.com.fiap.microservices.easynsurance.cliente.dto.ClienteDTO;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = ClienteApplication.class)
@AutoConfigureWebMvc
class ClienteApplicationTests {

	final String baseUrl = "http://localhost:8088"+"/easyinsurance/cliente";
	
 	@Autowired
    private TestRestTemplate restTemplate;

	@Test
	void testaPostClienteNovo() throws URISyntaxException {
		System.out.println("Testando POST de um corretor novo.");

    	URI uri = new URI(baseUrl);
    	
    	ClienteDTO cliente = new ClienteDTO();
    	cliente.setNome("CARLOS");
    	cliente.setCpf("333.333.333-00");
    	cliente.setEmailUsuario("teste@email.com");
    	cliente.setEndereco("Rua 1");
    	cliente.setIdade(37);
    	cliente.setPassword("123456");
    	cliente.setTelefone("119999-9999");
    	
        HttpHeaders headers = new HttpHeaders();  
        HttpEntity<ClienteDTO> request = new HttpEntity<>(cliente, headers);   
        
        ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);
         
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
	}
	
	@Test
	void testaPostClienteNovoDadosIncompletos() throws URISyntaxException {
		System.out.println("Testando POST de um cliente novo com dados incompletos.");

    	URI uri = new URI(baseUrl);
    	
    	ClienteDTO cliente = new ClienteDTO();
    	cliente.setNome("CARLOS");
    	cliente.setCpf("333.333.333-00");
    	cliente.setIdade(37);
    	cliente.setTelefone("119999-9999");
    	
        HttpHeaders headers = new HttpHeaders();  
        HttpEntity<ClienteDTO> request = new HttpEntity<>(cliente, headers);   
        
        ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);
         
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCodeValue());
	}
	
	@Test
	void testaPostClienteNovoDadosCompletosEGetPeloCodigo() throws URISyntaxException {
		System.out.println("Testando POST de um cliente  novo com dados completos para dar GET Depois.");
    	URI uri = new URI(baseUrl);
    	
    	ClienteDTO cliente = new ClienteDTO();
    	cliente.setNome("CARLOS");
    	cliente.setCpf("333.333.333-00");
    	cliente.setEmailUsuario("teste@email.com");
    	cliente.setEndereco("Rua 1");
    	cliente.setIdade(37);
    	cliente.setPassword("123456");
    	cliente.setTelefone("119999-9999");
    	
        HttpHeaders headers = new HttpHeaders();  
        HttpEntity<ClienteDTO> request = new HttpEntity<>(cliente, headers);   
        ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);
        
        ClienteDTO clienteCriado = new Gson().fromJson(response.getBody(), ClienteDTO.class);
        
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
        
        // -----------------------------------------------------------------------------------------------
        
        URI uriRead = new URI(baseUrl + "/" + clienteCriado.getId());
  
        ResponseEntity<String> response2 =  this.restTemplate.getForEntity(uriRead, String.class);
        
        assertEquals(HttpStatus.OK.value(), response2.getStatusCodeValue());
        
        ClienteDTO clienteRecuperado = new Gson().fromJson(response2.getBody(), ClienteDTO.class);
        
        boolean corretoresIguais = clienteRecuperado.getId().equals(clienteCriado.getId());
        
        assertEquals(corretoresIguais, true);
	}
	
	@Test
	void testaAtualizaClienteCriado() throws URISyntaxException {
		System.out.println("Testando POST de um cliente novo com dados incompletos.");

    	URI uri = new URI(baseUrl);
    	
    	ClienteDTO cliente = new ClienteDTO();
    	cliente.setNome("CARLOS");
    	cliente.setCpf("333.333.333-00");
    	cliente.setEmailUsuario("teste@email.com");
    	cliente.setEndereco("Rua 1");
    	cliente.setIdade(37);
    	cliente.setPassword("123456");
    	cliente.setTelefone("119999-9999");
    	
    	 HttpHeaders headers = new HttpHeaders();  
         HttpEntity<ClienteDTO> request = new HttpEntity<>(cliente, headers);   
         ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);
         
         ClienteDTO clienteCriado = new Gson().fromJson(response.getBody(), ClienteDTO.class);
         // Testa Criação com sucesso
         assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
         
         // -------------------------------------------------------------------------------------------------------
         clienteCriado.setCpf("444.444.444-00");
         HttpEntity<ClienteDTO> requestUpdate = new HttpEntity<>(clienteCriado, headers);
         
         ResponseEntity<String> responseUpdate = this.restTemplate.exchange(uri + "/" + clienteCriado.getId(), HttpMethod.PUT, requestUpdate, String.class);
         ClienteDTO clienteAtualizado = new Gson().fromJson(responseUpdate.getBody(), ClienteDTO.class);
         assertEquals(HttpStatus.OK.value(), responseUpdate.getStatusCodeValue());
         // Valida se o corretorAtualizado tem o CPF atualizado com o valor enviado
         assertEquals(true, clienteCriado.getCpf().equals(clienteAtualizado.getCpf()));
         // -------------------------------------------------------------------------------------------------------
	}
	
	@Test
	void testaDeletaClienteCriado() throws URISyntaxException {
		System.out.println("Testando POST de um cliente novo com dados incompletos.");

    	URI uri = new URI(baseUrl);
    	
    	ClienteDTO corretor = new ClienteDTO();
    	corretor.setNome("CARLOS");
    	corretor.setCpf("333.333.333-00");
    	corretor.setEmailUsuario("teste@email.com");
    	corretor.setEndereco("Rua 1");
    	corretor.setIdade(37);
    	corretor.setPassword("123456");
    	corretor.setTelefone("119999-9999");
    	
    	 HttpHeaders headers = new HttpHeaders();  
         HttpEntity<ClienteDTO> request = new HttpEntity<>(corretor, headers);   
         ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);
         
         ClienteDTO clienteCriado = new Gson().fromJson(response.getBody(), ClienteDTO.class);
         // Testa Criação com sucesso
         assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
         
         // -------------------------------------------------------------------------------------------------------
         HttpEntity<ClienteDTO> requestDelete = new HttpEntity<>(clienteCriado, headers);
         
         ResponseEntity<String> responseDelete = this.restTemplate.exchange(uri + "/" + clienteCriado.getId(), HttpMethod.DELETE, requestDelete, String.class);

         assertEquals(HttpStatus.NO_CONTENT.value(), responseDelete.getStatusCodeValue());
         // -------------------------------------------------------------------------------------------------------
	}
	
}
