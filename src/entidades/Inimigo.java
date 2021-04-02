
package entidades;

import javax.swing.JLabel;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

public class Inimigo {
    
    private int cont;
    private boolean visivel;
    private int x,y;
    private int altura = 52,largura = 40;
    private int dy;
    private ImageIcon iconInimigo;

    public JLabel j = new JLabel();

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }
    
    public int getDy(){
        return dy;
    }
    
    public void setDy(int dy){
        this.dy = dy;
    }
    
    public Inimigo(int n){
        Random rn = new Random();
        this.cont = n;
        this.x = (rn.nextInt(650)+1);
        this.y = -30-((cont+1)*100);
        this.dy = 0;
        this.visivel = true;
        iconInimigo = new ImageIcon(getClass().getResource("/Imagens/Inimigo - 01.png"));
        j.setIcon(iconInimigo);
        this.j.setBounds(this.x, this.y, this.largura, this.altura);
        //j.setBorder(new BevelBorder(1));
    }
       
}
