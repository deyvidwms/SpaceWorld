package gui;

import entidades.Inimigo;
import entidades.Personagem;
import entidades.Tiro;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class telaFase extends JFrame implements ActionListener {

    private Personagem personagem = null;
    public ArrayList<Inimigo> InimigosF1;
    private Tiro tiro = null;
    private Timer timer;
    private JLabel contTiros;
    private JLabel contInimigos;
    private JLabel contIniciar;
    
   
    public telaFase() {
        addKeyListener(new teclado());
        editarTelaFase();
        InimigosF1 = new ArrayList();
        personagem = new Personagem();
        timer = new Timer(5, this);
        timer.start();
        contTiros = new JLabel();
        contInimigos = new JLabel();
        contIniciar = new JLabel();
        add(personagem);
        add(contTiros);
        add(contInimigos);
        add(contIniciar);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        personagem.addMovimento();
        repaint();
    }
    
    public void checarColisao() {
        Rectangle formaNave = personagem.getBounds();
        Rectangle formaInimigo;
        Rectangle formaTiro;

        for (int i = 0; i < InimigosF1.size(); i++) {
            Inimigo tempInimigo = InimigosF1.get(i);
            formaInimigo = new Rectangle(tempInimigo.j.getX(),tempInimigo.j.getY(),tempInimigo.j.getWidth(),tempInimigo.j.getHeight());
            //System.out.println("iX - "+tempInimigo.j.getX()+" iY - "+tempInimigo.j.getY()+"Inimigo: "+i);
            if(formaNave.intersects(formaInimigo)){
                tempInimigo.j.setVisible(false);
                InimigosF1.clear();
                
                remove(personagem);
                
                telaGameOver t = new telaGameOver();
                t.setVisible(true);
                dispose();
                
                //System.out.println("PosicaoInimigo: "+i+" - "+formaInimigo.getBounds());
                //System.out.println("PosicaoNave: "+formaNave.getBounds());
                //JOptionPane.showMessageDialog(this, "Você Perdeu!");
                
                //System.exit(0);
            }
        }

        ArrayList<Tiro> listaTiro = personagem.getTiros();

        for(int i = 0; i < listaTiro.size();i++){

            Tiro tempTiro = listaTiro.get(i);
            formaTiro = tempTiro.j.getBounds();
            
            for(int k = 0; k < InimigosF1.size(); k++){
                
                Inimigo tempInimigo = InimigosF1.get(k);
                formaInimigo = tempInimigo.j.getBounds();
                
                if(formaTiro.intersects(formaInimigo)){
                    System.out.println("");
                    tempInimigo.j.setVisible(false);
                    InimigosF1.remove(k);
                    
                    tempTiro.j.setVisible(false);
                    listaTiro.remove(i);
                    
                    if(InimigosF1.size() == 0){
                        telaVitoria t = new telaVitoria();
                        t.setVisible(true);
                        dispose();
                    }
                    
                }
                
            }
            
        }
        repaint();
        
    }
    
    public void editarContadores(Personagem p){
        contInimigos.setBounds(0, 0, 75, 10);
        contInimigos.setForeground(Color.WHITE);
        contInimigos.setText("Inimigos: "+InimigosF1.size());
        contTiros.setBounds(0, 15, 50, 10);
        contTiros.setForeground(Color.WHITE);
        contTiros.setText("Tiros: " + (3-p.tiros.size()) + "x");
    }
    
    public void contadorIniciar(){
        contIniciar.setBounds(325, 260, 80, 20);
        contIniciar.setForeground(Color.WHITE);
        contIniciar.setFont(new Font("Dialog", Font.ITALIC, 14));
        contIniciar.setText("3");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(telaFase.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
        contIniciar.setText("2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(telaFase.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
        contIniciar.setText("1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(telaFase.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
        contIniciar.setText("Começou!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(telaFase.class.getName()).log(Level.SEVERE, null, ex);
        }
        remove(contIniciar);
        repaint();
    }

    public void gerarInimigos() {
        Runnable runnable = new Runnable() {
            public void run() {
                for (int n = 0; n < 10; n++) {
                    Inimigo i = new Inimigo(n);
                    i.setCont(n);
                    InimigosF1.add(i);
                    add(i.j);
                    //System.out.println("Posição: " + i.getX() + ", Numero: " + i.getCont());
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(telaFase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    repaint();
                }
            }

        };
        runnable.run();
    }
    //Criei esse metodo para colocar todos os metodos que vão ficar em constante
    //repetição como os movimentos e o checar colisão
    public void gerarRepeticoes(){
        while(true){
            editarContadores(personagem);
            movimentarInimigos(InimigosF1);
            movimentarTiros(personagem);
            checarColisao();
        }
    }

    public void movimentarInimigos(ArrayList<Inimigo> ListaI) {
        Runnable t = new Runnable() {
            @Override
            public void run() {
                int timer=1;
                int sizei = ListaI.size();
            for (int i = 0; i < ListaI.size(); i++) {
                ListaI.get(i).j.setBounds(ListaI.get(i).getX(), ListaI.get(i).getY() + ListaI.get(i).getDy(), ListaI.get(i).getLargura(), ListaI.get(i).getAltura());  
                if(ListaI.size() <= 10 && ListaI.size() >= 7){
                    ListaI.get(i).setDy(ListaI.get(i).getDy() + 8);
                }else if(ListaI.size() < 7 && ListaI.size() >= 4){
                    ListaI.get(i).setDy(ListaI.get(i).getDy() + 6);
                }else if(ListaI.size() < 4 && ListaI.size() >= 1){
                    ListaI.get(i).setDy(ListaI.get(i).getDy() +3);
                }else{
                    ListaI.get(i).setDy(ListaI.get(i).getDy() +2);
                }
                try {
                    if(sizei-ListaI.size()<ListaI.size()+1/2){
                        timer=5;
                    }
                    Thread.sleep(timer);
                } catch (InterruptedException ex) {
                    Logger.getLogger(telaFase.class.getName()).log(Level.SEVERE, null, ex);
                }
                    if (ListaI.get(i).j.getY() >= 550) {
                        ListaI.get(i).setDy((ListaI.get(i).getY()*-1)-60);
                    }
                        
                }

                
            }

        };
        t.run();
    }
    
    public void movimentarTiros(Personagem p){
        ArrayList<Tiro> tiros = p.getTiros();
        for(int i = 0;i<tiros.size();i++){
            add(tiros.get(i).j);
            tiros.get(i).j.setBounds(tiros.get(i).getX(),tiros.get(i).getY()-tiros.get(i).getDy(),tiros.get(i).getLargura(),tiros.get(i).getAltura());
            tiros.get(i).setDy(tiros.get(i).getDy()+10);
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(telaFase.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(tiros.get(i).j.getY() <= -10){
                remove(tiros.get(i).j);
                tiros.remove(i);
            }
            repaint();
        }
    }

    private void editarTelaFase() {
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(720, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
    }

    private class teclado extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent ke) {
            personagem.keyPressed(ke); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            personagem.keyReleased(ke); //To change body of generated methods, choose Tools | Templates.
        }

    }

}
