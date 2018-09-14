package br.com.caelum.ingresso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.dao.LugarDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.Carrinho;
import br.com.caelum.ingresso.model.Cartao;
import br.com.caelum.ingresso.model.form.CarrinhoForm;

@Controller
public class CompraController {

	@Autowired
	private SessaoDao sessaDao;

	@Autowired
	private LugarDao lugarDao;
	
	@Autowired
	private Carrinho carrinho;

	@PostMapping("/compra/ingressos")
	public ModelAndView enviarParaPagamento(CarrinhoForm carrinhoForm) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/compra");
		carrinhoForm.toIngressos(sessaDao, lugarDao).forEach(carrinho::add);
		return modelAndView;
	}
	
	@GetMapping("/compra")
	public ModelAndView checkout(Cartao cartao) {
		
		ModelAndView modelAndView = new ModelAndView("compra/pagamento");
		modelAndView.addObject("carrinho", carrinho);
		return modelAndView;
	}
	
	@PostMapping("/compra/comprar")
	public ModelAndView comprar(Cartao cartao) {
		
		ModelAndView modelAndView = new ModelAndView("compra/pagamento");
		modelAndView.addObject("carrinho", carrinho);
		return modelAndView;
	}
}
