package br.com.trabalhofinal.LP3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trabalhofinal.LP3.entities.CidadesEntities;

@Repository
public interface CidadesRepository extends JpaRepository<CidadesEntities, Integer>{

}