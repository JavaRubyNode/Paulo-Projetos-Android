package br.com.projetoparametrosentreactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Principal extends Activity {
	
	public static final int TELA_PRINCIPAL = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
	}
	
	public void enviar(View view) {
		EditText etNome = (EditText) findViewById(R.id.etNome);
		EditText etCpf = (EditText) findViewById(R.id.etCpf);
		EditText etIdade = (EditText) findViewById(R.id.etIdade);
		
		Intent intent 
			= new Intent(getBaseContext(), ValidacaoActivity.class);
		
		intent.putExtra("nomeParam", etNome.getText().toString());
		intent.putExtra("cpfParam", etCpf.getText().toString());
		intent.putExtra("idadeParam", etIdade.getText().toString());
		
		startActivityForResult(intent, TELA_PRINCIPAL);
	}
	
	@Override
	protected void onActivityResult(int requestCode, 
								int resultCode, Intent data) {
		if (requestCode == TELA_PRINCIPAL) {
			if (resultCode == ValidacaoActivity.SUCESSO) {
				String mensagem 
						= data.getStringExtra("mensagemRetorno");
				Toast.makeText(getBaseContext(),
						        mensagem, 
								Toast.LENGTH_LONG).show();
			}
		}
	}

}
