package br.com.projetopessoacrud.adpter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import br.com.projetopessoacrud.modelo.Pessoa;

public class PessoaAdapter extends BaseAdapter {

	private List<Pessoa> listaPessoa;
	private Context context;

	public PessoaAdapter(List<Pessoa> listaPessoa, Context context) {
		this.listaPessoa = listaPessoa;
		this.context = context;
	}

	@Override
	public int getCount() {
		return listaPessoa.size();
	}

	@Override
	public Object getItem(int position) {
		return listaPessoa.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, 
												ViewGroup parent) {
		Pessoa pessoa = (Pessoa) getItem(position);
		View view = convertView.inflate(context, 
							R.layout.item_lista_pesssoa, null);
		TextView tvId = (TextView) view.findViewById(R.id.tvId);
		tvId.setText("Id: " + pessoa.getId());
		
		TextView tvNome = (TextView) view.findViewById(R.id.tvNome);
		tvNome.setText("Nome: " + pessoa.getNome());
		
		TextView tvCpf = (TextView) view.findViewById(R.id.tvCpf);
		tvCpf.setText("Cpf: " + pessoa.getCpf());
		
		TextView tvIdade = (TextView) view.findViewById(R.id.tvIdade);
		tvIdade.setText("Idade: " + pessoa.getIdade());
		
		return view;
	}

}
