package br.com.fiap.microservices.easynsurance.corretor.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.microservices.easynsurance.corretor.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}
