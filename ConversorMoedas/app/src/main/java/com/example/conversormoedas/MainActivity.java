package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pegando os elementos...
        this.mViewHolder.editText = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        // limpando os valores para não aparecer as strings...
        this.clearValues();
    }

    private void clearValues() {
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calculate) { // o botão chamou o evento...
            String value = this.mViewHolder.editText.getText().toString();
            if (value.equals("")) {
                // mostra mensagem...
                Toast.makeText(this, this.getString(R.string.informe_valor),Toast.LENGTH_LONG).show();
            } else {
                Double real = Double.valueOf(value);

                this.mViewHolder.textDolar.setText(String.format("%.2f",(real / 4)));
                this.mViewHolder.textEuro.setText(String.format("%.2f",(real / 5)));
            }
        }
    }

    private static class ViewHolder{
        EditText editText;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
    }
}
