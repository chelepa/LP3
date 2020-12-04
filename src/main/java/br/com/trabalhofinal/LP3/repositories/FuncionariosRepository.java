package br.com.trabalhofinal.LP3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trabalhofinal.LP3.entities.FuncionariosEntities;

@Repository
public interface FuncionariosRepository extends JpaRepository<FuncionariosEntities, Integer>{

}