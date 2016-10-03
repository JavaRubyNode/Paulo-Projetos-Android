package br.com.faculdadedelta.projetologcat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PrincipalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		
		Log.i("Log", "Informação Verde");
		Log.w("Log", "Alertar ");
		Log.e("Log", "Erro ");
		Log.v("Log", "Verbose ");
	}
	
	public void enviar(View view) {
		EditText etNome = (EditText) findViewById(R.id.etNome);
		EditText etCpf = (EditText) findViewById(R.id.etCpf);
		EditText etIdade = (EditText) findViewById(R.id.etIdade);
		
		Toast.makeText(getBaseContext(), 
				"Nome digitado: " + etNome.getText() +
				"Cpf digitado: " + etCpf.getText() +
				"Idade digitado: " + etIdade.getText()
				, Toast.LENGTH_LONG).show();
		
		Log.i("Log", "Nome digitado: " + etNome.getText() +
				"Cpf digitado: " + etCpf.getText() +
				"Idade digitado: " + etIdade.getText());
	}
	
	public void validar(View view) {
		EditText etNome = (EditText) findViewById(R.id.etNome);
		EditText etCpf = (EditText) findViewById(R.id.etCpf);
		EditText etIdade = (EditText) findViewById(R.id.etIdade);
		String mensagem = "";
		Log.i("Log", "nome: " + etNome.getText());
		if (etNome.getText().toString().equals("")) {
			mensagem += "O campo nome não foi preechido ! ";
		}
		if (etCpf.getText().toString().equals("")) {
			mensagem += "O campo cpf não foi preechido ! ";
		}
		if (etIdade.getText().toString().equals("")) {
			mensagem += "O campo idade não foi peechido ! ";
		}
		
		Toast.makeText(getBaseContext(), mensagem, 
				Toast.LENGTH_LONG).show();
	}
	
	public void limparCampos(View view) {
		EditText etNome = (EditText) findViewById(R.id.etNome);
		EditText etCpf = (EditText) findViewById(R.id.etCpf);
		EditText etIdade = (EditText) findViewById(R.id.etIdade);
		
		etNome.setText("");
		etCpf.setText("");
		etIdade.setText("");
	}

}
