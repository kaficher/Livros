package br.com.kabooks.livros.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.loja.dto.MensagemErro;
import br.com.kabooks.livros.model.Biblioteca;
import br.com.kabooks.livros.service.IBibliotecaService;

@RestController
public class BibliotecaController {

	@Autowired
	private IBibliotecaService service;

	@GetMapping("/biblioteca")
	public ArrayList<Biblioteca> recuperarTodos() {
		return service.recuperarTodos();
	}

	@GetMapping("/biblioteca/{id}")
	public ResponseEntity<Biblioteca> recuperarPeloId(@PathVariable int id) {
		Biblioteca b = service.recuperarPeloId(id);
		if (b != null) {
			return ResponseEntity.ok(b);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/biblioteca/busca")
	public ResponseEntity<?> buscarPeloTitulo(@RequestParam(name = "palavra") String palavra) {
		ArrayList<Biblioteca> lista = service.recuperarPeloTitulo(palavra);
		if (lista.size() > 0) {
			return ResponseEntity.ok(lista);
		}
		return ResponseEntity.status(404).body(new MensagemErro(999, "ERRO"));
	}

	@PostMapping("/biblioteca")
	public ResponseEntity<Biblioteca> cadastrarNovo(@RequestBody Biblioteca b){
		Biblioteca res = service.cadastrarNovo(b);
		if (res !=null) {
			return ResponseEntity.status(201).body(res);
		}
		return ResponseEntity.badRequest().build();
	}

	// /livros (GET) para recuperar todos os livros
	// /livros/{id} (GET) para recuperar 1 único livro
	// /livros/busca?palavra (GET) para recuperar livros por palavra-chave do título
	// /livros (POST) para cadastrar novo livro
}
