package br.com.projetopatrimoniocrud.adapter;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.SimpleFormatter;

import br.com.projetopatrimoniocrud.R;
import br.com.projetopatrimoniocrud.modelo.Patrimonio;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PatrimonioAdapter extends BaseAdapter {

	private List<Patrimonio> listaDePatrimonio;
	private Context context;
	
	public PatrimonioAdapter(List<Patrimonio> listaDePatrimonio, 
			Context context) {
		super();
		this.listaDePatrimonio = listaDePatrimonio;
		this.context = context;
	}

	@Override
	public int getCount() {
		return listaDePatrimonio.size();
	}

	@Override
	public Object getItem(int position) {
		return listaDePatrimonio.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, 
			ViewGroup parent) {
		Patrimonio patrimonio = (Patrimonio) getItem(position);
		View view = convertView.inflate(context, 
						R.layout.item_lista_patrimonio, null);
		TextView tvDescicao 
			= (TextView) view.findViewById(R.id.tvDescricao);
		tvDescicao.setText("Descrição: " + patrimonio.getDescricao());
		
		TextView tvId = (TextView) view.findViewById(R.id.tvId);
		tvId.setText("Id: " + patrimonio.getId());
		
		TextView tvValor = (TextView) view.findViewById(R.id.tvValor);
		tvValor.setText("Valor: " + patrimonio.getValor());
		
		TextView tvData 
			= (TextView) view.findViewById(R.id.tvDataAquisicao);
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		tvData.setText("Aquisição: " 
				+ formatador.format(patrimonio.getDataAquisicao()));
		
		return view;
	}

}
