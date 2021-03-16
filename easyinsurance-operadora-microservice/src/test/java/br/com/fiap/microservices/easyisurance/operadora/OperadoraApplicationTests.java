package br.com.fiap.microservices.easyisurance.operadora;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpStatus;

import br.com.fiap.microservices.easyinsurance.operadora.OperadoraApplication;
import br.com.fiap.microservices.easyinsurance.operadora.entity.Operadora;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = OperadoraApplication.class)
@AutoConfigureWebMvc
public class OperadoraApplicationTests {

 	@Autowired
    private TestRestTemplate restTemplate;
     
    @LocalServerPort
    int randomServerPort;
    
    @Test
    public void testeCriandoOperadora() throws URISyntaxException 
    {
    	final String baseUrl = "http://localhost:"+randomServerPort+"/easyinsurance/operadora";
    	URI uri = new URI(baseUrl);
    	Operadora operadora = new Operadora();
    	
    	operadora.setRazaoSocialOperdora("CAIXA DE ASSISTÊNCIA DO SETOR DE ENERGIA -EVIDA");
    	operadora.setCnpj(123456789000812l);
    	operadora.setCodigoRegistroAns(418374l);
    	operadora.setNomeFantasia("E-VIDA");
    	operadora.setModalidade("Autogestão");
    	
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      
 
        HttpEntity<Operadora> request = new HttpEntity<>(operadora, headers);
         
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
         
        assertEquals(201, result.getStatusCodeValue());
    }
    
    
    @Test
    public void testeCriandoPlanoValoresNulos() throws URISyntaxException 
    {
    	final String baseUrl = "http://localhost:"+randomServerPort+"/easyinsurance/operadora";
        URI uri = new URI(baseUrl);
    	Operadora operadora = new Operadora();
    	
    	operadora.setRazaoSocialOperdora("CAIXA DE ASSISTÊNCIA DO SETOR DE ENERGIA -EVIDA");
    	operadora.setCnpj(null);
    	operadora.setCodigoRegistroAns(418374l);
    	operadora.setNomeFantasia("E-VIDA");
    	operadora.setModalidade("Autogestão");
         
        HttpHeaders headers = new HttpHeaders();
 
        HttpEntity<Operadora> request = new HttpEntity<>(operadora, headers);
         
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
         
        
        assertEquals(HttpStatus.SC_CONFLICT, result.getStatusCodeValue());
        assertEquals(false, result.getBody().contains("Missing request header"));
    }

    
    @Test
    public void testeConsultarOperadoraServico() throws URISyntaxException {
    	final String baseUrl = "http://localhost:"+randomServerPort+"/easyinsurance/operadora";
    	ResponseEntity<String> result = this.restTemplate.getForEntity(baseUrl, String.class);
    	assertEquals(result.getStatusCodeValue(), HttpStatus.SC_OK);
    }
    
    @Test
    public void testeConsultarUnicoPlano() throws URISyntaxException {
    	final String baseUrl = "http://localhost:"+randomServerPort+"/easyinsurance/operadora";
    	ResponseEntity<String> result = this.restTemplate.getForEntity(baseUrl + "/1", String.class);
    	assertEquals(result.getStatusCodeValue(), HttpStatus.SC_OK);
    }
    
    
    
}	

