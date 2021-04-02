/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author Deyvid
 */
public class telaGameOver extends JFrame{
    
    private JLabel fundo;
    private ImageIcon imagem;

    public telaGameOver() throws HeadlessException {
        editarTela();
    }    
    
    public void editarTela(){
        imagem = new ImageIcon(getClass().getResource("/Imagens/gameOver.png"));
        fundo = new JLabel();
        fundo.setSize(500, 400);
        fundo.setIcon(imagem);
        
        
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        add(fundo);
    
    }
    
}
