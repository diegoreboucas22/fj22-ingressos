package br.com.caelum.ingresso.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

public class Compra {

	@Id
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(cascade =CascadeType.PERSIST)
	List<Ingresso> ingressos = new ArrayList<>();
	
	
	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}
	
	public Compra(){
		
	}
	
	public Compra(List<Ingresso> ingressos){
		this.ingressos =ingressos;
	}
	
	public Compra CToCompra(){
		return new Compra(ingressos);
	}
	
}
