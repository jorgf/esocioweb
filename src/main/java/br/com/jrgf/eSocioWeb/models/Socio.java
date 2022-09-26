package br.com.jrgf.eSocioWeb.models;

import java.math.BigDecimal;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Socio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "socio_id")
	private Integer id;
	
	@NotBlank
	@Size(min = 5, max = 50)
	private String nome;
	
	@NotNull
	@DecimalMin(value = "0.0", inclusive = true)
	private BigDecimal renda;
	private boolean ativo;
	
	public Socio(){ }
	
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
	public BigDecimal getRenda() {
		return renda;
	}
	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
