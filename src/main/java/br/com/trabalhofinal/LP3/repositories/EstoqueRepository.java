package br.com.trabalhofinal.LP3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trabalhofinal.LP3.entities.EstoqueEntities;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueEntities, Integer>{
	
	EstoqueEntities findByProduto(Integer id);
}