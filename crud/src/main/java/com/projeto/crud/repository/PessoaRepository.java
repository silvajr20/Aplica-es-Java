package com.projeto.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.crud.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	
	
}
