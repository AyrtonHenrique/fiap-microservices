package br.com.fiap.microservices.easynsurance.cliente.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.microservices.easynsurance.cliente.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}
