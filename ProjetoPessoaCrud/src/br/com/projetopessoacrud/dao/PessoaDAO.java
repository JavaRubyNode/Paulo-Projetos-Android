package br.com.projetopessoacrud.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.projetopessoacrud.modelo.Pessoa;

public class PessoaDAO {

	private static List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
	private static Long idGerador = 1L;
	
	public void incluir(Pessoa pessoa) {
		pessoa.setId(idGerador++);
		listaPessoa.add(pessoa);
	}
	
	public void excluir(Pessoa pessoa) {
		listaPessoa.remove(pessoa);
	}
	
	public void alterar(Pessoa pessoa) {
		
		for (Pessoa pessoaAux : listaPessoa) {
			long idPessoa = pessoa.getId();
			long idPessoaAux = pessoaAux.getId();
			if (idPessoa == idPessoaAux) {
				listaPessoa.remove(pessoaAux);
				listaPessoa.add(pessoa);
			}
		}
	}
	
	public List<Pessoa> listar() {
		return listaPessoa;
	}
}
