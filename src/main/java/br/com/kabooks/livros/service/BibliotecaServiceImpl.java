package br.com.kabooks.livros.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.kabooks.livros.model.Biblioteca;
import br.com.kabooks.livros.repo.BibliotecaRepo;

@Component
public class BibliotecaServiceImpl implements IBibliotecaService {
	@Autowired
	private BibliotecaRepo repo;

	@Override
	public ArrayList<Biblioteca> recuperarTodos() {
		return (ArrayList<Biblioteca>) repo.findAll();

	}

	@Override
	public Biblioteca recuperarPeloId(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Biblioteca cadastrarNovo(Biblioteca novo) {
		return repo.save(novo);
	}

	@Override
	public ArrayList<Biblioteca> recuperarPeloTitulo(String palavraChave) {
		// TODO Auto-generated method stub
		return repo.findByTituloContaining(palavraChave);
	}
}
//livros (GET) para recuperar todos os livros
//livros/{id} (GET) para recuperar 1 único livro
//livros/busca?palavra (GET) para recuperar livros por palavra-chave do título
//livros (POST) para cadastrar novo livro