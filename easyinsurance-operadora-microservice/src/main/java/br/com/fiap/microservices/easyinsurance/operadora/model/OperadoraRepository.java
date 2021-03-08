/**
 * 
 */
package br.com.fiap.microservices.easyinsurance.operadora.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.fiap.microservices.easyinsurance.operadora.entity.Operadora;


/**
 * @author SaraRegina
 * Com essa classe não se faz necessária a implementacao do método Service
 */
@RepositoryRestResource( path = "operadora", collectionResourceRel = "operadora")
public interface OperadoraRepository extends PagingAndSortingRepository<Operadora, Long> {

}

