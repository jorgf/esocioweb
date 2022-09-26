package br.com.jrgf.eSocioWeb.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Dependente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@Size(min = 5, max = 50)
	private String nome;
	@Min(0)
	private Integer idade;
	@NotNull
	private Integer idSocioResponsavel;
	
	public Dependente(){ }
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Integer getSocioResponsavel() {
		return idSocioResponsavel;
	}

	public void setSocioResponsavel(Integer socioId) {
		this.idSocioResponsavel = socioId;
	}
	
	
}
