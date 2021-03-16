/**
 * 
 */
package br.com.fiap.microservices.easyinsurance.operadora.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data; 



/**
 * @author SaraRegina
 *
 */
@Data
@Entity
@Table(name = "tb_operadora")
public class Operadora  {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("razaoSocialOperdora")
    @Column(nullable = false)
    private String razaoSocialOperdora;

    @JsonProperty("codigoRegistroAns")
    @Column(nullable = false)
    private Long codigoRegistroAns;

    @JsonProperty("cnpj") 
    @Column(nullable = false)
    private Long cnpj;
    
    @JsonProperty("nomeFantasia") 
    private String nomeFantasia;
    
    @JsonProperty("modalidade") 
    private String modalidade;
    
}
