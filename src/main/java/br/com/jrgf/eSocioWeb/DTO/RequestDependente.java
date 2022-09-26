package br.com.jrgf.eSocioWeb.DTO;

import br.com.jrgf.eSocioWeb.models.Dependente;

public class RequestDependente {
//	private Integer id;
	private String Nome;
	private Integer idade;
	private Integer socioResponsavel;
	
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
	public Integer getSocioResponsavel() {
		return socioResponsavel;
	}
	public void setSocioResponsavel(Integer socioResponsavel) {
		this.socioResponsavel = socioResponsavel;
	}
	
	public Dependente getDependete() {
		Dependente dependente = new Dependente();
//		dependente.setId(this.id);
		dependente.setNome(this.Nome);
		dependente.setIdade(this.idade);
		dependente.setSocioResponsavel(this.socioResponsavel);
		return dependente;
	}
	
	public void setDependente(Dependente dependente) {
		this.Nome = dependente.getNome();
		this.idade = dependente.getIdade();
		this.socioResponsavel = dependente.getSocioResponsavel();
	}
}
