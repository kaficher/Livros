package br.com.kabooks.livros.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.kabooks.livros.model.Biblioteca;

public interface BibliotecaRepo extends CrudRepository<Biblioteca, Integer> {
//	public ArrayList<Biblioteca> findAll();

	public ArrayList<Biblioteca> findByOrderByTitulo();

	public ArrayList<Biblioteca> findByTituloContaining(String titulo);

	// /livros (GET) para recuperar todos os livros
	// /livros/{id} (GET) para recuperar 1 único livro
	// /livros/busca?palavra (GET) para recuperar livros por palavra-chave do título
	// /livros (POST) para cadastrar novo livro
}
