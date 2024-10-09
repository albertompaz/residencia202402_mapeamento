package br.org.serratec.mapeamento.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {
	
	@Value("${minha-propriedade}")
	private String propriedadeCustomizada;

	@GetMapping("/teste")
	public String retornaMinhaPropriedade() {
		return propriedadeCustomizada;
	}
	
}
