package br.com.jrgf.eSocioWeb.DTO;

import java.math.BigDecimal;

import br.com.jrgf.eSocioWeb.models.Socio;

public class RequestSocio {
	
	private Integer socio_id;
	private String nome;
	private BigDecimal renda;
	private boolean ativo;
	
	public Integer getSocio_id() {
		return socio_id;
	}
	public void setSocio_id(Integer socio_id) {
		this.socio_id = socio_id;
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
	
	public Socio getSocio() {
		Socio socio = new Socio();
		socio.setId(this.socio_id);
		socio.setNome(this.nome);
		socio.setRenda(this.renda);
		socio.setAtivo(this.ativo);
		return socio;
	}
	
	public void setSocio(Socio socio) {
		this.nome = socio.getNome();
		this.ativo = socio.isAtivo();
		this.renda = socio.getRenda();
	}
	
}
