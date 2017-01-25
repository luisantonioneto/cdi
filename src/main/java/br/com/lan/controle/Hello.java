package br.com.lan.controle;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lan.persistencia.Conexao;

@Named
@RequestScoped
public class Hello {
	
	@Inject
	private CalculadoraPreco calculadora;
	
	@Inject
	private Conexao conexao;
	
	@PostConstruct
	public void init(){		
		System.out.println("Bean executado");
		conexao.abrirConexao();
	}
	
	public String getMessage(){
		return "Resultado: " + String.valueOf(calculadora.calcularPreco(10, 15));
	}

}
