package br.com.caelum.ingresso.validacao;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;


public class SessaoTest {

	@Test
	public void oPrecodaSessaoDeveSerIgualaSomaDaSalaMaisOPrecodoFilme(){
		
		Sala sala= new Sala("Matrix", new BigDecimal("22.00"));
		Filme filme= new Filme("Matrix",Duration.ofMinutes(120),"Ação",new BigDecimal("22.00"));
		
		BigDecimal somadosPrecosSalaeFilme = sala.getPreco().add(filme.getPreco());
		
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"),filme,sala);
		
		Assert.assertEquals(somadosPrecosSalaeFilme, sessao.getPreco());
				
	}
	
}
