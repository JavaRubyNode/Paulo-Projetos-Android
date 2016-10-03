package br.com.projetoparametrosentreactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ValidacaoActivity extends Activity {
	
	public static final int SUCESSO = 1;
	private String nome;
	private String cpf;
	private Integer idade;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_validacao);
		
		Intent intent = getIntent();
		if (intent != null) {
			nome = intent.getStringExtra("nomeParam");
			cpf = intent.getStringExtra("cpfParam");
			
			if (!intent.getStringExtra("idadeParam").equals("")) {
				idade 
				= Integer.parseInt(intent.getStringExtra("idadeParam"));
			} else {
				idade = 0;
			}
			
//			try {
//				idade 
//				= Integer.parseInt(intent.getStringExtra("idadeParam"));
//			} catch (Exception e) {
//				idade = 0;
//			}
			
			TextView tvNome = (TextView) findViewById(R.id.tvNome);
			tvNome.setText("Nome: " + nome);
			
			TextView tvCpf = (TextView) findViewById(R.id.tvCpf);
			tvCpf.setText("CPF: " + cpf);
			
			TextView tvIdade = (TextView) findViewById(R.id.tvIdade);
			tvIdade.setText("Idade: " + idade);
		}
	}
	
	public void validar(View view) {
		String mensagem = "";
		if (idade > 10) {
			mensagem = "A validada";
		} else {
			mensagem = "A idade deve ser maior que 10.";
		}
		
		Intent intent = new Intent();
		intent.putExtra("mensagemRetorno", mensagem);
		setResult(SUCESSO, intent);
		finish();
	}

}
