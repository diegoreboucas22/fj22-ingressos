package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoParaBancos implements Desconto {

	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		// TODO Auto-generated method stub
		return precoOriginal.subtract(trintaPorcentoSobre(precoOriginal));
	}

	private BigDecimal trintaPorcentoSobre(BigDecimal precoOriginal) {
		// TODO Auto-generated method stub
		return precoOriginal.multiply(new BigDecimal("0.3"));
	}

	@Override
	public String GetDescricao() {
		return "Desconto Banco";
	}

}
