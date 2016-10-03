package br.com.projetopatrimoniocrud;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import br.com.projetopatrimoniocrud.adapter.PatrimonioAdapter;
import br.com.projetopatrimoniocrud.dao.PatrimonioDAO;
import br.com.projetopatrimoniocrud.modelo.Patrimonio;

public class ListaActivity extends Activity {

	private ListView lvLista;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista);
		
		lvLista = (ListView) findViewById(R.id.lvLista);
		
		lvLista.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Patrimonio patrimonioSelecionado 
					= (Patrimonio) parent.getItemAtPosition(position);
				Intent intent 
				 = new Intent(getBaseContext(), PrincipalActivity.class);
				intent
				.putExtra("patrimonioSelecionado", patrimonioSelecionado);
				startActivity(intent);
			}
		});
		
		lvLista.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, 
					View view,
					int position, long id) {
				Patrimonio patrimonioSelecionado 
					= (Patrimonio) parent.getItemAtPosition(position);
				PatrimonioDAO dao = new PatrimonioDAO();
				dao.excluirPatrimonio(patrimonioSelecionado);
				
				carregarLista();
				return false;
			}
		});
	}
	
	private void carregarLista() {
		PatrimonioDAO dao = new PatrimonioDAO();
		List<Patrimonio> listaDePatrimonios 
						= dao.listarTodosPatrimonios();
		PatrimonioAdapter adapter 
			= new PatrimonioAdapter(listaDePatrimonios, getBaseContext());
		lvLista.setAdapter(adapter);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		carregarLista();
	}

}
