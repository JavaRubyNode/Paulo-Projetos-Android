package br.com.projetopessoacrud;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;
import br.com.projetopessoacrud.adpter.PessoaAdapter;
import br.com.projetopessoacrud.dao.PessoaDAO;
import br.com.projetopessoacrud.modelo.Pessoa;

public class ListaPessoaActivity extends Activity {

	private ListView lvPessoa;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_pessoa);
		
		lvPessoa = (ListView) findViewById(R.id.lvPessoa);
		
		lvPessoa.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Pessoa pessoaSelecionada 
					= (Pessoa) parent.getItemAtPosition(position);
				
				Intent intent 
					= new Intent(getBaseContext(), 
							PrincipalActivity.class);
				intent.putExtra("pessoaSelecionada", pessoaSelecionada);
				startActivity(intent);
			}
		});
		
		lvPessoa.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, 
							View view,
					int position, long id) {

				Pessoa pessoaSelecionada 
						= (Pessoa) parent.getItemAtPosition(position);
				PessoaDAO dao = new PessoaDAO();
				dao.excluir(pessoaSelecionada);
				carregarLista();
				return false;
			}
		});
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		carregarLista();
	}
	
	private void carregarLista() {
		PessoaDAO dao = new PessoaDAO();
		List<Pessoa> listaRetorno = dao.listar();
		PessoaAdapter pessoaAdapter 
				= new PessoaAdapter(listaRetorno, getBaseContext());
		lvPessoa.setAdapter(pessoaAdapter);
	}


}
