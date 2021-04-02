package main;

import gui.telaFase;
import musica.Servicos;

public class Teste {

    public static void main(String[] args) {

        telaFase t = new telaFase();
        t.setVisible(true);
        
        Servicos.mp3.start();
        t.contadorIniciar();
        t.gerarInimigos();
        t.gerarRepeticoes();        
        
    }
    
}
