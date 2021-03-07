package br.com.fiap.microservices.easynsurance.corretor.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.microservices.easynsurance.corretor.entity.Corretor;

public interface ClienteRepository extends JpaRepository<Corretor, Long> {


}
