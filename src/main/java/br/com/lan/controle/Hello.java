package br.com.lan.controle;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Hello {
	
	@Inject
	private CalculadoraPreco calculadora;
	
	@PostConstruct
	public void init(){
		System.out.println("Bean executado");
	}
	
	public String getMessage(){
		return "Resultado: " + String.valueOf(calculadora.calcularPreco(10, 15));
	}

}
