package com.example.projetoalex.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.projetoalex.model.Aluno;
import com.example.projetoalex.service.AlunoService;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping("/novo")
	public ModelAndView novo(Aluno aluno) {
		ModelAndView mv = new ModelAndView("alunos/add");
		mv.addObject("aluno", aluno);
		
		return mv;
	}
	
	@GetMapping("/lista")
	public ModelAndView list(Aluno aluno) {
		ModelAndView mv = new ModelAndView("alunos/lista");
		mv.addObject("alunos", this.service.list());
		
		return mv;
	}
	
	@PostMapping("/salva")
	public ModelAndView salva(@Valid Aluno aluno, BindingResult result ) {
		ModelAndView mv = new ModelAndView("redirect:/alunos/lista");
		if(result.hasErrors()) {
			return novo(aluno);
		}
		
		this.service.salva(aluno);
		
		return mv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(service.buscarAluno(id));
		}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/alunos/lista");
		this.service.delete(id);
		attributes.addFlashAttribute("mensagem", "Médico deletado com sucesso");
		return mv;
	}


}
