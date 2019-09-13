package com.example.projetoalex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoalex.model.Aluno;

@Repository
public interface AlunoRespository extends JpaRepository<Aluno, Long> {

}
