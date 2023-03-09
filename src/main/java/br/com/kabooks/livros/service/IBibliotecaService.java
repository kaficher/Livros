package br.com.kabooks.livros.service;

import java.util.ArrayList;

import br.com.kabooks.livros.model.Biblioteca;

public interface IBibliotecaService {

	public ArrayList<Biblioteca> recuperarTodos();

	public Biblioteca recuperarPeloId(int id);

	public ArrayList<Biblioteca> recuperarPeloTitulo(String palavraChave);

	public Biblioteca cadastrarNovo(Biblioteca novo);

}

//livros (GET) para recuperar todos os livros
//livros/{id} (GET) para recuperar 1 único livro
//livros/busca?palavra (GET) para recuperar livros por palavra-chave do título
//livros (POST) para cadastrar novo livro
