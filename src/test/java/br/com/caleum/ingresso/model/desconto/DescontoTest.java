package br.com.caleum.ingresso.model.desconto;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;
import br.com.caelum.ingresso.model.descontos.DescontoParaBancos;
import br.com.caelum.ingresso.model.descontos.DescontoParaEstudantes;
import br.com.caelum.ingresso.model.descontos.SemDesconto;


public class DescontoTest {
	
	@Test
	public void naoDeveConcederDescontoparaIngressoNormal(){
		Lugar lugar = new Lugar("A",1);
		
		Sala sala = new Sala("Teste",new BigDecimal("20.50"));
		Filme filme = new Filme("Tom e Jerry",Duration.ofMinutes(120),"Desenho",new BigDecimal("12"));
		
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"),filme,sala);
		Ingresso ingresso = new Ingresso(sessao,TipoDeIngresso.INTEIRO,lugar);
		
		BigDecimal precoEsperado= new BigDecimal("32.50");
		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
		
	}
		@Test
		public void DeveConcederDescontode30PorcentoaIngressoDeClientesDebanco(){
			Lugar lugar = new Lugar("A",1);
			Sala sala = new Sala("Teste",new BigDecimal("20.50"));
			Filme filme = new Filme("Tom e Jerry",Duration.ofMinutes(120),"Desenho",new BigDecimal("12"));
			
			Sessao sessao = new Sessao(LocalTime.parse("10:00:00"),filme,sala);
			Ingresso ingresso = new Ingresso(sessao,TipoDeIngresso.BANCO,lugar);
			
			BigDecimal precoEsperado= new BigDecimal("22.75");
			
			Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
		
		
		@Test
		public void DeveConcederDescontode50PorcentoaIngressoDeClientesEstudantes(){
			Lugar lugar = new Lugar("A",1);
			Sala sala = new Sala("Teste",new BigDecimal("20.50"));
			Filme filme = new Filme("Tom e Jerry",Duration.ofMinutes(120),"Desenho",new BigDecimal("12"));
			
			Sessao sessao = new Sessao(LocalTime.parse("10:00:00"),filme,sala);
			Ingresso ingresso = new Ingresso(sessao,TipoDeIngresso.ESTUDANTE,lugar);
			
			BigDecimal precoEsperado= new BigDecimal("16.25");
			
			Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

}
