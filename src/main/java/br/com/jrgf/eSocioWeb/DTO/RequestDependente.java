package br.com.jrgf.eSocioWeb.DTO;

import br.com.jrgf.eSocioWeb.models.Dependente;
import br.com.jrgf.eSocioWeb.models.Socio;

public class RequestDependente {
//	private Integer id;
	private String Nome;
	private Integer idade;
	private Socio socio;
	
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
	public Dependente getDependete() {
		Dependente dependente = new Dependente();
//		dependente.setId(this.id);
		dependente.setNome(this.Nome);
		dependente.setIdade(this.idade);
		dependente.setSocio(this.socio);
		return dependente;
	}
	
	public void setDependente(Dependente dependente) {
		this.Nome = dependente.getNome();
		this.idade = dependente.getIdade();
		this.socio = dependente.getSocio();
	}
}
