package br.com.fiap.microservices.easynsurance.corretor;

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

import br.com.fiap.microservices.easynsurance.corretor.dto.CorretorDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = CorretorApplication.class)
@AutoConfigureWebMvc
class CorretorApplicationTests {

	final String baseUrl = "http://localhost:8089"+"/easyinsurance/corretor";
	
 	@Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() {
	}

	@Test
	void testaGetCorretoresListaVazia() throws URISyntaxException {
		System.out.println("Testando GET de todos os corretores com a lista vazia.");
    	URI uri = new URI(baseUrl);
    	CorretorDTO corretor = new CorretorDTO();
        HttpHeaders headers = new HttpHeaders();
  
        ResponseEntity<String> response =  this.restTemplate.getForEntity(uri, String.class);
         
        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatusCodeValue());
	}
	
	@Test
	void testaPostCorretorNovo() throws URISyntaxException {
		System.out.println("Testando POST de um corretor novo.");

    	URI uri = new URI(baseUrl);
    	
    	CorretorDTO corretor = new CorretorDTO();
    	corretor.setNome("CARLOS");
    	corretor.setCpf("333.333.333-00");
    	corretor.setEmailUsuario("teste@email.com");
    	corretor.setEndereco("Rua 1");
    	corretor.setIdade(37);
    	corretor.setPassword("123456");
    	corretor.setTelefone("119999-9999");
    	
        HttpHeaders headers = new HttpHeaders();  
        HttpEntity<CorretorDTO> request = new HttpEntity<>(corretor, headers);   
        
        ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);
         
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
	}
	
	@Test
	void testaPostCorretorNovoDadosIncompletos() throws URISyntaxException {
		System.out.println("Testando POST de um corretor novo com dados incompletos.");

    	URI uri = new URI(baseUrl);
    	
    	CorretorDTO corretor = new CorretorDTO();
    	corretor.setNome("CARLOS");
    	corretor.setCpf("333.333.333-00");
    	corretor.setIdade(37);
    	corretor.setTelefone("119999-9999");
    	
        HttpHeaders headers = new HttpHeaders();  
        HttpEntity<CorretorDTO> request = new HttpEntity<>(corretor, headers);   
        
        ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);
         
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCodeValue());
	}
	
	@Test
	void testaPostCorretorNovoDadosCompletosEGetPeloCodigo() throws URISyntaxException {
		System.out.println("Testando POST de um corretor novo com dados completos para dar GET Depois.");
    	URI uri = new URI(baseUrl);
    	
    	CorretorDTO corretor = new CorretorDTO();
    	corretor.setNome("CARLOS");
    	corretor.setCpf("333.333.333-00");
    	corretor.setEmailUsuario("teste@email.com");
    	corretor.setEndereco("Rua 1");
    	corretor.setIdade(37);
    	corretor.setPassword("123456");
    	corretor.setTelefone("119999-9999");
    	
        HttpHeaders headers = new HttpHeaders();  
        HttpEntity<CorretorDTO> request = new HttpEntity<>(corretor, headers);   
        ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);
        
        CorretorDTO corretorCriado = new Gson().fromJson(response.getBody(), CorretorDTO.class);
        
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
        
        // -----------------------------------------------------------------------------------------------
        
        URI uriRead = new URI(baseUrl + "/" + corretorCriado.getId());
  
        ResponseEntity<String> response2 =  this.restTemplate.getForEntity(uriRead, String.class);
        
        assertEquals(HttpStatus.OK.value(), response2.getStatusCodeValue());
        
        CorretorDTO corretorRecuperado = new Gson().fromJson(response2.getBody(), CorretorDTO.class);
        
        boolean corretoresIguais = corretorRecuperado.getId().equals(corretorCriado.getId());
        
        assertEquals(corretoresIguais, true);
	}
	
	@Test
	void testaAtualizaCorretorCriado() throws URISyntaxException {
		System.out.println("Testando POST de um corretor novo com dados incompletos.");

    	URI uri = new URI(baseUrl);
    	
    	CorretorDTO corretor = new CorretorDTO();
    	corretor.setNome("CARLOS");
    	corretor.setCpf("333.333.333-00");
    	corretor.setEmailUsuario("teste@email.com");
    	corretor.setEndereco("Rua 1");
    	corretor.setIdade(37);
    	corretor.setPassword("123456");
    	corretor.setTelefone("119999-9999");
    	
    	 HttpHeaders headers = new HttpHeaders();  
         HttpEntity<CorretorDTO> request = new HttpEntity<>(corretor, headers);   
         ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);
         
         CorretorDTO corretorCriado = new Gson().fromJson(response.getBody(), CorretorDTO.class);
         // Testa Criação com sucesso
         assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
         
         // -------------------------------------------------------------------------------------------------------
         corretorCriado.setCpf("444.444.444-00");
         HttpEntity<CorretorDTO> requestUpdate = new HttpEntity<>(corretorCriado, headers);
         
         ResponseEntity<String> responseUpdate = this.restTemplate.exchange(uri + "/" + corretorCriado.getId(), HttpMethod.PUT, requestUpdate, String.class);
         CorretorDTO corretorAtualizado = new Gson().fromJson(responseUpdate.getBody(), CorretorDTO.class);
         assertEquals(HttpStatus.OK.value(), responseUpdate.getStatusCodeValue());
         // Valida se o corretorAtualizado tem o CPF atualizado com o valor enviado
         assertEquals(true, corretorCriado.getCpf().equals(corretorAtualizado.getCpf()));
         // -------------------------------------------------------------------------------------------------------
	}
	
	@Test
	void testaDeletaCorretorCriado() throws URISyntaxException {
		System.out.println("Testando POST de um corretor novo com dados incompletos.");

    	URI uri = new URI(baseUrl);
    	
    	CorretorDTO corretor = new CorretorDTO();
    	corretor.setNome("CARLOS");
    	corretor.setCpf("333.333.333-00");
    	corretor.setEmailUsuario("teste@email.com");
    	corretor.setEndereco("Rua 1");
    	corretor.setIdade(37);
    	corretor.setPassword("123456");
    	corretor.setTelefone("119999-9999");
    	
    	 HttpHeaders headers = new HttpHeaders();  
         HttpEntity<CorretorDTO> request = new HttpEntity<>(corretor, headers);   
         ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);
         
         CorretorDTO corretorCriado = new Gson().fromJson(response.getBody(), CorretorDTO.class);
         // Testa Criação com sucesso
         assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
         
         // -------------------------------------------------------------------------------------------------------
         HttpEntity<CorretorDTO> requestDelete = new HttpEntity<>(corretorCriado, headers);
         
         ResponseEntity<String> responseDelete = this.restTemplate.exchange(uri + "/" + corretorCriado.getId(), HttpMethod.DELETE, requestDelete, String.class);

         assertEquals(HttpStatus.NO_CONTENT.value(), responseDelete.getStatusCodeValue());
         // -------------------------------------------------------------------------------------------------------
	}
}
