package com.example.projetoalex.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.projetoalex.model.Aluno;
import com.example.projetoalex.repository.AlunoRespository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRespository repository;
	
	@Transactional
	public void salva(Aluno aluno) {
		this.repository.save(aluno);
	}
	
	@Transactional(readOnly = true)
	public List<Aluno> list(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void deletar(Long id) {
		this.repository.deleteById(id);
	}
	
	@Transactional
	public Aluno buscarAluno(long id) {
		return this.repository.getOne(id);
	}
	
	@Transactional
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}
