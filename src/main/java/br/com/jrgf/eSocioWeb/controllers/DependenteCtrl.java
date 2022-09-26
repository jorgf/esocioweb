package br.com.jrgf.eSocioWeb.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jrgf.eSocioWeb.DependenteRepository;
import br.com.jrgf.eSocioWeb.DTO.RequestDependente;
import br.com.jrgf.eSocioWeb.models.Dependente;

@Controller
@RequestMapping("/dependentes")
public class DependenteCtrl {
	
	@Autowired
	private DependenteRepository dependenteRepository;
	
	@GetMapping("")
	public ModelAndView index() { // listar todos os usuários
		ModelAndView mv = new ModelAndView("dependentes/list");
		List<Dependente> dependente = this.dependenteRepository.findAll();
		mv.addObject("dependentes", dependente);
		return mv;		
	}
	
	@GetMapping("/cadastro") // retorna o form de cadastro
	public String cadastro() {
		return "dependentes/formCreate";
	}
	
	@GetMapping("{id}/edit") //retorna o form de atualizacao
	public ModelAndView edit(@PathVariable Integer id, RequestDependente reqDependente){
		Optional<Dependente> optional = this.dependenteRepository.findById(id);
		if(optional.isPresent()) {
			Dependente dependente = optional.get();
			reqDependente.setDependente(dependente);
			ModelAndView mv = new ModelAndView("dependentes/formUpdate");
			mv.addObject("RequestDependente", reqDependente);
			mv.addObject("dependenteId", dependente.getId());
			return mv;
			
		} else {
			ModelAndView mv = new ModelAndView("error");
			return mv;
		}
	}
	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable Integer id) {
		Optional<Dependente> optional = this.dependenteRepository.findById(id);
		if(optional.isPresent()) {
			this.dependenteRepository.deleteById(id);
			return "sucess";
		} else {
			return "error";
		}
	}
	
	@PostMapping("") // salvar dados do form - criar um socio
	public String create(@Valid RequestDependente reqDependente, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("::: TEM ERROS !! :::");
			return "error";
		} else {
			this.dependenteRepository.save(reqDependente.getDependete());
			return "sucess";			
		}
	}
	
	@PostMapping("/{id}")
	public String udpate(@PathVariable Integer id, @Valid RequestDependente req, BindingResult result) {
		Optional<Dependente> optional = this.dependenteRepository.findById(id);
		if ( optional.isPresent() ) {
			Dependente dependente = optional.get();
			dependente.setNome(req.getNome());
			dependente.setIdade(req.getIdade());
			dependente.setSocioResponsavel(req.getSocioResponsavel());
			this.dependenteRepository.save(dependente);
			return "sucess";
		}else {
			return "error";				
		}
		
	}
}
