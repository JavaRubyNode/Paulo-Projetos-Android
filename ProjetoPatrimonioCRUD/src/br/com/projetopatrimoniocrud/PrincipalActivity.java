package br.com.projetopatrimoniocrud;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.com.projetopatrimoniocrud.dao.PatrimonioDAO;
import br.com.projetopatrimoniocrud.modelo.Patrimonio;

public class PrincipalActivity extends Activity {

	private Patrimonio patrimonio = new Patrimonio();
	private EditText etDescricao;
	private EditText etValor;
	private EditText etDataAquisicao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		
		etDescricao = (EditText) findViewById(R.id.etDescricao);
		etValor = (EditText) findViewById(R.id.etValor);
		etDataAquisicao = (EditText) findViewById(R.id.etDataAquisicao);
		
		Intent intent = getIntent();
		if (intent != null) {
			Patrimonio patrimonioSelecionado 
			= (Patrimonio) intent
				.getSerializableExtra("patrimonioSelecionado");
			if (patrimonioSelecionado != null) {
				preencherFormulario(patrimonioSelecionado); 
			}
		}
		
	}
	
	private void preencherFormulario(Patrimonio patrimonioSelecionado) {
		etDescricao.setText(patrimonioSelecionado.getDescricao());
		etValor.setText(patrimonioSelecionado.getValor() + "");
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		etDataAquisicao.setText(
				formatador.format(patrimonioSelecionado.getDataAquisicao()));
		patrimonio.setId(patrimonioSelecionado.getId());
	}
	
	private void preecherPatrimonio() {
		patrimonio.setDescricao(etDescricao.getText().toString());
		double valorConvertido 
			= Double.valueOf(etValor.getText().toString());
		patrimonio.setValor(valorConvertido);
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date dataConvertida = null;
		
		try {
			dataConvertida 
				= formatador.parse(etDataAquisicao.getText().toString());
			patrimonio.setDataAquisicao(dataConvertida);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(View view) {
		String mensagemErro = validarCampos();
		if (mensagemErro.equals("")) {
			preecherPatrimonio();
			if (patrimonio.getId() == null) {
				PatrimonioDAO dao = new PatrimonioDAO();
				dao.incluirPatrimonio(patrimonio);
			} else {
				PatrimonioDAO dao = new PatrimonioDAO();
				dao.alterarPatrimonio(patrimonio);
			}
			limparCampos();
		} else {
			Toast.makeText(getBaseContext(), 
					mensagemErro, Toast.LENGTH_LONG).show();
		}
		
	}
	
	public String validarCampos() {
		String mensagem = "";
		if (etDescricao.getText().toString().equals("")) {
			mensagem += "O campo descrição é obrigatorio ! ";
		}
		if (etValor.getText().toString().equals("")) {
			mensagem += "\nO campo valor é obrigatorio !";
		}
		if (etDataAquisicao.getText().toString().equals("")) {
			mensagem += "\nO campo data é obrigatorio !";
		}
		return mensagem;
	}
	
	private void limparCampos() {
		etDescricao.setText("");
		etValor.setText("");
		etDataAquisicao.setText("");
		patrimonio = new Patrimonio();
	}

	public void listar(View view) {
		Intent intent 
			= new Intent(getBaseContext(), ListaActivity.class);
		startActivity(intent);
	}
	
	public void limpar(View view) {
		limparCampos();
	}
}
