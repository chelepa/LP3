package br.com.trabalhofinal.LP3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trabalhofinal.LP3.entities.ItensVendaEntities;

@Repository
public interface ItensVendaRepository extends JpaRepository<ItensVendaEntities, Integer>{
	
	List<ItensVendaEntities> findByCodigoVenda(Integer codigoVenda);
}