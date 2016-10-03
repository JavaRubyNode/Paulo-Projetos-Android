package br.com.projetopatrimoniocrud.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.projetopatrimoniocrud.modelo.Patrimonio;

public class PatrimonioDAO {

	private static List<Patrimonio> listaDePatrimonios 
										= new ArrayList<Patrimonio>();
	private static Long idGerador = 1L;
	
	public void incluirPatrimonio(Patrimonio patrimonio) {
		patrimonio.setId(idGerador++);
		listaDePatrimonios.add(patrimonio);
	}
	
	public void excluirPatrimonio(Patrimonio patrimonio) {
		listaDePatrimonios.remove(patrimonio);
	}
	
	public void alterarPatrimonio(Patrimonio patrimonio) {
		for (Patrimonio patrimonioAux : listaDePatrimonios) {
			long idPatrimonio = patrimonio.getId();
			long idPatrimonioAux = patrimonioAux.getId();
			if (idPatrimonio == idPatrimonioAux) {
				listaDePatrimonios.remove(patrimonioAux);
				listaDePatrimonios.add(patrimonio);
			}
		}
	}
	
	public List<Patrimonio> listarTodosPatrimonios() {
		return listaDePatrimonios;
	}
}
