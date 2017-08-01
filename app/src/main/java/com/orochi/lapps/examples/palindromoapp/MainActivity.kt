package com.orochi.lapps.examples.palindromoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

fun String.isPalindromo(): Boolean{
    val palavra: String = this.toLowerCase();
    return palavra.reversed() == palavra;
}
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtPalavra.afterTextChanged {
            val palavra = txtPalavra.getText().toString();
            val resposta = getResposta(palavra);
            lblResposta.setText(resposta);
        }
    }

    fun getResposta(palavra: String) : String{
        val resposta = if (palavra.isNullOrEmpty()) {
            "Insira sua palavra acima.";
        }else{
            if(palavra.isPalindromo()) "Esta palavra é palindroma!"  else "Esta palavra não é palindroma!";
        }
        return resposta;
    }
}
