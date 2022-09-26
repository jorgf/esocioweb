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

import br.com.jrgf.eSocioWeb.SocioRepository;
import br.com.jrgf.eSocioWeb.DTO.RequestSocio;
import br.com.jrgf.eSocioWeb.models.Socio;

@Controller
@RequestMapping("/socios")
public class SocioCtrl {
	@Autowired
	private SocioRepository socioRepository; 
	
	@GetMapping("")
	public ModelAndView index() { // listar todos os usuários
		ModelAndView mv = new ModelAndView("socios/listSocio");
		List<Socio> socios = this.socioRepository.findAll();
		mv.addObject("socios", socios);
		return mv;		
	}
	
	@GetMapping("/cadastro") // retorna o form de cadastro
	public String cadastro() {
		return "socios/formCreate";
	}
	
	@GetMapping("{id}/edit") // retorna o form de atualizacao
	public ModelAndView edit(@PathVariable Integer id, RequestSocio reqSocio) {
		Optional<Socio> optional = this.socioRepository.findById(id);
		if(optional.isPresent()) {
			ModelAndView mv = new ModelAndView("socios/formUpdate");
			Socio socioEdit = optional.get();
			reqSocio.setSocio(socioEdit);
			mv.addObject("RequestSocio", reqSocio);
			mv.addObject("socioId", socioEdit.getId());
			return mv;
			
		} else {
			ModelAndView mv = new ModelAndView("error");
			return mv;
		}
		
	}
	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable Integer id) {
		Optional<Socio> optional = this.socioRepository.findById(id);
		if(optional.isPresent()) {
			this.socioRepository.deleteById(id);
			return "sucess";
		} else {
			return "error";
		}
	}
	
	@PostMapping("") // salvar dados do form - criar um socio
	public String create(@Valid RequestSocio reqSocio, BindingResult result) {
		if(result.hasErrors()) {
			return "error";
		} else {
			this.socioRepository.save(reqSocio.getSocio());
			return "sucess";			
		}
	}
	
	@PostMapping("/{id}")
	public String udpate(@PathVariable Integer id, @Valid RequestSocio reqSocio, BindingResult result) {
		Optional<Socio> optional = this.socioRepository.findById(id);
		if ( optional.isPresent() ) {
			Socio socio = optional.get();
			socio.setNome(reqSocio.getNome());
			socio.setAtivo(reqSocio.isAtivo());
			socio.setRenda(reqSocio.getRenda());
			this.socioRepository.save(socio);
			return "sucess";
		}else {
			return "error";				
		}
		
	}
	
}
