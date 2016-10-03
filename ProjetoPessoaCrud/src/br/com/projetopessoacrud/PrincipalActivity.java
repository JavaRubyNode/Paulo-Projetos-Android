package br.com.projetopessoacrud;

import br.com.projetopessoacrud.dao.PessoaDAO;
import br.com.projetopessoacrud.modelo.Pessoa;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

// C O N T R O L L E R 
public class PrincipalActivity extends Activity {

	private Pessoa pessoa = new Pessoa();
	private EditText etNome;
	private EditText etCpf;
	private EditText etIdade;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		
		etNome = (EditText) findViewById(R.id.etNome);
		etCpf = (EditText) findViewById(R.id.etCPF);
		etIdade = (EditText) findViewById(R.id.etIdade);
		
		Intent intent = getIntent();
		if (intent != null) {
			Pessoa pessoaSelecionada 
			= (Pessoa) intent.getSerializableExtra("pessoaSelecionada");
			if (pessoaSelecionada != null) {
				preencherFormulario(pessoaSelecionada);
			}
		}
	}

	private void preecherPessoa() {
		pessoa.setNome(etNome.getText().toString());
		pessoa.setCpf(etCpf.getText().toString());
		try {
			pessoa.setIdade(Integer.valueOf(etIdade.getText().toString()));
		} catch (Exception e) {
		}
	}
	
	private void preencherFormulario(Pessoa pessoaSelecionada) {
		etNome.setText(pessoaSelecionada.getNome());
		etCpf.setText(pessoaSelecionada.getCpf());
		etIdade.setText(String.valueOf(pessoaSelecionada.getIdade()));
		pessoa.setId(pessoaSelecionada.getId());
	}

	private void limparCampos() {
		etNome.setText("");
		etCpf.setText("");
		etIdade.setText("");
		pessoa = new Pessoa();
	}
	
	public void salvar(View view) {
		PessoaDAO dao = new PessoaDAO();
		preecherPessoa();
		if (pessoa.getId() == null) {
			dao.incluir(pessoa);
		} else {
			dao.alterar(pessoa);
		}
		limparCampos();
	}
	
	public void listar(View view) {
		Intent intent = new Intent(getBaseContext(), 
					ListaPessoaActivity.class);
		startActivity(intent);
	}
	
	public void limpar(View view) {
		limparCampos();
	}
}
