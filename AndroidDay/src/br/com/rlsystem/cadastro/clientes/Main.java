package br.com.rlsystem.cadastro.clientes;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void ListarClientesClick(View v){
    	Intent it = new Intent(getBaseContext(), ListarActivity.class);
    	startActivity(it);
    }
    
    public void CadastrarClienteClick(View v){
    	Intent it = new Intent(getBaseContext(), Inserir.class);
    	startActivity(it);
    }
}