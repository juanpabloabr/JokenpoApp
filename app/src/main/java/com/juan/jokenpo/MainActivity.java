package com.juan.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView resultado = findViewById(R.id.text_resultado);
        resultado.setText("");
    }

    public void selecionarPedra(View view){
        verificarGanhador("pedra");
    }

    public void selecionarPapel(View view){
        verificarGanhador("papel");
    }

    public void selecionarTesoura(View view){
        verificarGanhador("tesoura");
    }

    private void verificarGanhador(String escolhaUsuario){
        String escolhaApp = gerarEscolhaAleatoriaApp();
        TextView textoResultado = findViewById(R.id.text_resultado);
        if (escolhaApp == escolhaUsuario){
            textoResultado.setText("Empate :|");
        }
        else if (
            (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
            (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
            (escolhaApp == "tesoura" && escolhaUsuario == "papel")) {
            textoResultado.setText("Você Perdeu Seu Lixo :(");

        }
        else{
            textoResultado.setText("Venceu XD!");

        }
    }

    private String gerarEscolhaAleatoriaApp(){
        ImageView imagemApp = findViewById(R.id.imagemEscolhaApp); //configurar uma nova imagem em imagemEscolhaApp

        String[] opcoes = {"pedra","papel","tesoura"};
        int numeroAleatorio = new Random().nextInt(3);
        String escolhaApp = opcoes[numeroAleatorio];
        switch (escolhaApp){
            case "pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaApp;
    }

}